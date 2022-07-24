import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id:null,
    isLoggedIn: false,
    username: null,
    name: null,
    role: "",
    lineID: null,
    email: null,
    discordWebHook: null,
    todoList: null,
    todoID:null,



  },
  mutations: {
    setID(state,id) {
      state.id= id;
    },
   setIsLoggedIn(state, isLoggedIn) {
      state.isLoggedIn = isLoggedIn;
    },
    setUsername(state, username) {
      state.username = username;
    },
    setName(state, name) {
      state.name = name;
    },
    setRole(state, role) {
      state.role = role;
    },
    setLineID(state, lineID) {
      state.lineID = lineID;
    },
    setContent(state, content) {
      state.content=  content;
    },
    setCompleted(state, completed) {
      state.completed = completed;
    },
    setTodoID(state, todoID) {
      state.todoID = todoID;
    },
    setEmail(state, email) {
      state.email = email;
    },
    setDiscordWebHook(state, discordWebHook) {
      state.discordWebHook = discordWebHook;
    },
  },
  actions: {
    setLoggedInUser({ commit }, payload) {
      commit("setIsLoggedIn", payload.loggedIn);
      commit("setUsername", payload.username);
      commit("setName", payload.name);
      commit("setRole", payload.role);
      commit("setID", payload.id);
      commit("setDiscordWebHook", payload.discordWebHook);
    },
    clearUser({ commit }) {
      commit("setIsLoggedIn", false);
      commit("setUsername", null);
      commit("setName", null);
      commit("setRole", "");
      commit("setID", "");
    },
    setRegisterUser({ commit }, payload) {
      commit("setIsLoggedIn", payload.loggedIn);
      commit("setUsername", payload.username);
      commit("setName", payload.name);
      commit("setRole", payload.role);
      commit("setID", payload.id);
      commit("setLineID", payload.lineID);
      commit("setEmail", payload.email);
      commit("setDiscordWebHook", payload.discordWebHook);
    },
    setTodoListUser({ commit }, payload) {
      commit("setTodoID", payload.todoID);
      commit("setContent", payload.content);
      commit("setCompleted", payload.completed);
    },


  },
  modules: {},
});
