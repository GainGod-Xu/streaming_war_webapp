import Vue from "vue";
import VueRouter from "vue-router";
import mycontent from "../components/content.vue";
import DashboardPage from "../components/users/dashboard.vue";
import RegisterPage from "../components/users/register.vue";
import SigninPage from "../components/users/login.vue";
import Createdemo from "../components/users/createdemo.vue";
import Updatedemo from "../components/users/updatedemo.vue";
import Displaydemo from "../components/users/displaydemo.vue";
import Displayevent from "../components/users/displayevent.vue";
import Createevent from "../components/users/createevent.vue";
import Watchevent from "../components/users/watchevent.vue";
import Updateevent from "../components/users/updateevent.vue";
import Displaystream from "../components/users/displaystream.vue";
import Createstream from "../components/users/createstream.vue";
import Updatestream from "../components/users/updatestream.vue";
import Createstudio from "../components/users/createstudio.vue";
import Displaystudio from "../components/users/displaystudio.vue";
import Createoffer from "../components/users/createoffer.vue";
import Displayoffer from "../components/users/displayoffer.vue";
import Retractoffer from "../components/users/retractoffer.vue";
import Displayarchive from "../components/users/displayarchive.vue";


Vue.use(VueRouter);

const routes = [
  { path: "/", name: "Home", component: mycontent },
  { path: "/register", name: "Register", component: RegisterPage },
  { path: "/login", name: "Login", component: SigninPage },
  { path: "/dashboard", name: "Dashboard", component: DashboardPage },
  { path: "*", redirect: "/" },
  { path: "/createdemo", name: "createdemo", component: Createdemo },
  { path: "/updatedemo", name: "updatedemo", component: Updatedemo },
  { path: "/displaydemo", name: "displaydemo", component: Displaydemo },
  { path: "/displayevent", name: "displayevent", component: Displayevent },
  { path: "/createevent", name: "createevent", component: Createevent },
  { path: "/updateevent", name: "updateevent", component: Updateevent },
  { path: "/displaystream", name: "displaystream", component: Displaystream },
  { path: "/createstream", name: "createstream", component: Createstream },
  { path: "/updatestream", name: "updatestream", component: Updatestream },
  { path: "/createstudio", name: "createstudio", component: Createstudio },
  { path: "/displaystudio", name: "displaystudio", component: Displaystudio },
  { path: "/createoffer", name: "createoffer", component: Createoffer },
  { path: "/displayoffer", name: "displayoffer", component: Displayoffer },
  { path: "/retractoffer", name: "retractoffer", component: Retractoffer },
  { path: "/watchevent", name: "watchevent", component: Watchevent },
  { path: "/displayarchive", name: "displayarchive", component: Displayarchive }

];

export default new VueRouter({ mode: "history", routes });
