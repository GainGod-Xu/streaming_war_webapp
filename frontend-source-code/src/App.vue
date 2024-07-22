<template>
  <v-app id="inspire">
    <mynav></mynav>
    <router-view></router-view>
    <myfooter></myfooter>
  </v-app>
</template>

<script>
export default {
  name: "inspire",
  created() {
    this.$vuetify.theme.dark = true;
  }
};
</script>

<style>
#inspire {
  height: 100vh;
}
</style>
