<template>
  <v-container >
  <nav >
    <v-app-bar app color=#00000 >
      <router-link to="/assignment">
        <v-img :src="require('../assets/ddc.png')" aspect-ratio="1" width="65" height="65" contain></v-img>
      </router-link>

      <router-link to="/assignment">
        <v-img :src="require('../assets/new.png')"   class="ml-2" aspect-ratio="1" width="250" height="40" contain></v-img>
      </router-link>

      <v-spacer></v-spacer>
      <v-btn text class="ml-2" to="/about">About</v-btn>
      <v-btn text class="ml-2" to="/register">Register</v-btn>
      <!--      <v-btn text class="ml-2">Profile</v-btn>-->
      <v-btn text class="ml-2">Contact</v-btn>

    </v-app-bar>
  </nav>


    <v-form ref="form" v-model="valid" lazy-validation>

      <div class="red" v-if="this.isUnique === false">
        Username is already exist!!!
      </div>

      <v-row>
        <v-col>
          <v-text-field
            v-model="email"
            :rules="[
              (v) => !!v || 'E-mail is required',
              (v) => /.+@.+/.test(v) || 'E-mail must be valid',
              ]"
            label="E-mail"
            required
            outlined
          ></v-text-field>
        </v-col>
        <v-col>
          <v-text-field
            v-model="lineID"
            :rules="[(v) => !!v || 'Line ID is required']"
            label="Line ID"
            required
            outlined
          ></v-text-field>
        </v-col>
      </v-row>




      <v-text-field
        v-model="username"
        :rules="[(v) => !!v || 'Username is required']"
        label="Username"
        required
        outlined
      ></v-text-field>

      <v-row>
        <v-col>
          <v-text-field
            type="password"
            v-model="password"
            :rules="[(v) => !!v || 'Password is required']"
            label="Password"
            required
            outlined
          ></v-text-field>
        </v-col>

        <v-col>
          <v-text-field
            type="password"
            v-model="confirmPassword"
            :rules="[
        (v) => !!v || 'Password is required',
        this.password === this.confirmPassword || 'Password must match',
      ]"
            label="Confirm Password"
            required
            outlined
          ></v-text-field>
        </v-col>
      </v-row>

      <v-text-field
        v-model="discordWebHook"
        :rules="[(v) => !!v || 'Discord Webhook is required']"
        label="Discord Webhook url"
        required
        outlined
      ></v-text-field>

      <v-btn :disabled="!isDisable(email,username,password,lineID,discordWebHook) || !valid" color="success"  class="mr-4" @click="regis">
        Sign-Up
      </v-btn>
    </v-form>

  </v-container>

</template>



<script>

import store from "@/store";

export default {
  data: () => ({
    width:300,
    valid: true,
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
    lineID: "",
    discordWebHook: "",
    isUnique: true,
  }),

  methods: {
    async regis() {
      //submit to backend to authenticate
      let formData = new FormData();
      formData.append("username", this.username);
      formData.append("password", this.password);
      formData.append("lineID", this.lineID);
      formData.append("discordWebHook", this.discordWebHook);
      formData.append("email", this.email);
      let response = await this.$http.post("/api/result_register", formData);
      // need to update states by calling whoami
      if (response.data.success) {
        await store.dispatch("setRegisterUser", response.data);
        this.$router.push("/");
      } else {
        this.isUnique = false
        setTimeout(() => { this.$router.go();}, 5000);

      }
    },

    isDisable(email, username, password, lineID, discordWebHook,) {
      return email.length > 0 && username.length > 0 && password.length>0 && lineID.length > 0 && discordWebHook.length > 0;
    },
  },

};
</script>

<style scoped>

.mr-4{
  margin-bottom: 50px;
}

.div.colpic1.col{
  width: 150px;
}

</style>