<template>

<!--  <div :style="myStyle" id="wrapper">-->

  <v-container>

    <nav >

      <v-app-bar app  >

        <router-link to="/assignment">
          <v-img :src="require('../assets/ddc.png')" aspect-ratio="1" width="55" height="55" contain></v-img>
        </router-link>

        <router-link to="/assignment">
          <v-img :src="require('../assets/new.png')"   class="ml-2" aspect-ratio="1" width="250" height="40" contain></v-img>
        </router-link>


        <v-spacer></v-spacer>
        <v-switch
            class="mt-5"
            v-model="switchTheme"
            inset
            color="blue ligthen-1"
            @click="toggleTheme"
            :label="`Theme: ${switchTheme ? 'Light' : 'Dark'}`"
        ></v-switch>
        <v-btn text class="ml-2" to="/about">About</v-btn>
        <v-btn text class="ml-2" to="/register">Register</v-btn>
        <!--      <v-btn text class="ml-2">Profile</v-btn>-->
        <v-btn text class="ml-2" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"><v-icon class="mr-2">fa-solid fa-phone</v-icon> Contact</v-btn>

      </v-app-bar>
    </nav>

      <div class="d-flex justify-content-center h-75" >
        <div class="col col-sm-10 col-md-6 col-lg-4 my-auto">

          <v-img :src="require('../assets/ddc.png')" aspect-ratio="1" max-width="300" class="v-image v-responsive ml-100 mb-8 mx-auto theme--light ml-25 mb-8 mx-auto"></v-img>
          <v-spacer> </v-spacer>
<!--          <div :style="myStyle1" id="wrapper2" >-->
            <v-img :src="require('../assets/new.png')" aspect-ratio="1"
                   contain
                   height="100px"
                   width="600px"></v-img>
<!--          </div>-->
        </div>

      </div>

      <b-modal id="modal1" title="Forgot Password">
        <b-img src="https://ih0.redbubble.net/image.418429827.6579/ap,550x550,12x16,1,transparent,t.u4.png" fluid alt="Responsive image" />
      </b-modal>

      <v-row class="row justify-content-md-center">
        <v-col cols="5">
          <v-card class="p-3">
            <h3 class="mb-4">Login</h3>
            <div style="color:red" v-if="this.isFail === false">
              Wrong Username or Password
            </div>
            <v-form ref="form" v-model="valid" lazy-validation>
        <v-text-field
          v-model="username"
          :rules="[(v) => !!v || 'Username is required']"
          label="Username"
          required
        ></v-text-field>

        <v-text-field
          type="password"
          v-model="password"
          :rules="passwordRules"
          label="Password"
          required
        ></v-text-field>
        <v-row>


          <router-link to="/register">Click here to sign up</router-link>

            <v-btn color="success" @click="submit" class="right-auto">
              Login
            </v-btn>

        </v-row>
      </v-form>

          </v-card>
        </v-col>
      </v-row>
  </v-container>

<!--  </div>-->

</template>


<script>

import Footer from "@/component/Footer";
export default {
  // eslint-disable-next-line vue/no-unused-components
  components: {Footer},
  data: () => ({
    valid: true,
    username: "",
    password: "",
    isFail: true,
    passwordRules: [(v) => !!v || "Password is required"],
  }),

  methods: {
    async submit() {

      if (this.$refs.form.validate()) {
        //submit to backend to authenticate
        let formData = new FormData();
        formData.append("username", this.username);
        formData.append("password", this.password);
        let response = await this.$http.post("/api/login", formData);
        // need to update states by calling whoami
        if (response.data.success) {
          await this.$router.push({ path: "/assignment" });
        } else {
          this.isFail = false
          setTimeout(() => { this.$router.go();}, 5000);
        }
      }

    },

  },

};
</script>

<style>
/*#wrapper{*/
/*  !*background-color: black;*!*/
/*  display: flex;*/
/*  height: 100%;*/
/*  justify-content: center;*/
/*  align-items: center;*/
/*  flex-direction: column;*/
/*}*/

/*#wrapper2{*/
/*  !*background-color: cornflowerblue;*!*/
/*  display: flex;*/
/*  height: 100%;*/
/*  justify-content: center;*/
/*  align-items: center;*/
/*  padding-left: 30px;*/
/*  padding-right: 30px;*/
/*  !*flex-direction: column;*!*/
/*}*/

.right-auto{
  margin: auto;
  margin-top: 20px;
}

</style>
