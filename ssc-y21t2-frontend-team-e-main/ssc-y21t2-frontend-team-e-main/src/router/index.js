import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/Home.vue";
import store from "@/store";

Vue.use(VueRouter);

const routes = [
  {
    path: "/assignment",
    name: "Home",
    component: HomeView,
  },
  {
    path: "/register",
    name: "Register",
    component: () => import("../views/Register.vue"),
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/login",
    name: "Login",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Login.vue"),
  },
];

const router = new VueRouter({mode: 'history',
  routes,
});
// Setup beforeEach hook
router.beforeEach(async (to, from, next) => {
  // get login state using whomai and axios
  let response = await Vue.prototype.$http.get("/api/whoami");
  // response.data is our payload
  await store.dispatch("setLoggedInUser", response.data);
  let isLoggedIn = store.state.isLoggedIn;
  //make sure if user is logged, user will not able to see login page
  if (to.name === "Login" && isLoggedIn) {
    next({ name: "Home" });
  }
  //if the name of the router is not Login, it needs authorization to access the page
  if (to.name !== "Login" && to.name !== "Register" && to.name !== "About" && !isLoggedIn) {
    //redirect to login page
    next({ name: "Login" });
  } else {
    // otherwise let go
    next();
  }



});




export default router;
