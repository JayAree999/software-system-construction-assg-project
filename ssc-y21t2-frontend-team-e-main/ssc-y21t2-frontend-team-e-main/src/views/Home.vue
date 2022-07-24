<template>
<v-container>
  <nav-bar />
  <h1>Assignments</h1>

  <div>
    <v-dialog
      v-model="dialog"
      persistent
      max-width="600px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          class="green darken-4"
          dark
          v-bind="attrs"
          v-on="on"
        >
          <v-icon class="mr-2">fa-solid fa-briefcase</v-icon>

           Add Assignment
        </v-btn>

        <v-btn @click="sendNotification()" depressed color="red">
          <v-icon>fa-solid fa-bell</v-icon> <div style="color:white; margin-left: 5px"> Test Notification</div>
        </v-btn>
      </template>

      <v-card>
        <v-card-title class = "green darken-4">
          <span class="text-h5" style="color:white">Add Assignment</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col>
                <v-text-field
                  id="example-datepicker"
                  v-model="content"
                  :rules="[(v) => !!v || 'Add is required']"
                  label="Add todo *"
                  required
                >
                </v-text-field>
              </v-col>
            </v-row>
            <row>
              <label>Choose a date *</label>
            </row>
            <b-form-datepicker  v-model="date" class="mb-2"></b-form-datepicker>
          </v-container>
          <div>
            <label>Notify at *</label>
          </div>

          <small
            class="red--text">*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            class="amber darken-1"
            @click="closeButton"
          >
            Close
          </v-btn>
          <v-btn :disabled="this.content == null || this.date == null " class="mx-2"  color="light green" @click="addTodo">
            ADD
          </v-btn>

        </v-card-actions>
      </v-card>
    </v-dialog>

  </div>


  <template>

  <div>
    <b-table striped hover
             :items="items" :fields="fields"
             :sort-by.sync="sortBy"
             :sort-desc.sync="sortDesc"
             responsive="sm"
             ref="selectableTable"
             selectable
             @row-selected="onRowSelected">
      <template #cell(selected)="{ rowSelected }">
        <template v-if="rowSelected">
          <span aria-hidden="true">&check;</span>
          <span class="sr-only">Selected</span>
        </template>
        <template v-else>
          <span aria-hidden="true">&nbsp;</span>
          <span class="sr-only">Not selected</span>
        </template>
      </template>

      <template #cell(content)="data">
        <b-form-input v-if="items[data.index].isEdit" type="text" v-model="items[data.index].content"></b-form-input>
        <span v-else>{{data.value}}</span>
      </template>

      <template #cell(dueDate)="data">
        <b-form-datepicker v-if="items[data.index].isEdit" v-model="items[data.index].dueDate"></b-form-datepicker>
        <span v-else>{{data.value}}</span>
      </template>


      <template #cell(edit)="data">

        <!--            <b-button-->
        <!--              class="amber darken-1"-->
        <!--              @click="editRowHandler(data)">-->
        <!--              <div v-if="!items[data.index].isEdit">Edit</div>-->
        <!--              <div v-else>-->
        <!--                  Save-->
        <!--              </div>-->
        <!--            </b-button>-->

        <div>
          <v-btn
            class="editButton"
            fab
            dark
            color="cyan"
            @click="editRowHandler(data)">
            <div v-if="!items[data.index].isEdit">
              <v-icon dark>
                mdi-pencil
              </v-icon>
            </div>
            <div v-else>
              <v-icon dark>
                fa-solid fa-floppy-disk
              </v-icon>

            </div>
          </v-btn>
        </div>


      </template>

    </b-table>
  </div>



      <b-button size="sm" @click="selectAllRows"><v-icon>fa-solid fa-check-double</v-icon> Select all</b-button>
    <b-button size="sm" @click="clearSelected"><v-icon>fa-solid fa-arrow-rotate-left</v-icon>Clear selected</b-button>
      <b-button variant="danger" size="sm" @click="deleteTodos">Delete <v-icon>fa-solid fa-trash-can</v-icon></b-button>

  </template>

</v-container>

</template>


<script>
import NavBar from "@/component/NavBar";
import Footer from "../component/Footer.vue";

export default {
  name: "Home",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    Footer,
    NavBar
  },
  data() {

    return {
      dialog: false,
      sortBy: 'dueDate',
      sortDesc: false,
      fields: [
        {key: 'selected', sortable: false},
        {key: 'content', sortable: true},
        {key: 'dueDate', sortable: true},
        {key: 'edit', sortable: false},
        ],
      selected: [],
      content: null,
      items: [],
      listID: [],
      date: null,
      send: [],

      itemMsg: ""


    }
  },
  methods: {
    closeButton(){
      this.content = null;
      this.date = null;
      this.dialog = false;
    },

    getTodos() {
      this.$http.get('/api/users/' + this.$store.state.id)
          .then((response) => {
            this.items = response.data.todoList;
            this.items = this.items.map(item => ({...item, isEdit: false}));
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    async editRowHandler(data) {

      this.items[data.index].isEdit = !this.items[data.index].isEdit;

      let response = await this.$http.post("/api/users/" + this.$store.state.id + "/todos/edit", {
        "id": this.items[data.index].todoID,
        "content": this.items[data.index].content,
        "dueDate": this.items[data.index].dueDate,
      }, {
        headers: {
          // 'application/json' is the modern content-type for JSON, but some
          // older servers may use 'text/json'.
          // See: http://bit.ly/text-json
          'content-type': 'application/json'
        }
      })
      console.log(response)

    },

    async deleteTodos() {
      for (let i = 0; i < this.selected.length; i++) {
        this.listID.push(this.selected[i].todoID)
      }
      console.log(this.listID)


      let response = await this.$http.post("/api/users/" + this.$store.state.id + "/todos/delete", {
        "ids": this.listID
      }, {
        headers: {
          // 'application/json' is the modern content-type for JSON, but some
          // older servers may use 'text/json'.
          // See: http://bit.ly/text-json
          'content-type': 'application/json'
        }
      })
      this.listID.splice(0)
      console.log(response)
      this.getTodos()

    },
    async addTodo() {
      this.dialog = false
      let response = await this.$http.post("/api/users/" + this.$store.state.id + "/todos/", {
        "content": this.content,
        "dueDate": this.date,
      }, {
        headers: {
          // 'application/json' is the modern content-type for JSON, but some
          // older servers may use 'text/json'.
          // See: http://bit.ly/text-json
          'content-type': 'application/json'
        }
      })
      console.log(response)

      this.getTodos()

    },

    sendNotification() {


      const message="Good morning, "+ this.$store.state.username+ "!\n" +
          "Sending notification to your Webhook URL"

      const messageData = {

        content: message,

      };

      const sendMessage = () => {
        this.$http
            .post(this.$store.state.discordWebHook, messageData)
            .then(function (response) {
              console.log(response);
              console.log(process.argv);
            })
            .catch(function (error) {
              console.log(error);
            });
      };

      sendMessage();
      this.send.splice(0);

    },

    onRowSelected(items) {
      this.selected = items
    },
    selectAllRows() {
      this.$refs.selectableTable.selectAllRows()
    },
    clearSelected() {
      this.$refs.selectableTable.clearSelected()
    },
  },
  mounted() {
    this.getTodos();
    this.items = this.items.map(item => ({...item, isEdit: false}));
  },
};
</script>

<style scoped>

#example-datepicker{
  height: 20px;
}


button{
  padding: 5px;
  margin: 5px;
}

i.v-icon.v-icon {
  color: white;
}
.input-941{
  width: 50%;
}
p{
  margin-left: 80%;
}
.mx-2 {
  color: white;
}

</style>