<template>
  <v-main app>
    <div id="background">
      <div class="myform">
        
        <h2 class="input">Display Events</h2>
        <v-container v-if="eventList.length != 0">
          <v-card light width="100%" max-height="500px">
            <v-list shaped class="card-body">
              <v-list-item-group >
                <template v-for="(item,i) in eventList">
                  <v-list-item :key="i" :value="item" active-class="light-blue">                   
                    <template v-slot:default="{}">
                      <v-list-item-content>
                        <v-list-item-title v-text="`Event ID Number: ${i+1}`"></v-list-item-title>  
                       <v-list-item-title v-text="`Event Name: ${item.name}`"></v-list-item-title>
                        <v-list-item-title v-text="`Event Studio: ${item.studioShortName}`"></v-list-item-title>
                        <v-list-item-title v-text="`Event Type: ${item.eventType}`"></v-list-item-title>
                        <v-list-item-title v-text="`Event Year: ${item.year}`"></v-list-item-title>
                        <v-list-item-title v-text="`Event Duration: ${item.duration}`"></v-list-item-title>
                        <v-list-item-title v-text="`Event Fee: ${item.eventLicensingFee}`"></v-list-item-title>
                      </v-list-item-content>
                    </template>
                  </v-list-item>
                </template>
              </v-list-item-group>
            </v-list>
          </v-card>          
        </v-container>
        <form @submit.prevent="onSubmit">
          <div class="submit">
            <v-btn class="mr-6" type="submit" light outlined color="black">Refresh</v-btn>
          </div>
        </form>
      </div>
    </div>
  </v-main>
</template>

<script>

export default {
  data() {
    return {
    };
  },
  validations: {},
  created() {
    this.onSubmit();
  },
  computed: {
    eventList() {
      return this.$store.state.allEvent;
    }
  },
  methods: {
    onSubmit() {
      this.$store.dispatch("displayevent");
    }
  }
};
</script>

<style scoped>
.card-body {
  width: 100%;
  overflow-y: auto;
  max-height: 65vh;
}
#message {
  color: red;
}
#forget {
  text-decoration: none;
}
#background {
  background-image: url("../../assets/2.jpg");
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
}
#error {
  color: red;
}
p {
  color: black;
}
.myform {
  background-color: white;
  width: 400px;
  margin: auto;
  border: 1px solid #eee;
  padding: 20px;
  box-shadow: 0 2px 3px #ccc;
}

.input {
  margin: 10px auto;
  color: black;
}

.input label {
  display: block;
  color: #4e4e4e;
  margin-bottom: 6px;
}

.input input {
  font: inherit;
  width: 100%;
  padding: 6px 12px;
  box-sizing: border-box;
  border: 1px solid #ccc;
}

.input input:focus {
  outline: none;
  border: 1px solid #521751;
  background-color: #eee;
}

.submit button {
  border: 1px solid #521751;
  color: #521751;
  padding: 10px 20px;
  font: inherit;
  cursor: pointer;
}

.submit button:hover,
.submit button:active {
  background-color: #1dcf4a;
  color: white;
}

.submit button[disabled],
.submit button[disabled]:hover,
.submit button[disabled]:active {
  border: 1px solid #ccc;
  background-color: transparent;
  color: #ccc;
  cursor: not-allowed;
}
</style>
