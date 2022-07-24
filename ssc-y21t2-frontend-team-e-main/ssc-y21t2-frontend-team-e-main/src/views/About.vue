<template>
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
        <v-btn text class="ml-2" to="/about">About</v-btn>
        <v-btn text class="ml-2" to="/register">Register</v-btn>
        <!--      <v-btn text class="ml-2">Profile</v-btn>-->
        <v-btn text class="ml-2" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ"><v-icon class="mr-2">fa-solid fa-phone</v-icon> Contact</v-btn>

      </v-app-bar>
    </nav>
    <div class="about">
      <h1>This is an about page</h1>
      <b-container class="bv-example-row">
        <b-row>
          <b-col>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias dolor fugiat magni necessitatibus provident quis rerum temporibus? Distinctio enim laborum maiores nostrum sequi! Accusamus alias consectetur eaque earum harum id laboriosam, molestiae, nihil, nisi provident tenetur vero. Dolore, eaque impedit.</b-col>
          <b-col>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias dolor fugiat magni necessitatibus provident quis rerum temporibus? Distinctio enim laborum maiores nostrum sequi! Accusamus alias consectetur eaque earum harum id laboriosam, molestiae, nihil, nisi provident tenetur vero. Dolore, eaque impedit.</b-col>
          <b-col>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias dolor fugiat magni necessitatibus provident quis rerum temporibus? Distinctio enim laborum maiores nostrum sequi! Accusamus alias consectetur eaque earum harum id laboriosam, molestiae, nihil, nisi provident tenetur vero. Dolore, eaque impedit.</b-col>
        </b-row>
      </b-container>
    </div>
  </v-container>
</template>

<script>
import NavBar from "../component/NavBar.vue";
export default {
name: "About",
components: {
// eslint-disable-next-line vue/no-unused-components
NavBar
},

data: () => ({
//
}),

methods: {
async logout() {
let response = await this.$http.get("/api/logout");
if (response.data.success) {
await this.$store.dispatch("clearUser");
await this.$router.push({ path: "/login" });
}
},
},
};
</script>
