<template>
  <nav>
<!--    <v-system-bar app dark>-->
<!--      <v-spacer></v-spacer>-->
<!--      <v-icon>mdi-minus</v-icon>-->
<!--      <v-icon>mdi-checkbox-blank-outline</v-icon>-->
<!--      <v-icon>mdi-close</v-icon>-->
<!--    </v-system-bar>-->
    <v-app-bar app color>
<!--      <v-icon class="mr-2">fas fa-video</v-icon>-->
<!--      <v-toolbar-title>AAE Movie</v-toolbar-title>-->
      <router-link to="/assignment">
      <v-img :src="require('../assets/ddc.png')" aspect-ratio="1" width="55" height="55" contain class="mr-2"></v-img>
      </router-link>

      <router-link to="/assignment">
      <v-img :src="require('../assets/new.png')" aspect-ratio="1" width="250" height="40" contain></v-img>
      </router-link>

      <v-btn text class="ml-2" to="/about">About</v-btn>
      <v-btn text class="ml-2" to="/register">Register</v-btn>
<!--      <v-btn text class="ml-2">Profile</v-btn>-->
      <v-btn text class="ml-2"><v-icon class="mr2">fa-solid fa-phone</v-icon> Contact</v-btn>
      <v-spacer></v-spacer>
<!--      <v-autocomplete-->
<!--          clearable-->
<!--          hide-no-data-->
<!--          hide-selected-->
<!--          color="white"-->
<!--          label="search"-->
<!--          prepend-inner-icon="search"-->
<!--          flat-->
<!--          :items="movies"-->
<!--          item-text="title"-->
<!--          item-value="id"-->
<!--          id="search"-->
<!--      >-->
<!--        <template v-slot:item="{item}">-->
<!--          <v-btn text :to="`/movie/${item.id}`">{{item.title}}</v-btn>-->
<!--        </template>-->
<!--      </v-autocomplete>-->
<!--      <v-btn icon>-->
<!--        <v-badge color="green" content="2" overlap>-->
<!--          <v-icon>far fa-bell</v-icon>-->
<!--        </v-badge>-->
<!--      </v-btn>-->
<!--      <v-badge bordered bottom color="green" dot offset-x="10" offset-y="10">-->
<!--        <v-avatar size="40">-->
<!--          <v-img src="https://cdn.vuetifyjs.com/images/lists/2.jpg"></v-img>-->
<!--        </v-avatar>-->
<!--      </v-badge>-->
<!--            <v-toolbar-items class="hidden-sm-and-down">-->
<!--                <v-btn flat>link one</v-btn>-->
<!--            </v-toolbar-items>-->
            <v-btn href="" target="_blank" text>
              <span class="mr-2">{{ $store.state.name }}</span>
              <v-icon>fas fa-user-check</v-icon>
            </v-btn>

            <v-btn color="success" class="mr-4" @click="logout">
              Sign Out
              <v-icon>fa-solid fa-person-running</v-icon>

            </v-btn>

    </v-app-bar>
  </nav>
</template>

<script>
export default {
  components: {},

  data:()=>({
    drawer:null,
    model:'',
  }),

  methods: {
    async logout() {
      let response = await this.$http.get("/api/logout");
      if (response.data.success) {
        await this.$store.dispatch("clearUser");
        await this.$router.push({ path: "/login" });
      }
    },
  }
}
</script>

<style>
</style>