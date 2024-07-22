<template>
  <v-main app>
    <v-app-bar app>
      <v-spacer />
      <h1>Streaming War Application</h1>   
      <v-spacer />
    </v-app-bar>
    <div class="background">
      <h2>Welcome to our Streaming War Application</h2>
    </div>
  </v-main>
</template>
<script>
export default {
};
</script>
<style scoped>
.background {
  background-image: url("../assets/1.jpg");
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
}
h1,h2 {   
    text-align:center; 
}
</style>
