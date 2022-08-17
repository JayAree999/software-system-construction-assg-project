<template>


  <v-app style="
    background: #3A1C71;
    background: -webkit-linear-gradient(to right, #FFAF7B, #D76D77, #3A1C71);
    background: linear-gradient(to right, #FFAF7B, #D76D77, #3A1C71);">

    <v-main >
      <router-view />
    </v-main>

    <Footer />
  </v-app>
</template>

<script>

import Footer from "./component/Footer.vue";
export default {
  name: "App",
  components: {
    // eslint-disable-next-line vue/no-unused-components
    Footer
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
