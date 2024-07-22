import Vue from "vue";
import Vuelidate from "vuelidate";
import App from "./App.vue";
import router from "./router";
import vuetify from "./plugins/vuetify";

import store from "./store/store";
import myfooter from "./components/footer.vue";
import mycontent from "./components/content.vue";
import mynav from "./components/sidenav.vue";

Vue.use(Vuelidate);

Vue.config.productionTip = false;
Vue.component("myfooter", myfooter);
Vue.component("mycontent", mycontent);
Vue.component("mynav", mynav);

new Vue({
  router,
  vuetify,
  store,
  render: h => h(App)
}).$mount("#app");
