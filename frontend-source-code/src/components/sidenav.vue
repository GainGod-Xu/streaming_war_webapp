/* eslint-disable no-unneeded-ternary */
<template>
  <v-navigation-drawer app expand-on-hover permanent>
    <!-- v-model="drawer"  -->
    <v-list dense flat>
      <v-list-item link v-for="link in filterdList" :key="link.text" :to="link.route">
        <v-list-item-action>
          <v-icon>{{ link.icon }}</v-icon>
        </v-list-item-action>
        <v-list-item-content>
          <v-list-item-title>{{ link.text }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-list-item v-if="auth" @click="onLogout" id="logout">
        <v-list-item-action>
          <v-icon>mdi-logout-variant</v-icon>
        </v-list-item-action>
        <v-list-item-content>
          <v-list-item-title>Logout</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {
  computed: {    
    auth() {
      return !this.$store.getters.isAuth ? false : this.$store.getters.isAuth;
    },
    filterdList() {
      return this.links.filter(item => item.requireAuth === this.auth);
    }
  },
  methods: {
    onLogout() {
      this.$store.dispatch('logout');
    }
  },
  data() {
    return {
      links: [
        {
          icon: "mdi-pencil",
          text: "Register",
          route: "/register",
          requireAuth: false
        },
        {
          icon: "mdi-account",
          text: "Login",
          route: "/login",
          requireAuth: false
        },
        {
          icon: "mdi-view-dashboard",
          text: "Dashboard",
          route: "/dashboard",
          requireAuth: true
        },
        {
          icon: "mdi-archive-arrow-up-outline",
          text: "Display Archive",
          route: "/displayarchive",
          requireAuth: true
        }
      ]
    };
  }
};
</script>
<style scoped>
#logout {
  margin: auto;
  top: 68vh;
  /* bottom: 0%; */
}
</style>
