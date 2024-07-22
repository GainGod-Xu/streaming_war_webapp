<template>
  <v-main app>
    <div id="background">
      <v-row id="title" justify="space-around">
        <h2 class="input">Display Archive: {{picker.length === 7 ? picker : `Please Select Month`}}</h2>
        <v-dialog v-model="dialog" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              Select Month
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              Select Month
            </v-card-title>
            <v-date-picker v-model="picker" type="month"></v-date-picker>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="green darken-1" text @click="dialog = false">
                Cancel
              </v-btn>
              <v-btn color="green darken-1" text @click="sumbitArch()">
                Submit
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>

      <v-card class="mx-auto">
        <v-container fluid>
          <v-row dense>
            <v-col flex>
              <v-card>
                <v-img
                  :src="cards[0].src"
                  class="white--text align-end"
                  gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                  height="200px"
                >
                  <v-card-title v-text="cards[0].title"></v-card-title>
                </v-img>
                <p v-if="groupArchive.length === 0">No Archive Data</p>
                <v-list shaped class="card-body">
                  <v-list-item-group>
                    <template v-for="(item, i) in groupArchive">
                      <v-list-item :key="i" :value="item" active-class="light-blue">
                        <template v-slot:default="{}">                           
                          <v-list-item-content>
                            <v-list-item-title
                              v-text="`Group ID Number: ${i + 1}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoShortName: ${item.demoShortName}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoLongName: ${item.demoLongName}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoAccounts: ${item.demoAccounts}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoCurrentSpending: ${item.demoCurrentSpending}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoPreviousSpending: ${item.demoPreviousSpending}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`demoTotalSpending: ${item.demoTotalSpending}`"
                            ></v-list-item-title>
                            <!-- <v-list-item-title v-if="!groupArchive"
                            ><p>test</p></v-list-item-title> -->
                           
                          </v-list-item-content>
                        </template>
                      </v-list-item>
                    </template>
                  </v-list-item-group>
                </v-list>
              </v-card>
              <v-card>
                <v-img
                  :src="cards[1].src"
                  class="white--text align-end"
                  gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                  height="200px"
                >
                  <v-card-title v-text="cards[1].title"></v-card-title>
                </v-img>
                <p v-if="streamArchive.length === 0">No Archive Data</p>
                <v-list shaped class="card-body">
                  <v-list-item-group>
                    <template v-for="(item, i) in streamArchive">
                      <v-list-item :key="i" :value="item" active-class="light-blue">
                        <template v-slot:default="{}">
                          <v-list-item-content>
                            <v-list-item-title
                              v-text="`Stream ID Number: ${i + 1}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`streamShortName: ${item.streamShortName}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`streamLongName: ${item.streamLongName}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`subscriptionFee: ${item.subscriptionFee}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`currentMonthRevenue: ${item.currentMonthRevenue}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`previousMonthRevenue: ${item.previousMonthRevenue}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`totalRevenue: ${item.totalRevenue}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`totalLicensingFee: ${item.totalLicensingFee}`"
                            ></v-list-item-title>
                          </v-list-item-content>
                        </template>
                      </v-list-item>
                    </template>
                  </v-list-item-group>
                </v-list>
              </v-card>
              <v-card>
                <v-img
                  :src="cards[2].src"
                  class="white--text align-end"
                  gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                  height="200px"
                >
                  <v-card-title v-text="cards[2].title"></v-card-title>
                </v-img>
                <p v-if="studioArchive.length === 0">No Archive Data</p>
                <v-list shaped class="card-body">
                  <v-list-item-group>
                    <template v-for="(item, i) in studioArchive">
                      <v-list-item :key="i" :value="item" active-class="light-blue">
                        <template v-slot:default="{}">
                          <v-list-item-content>
                            <v-list-item-title
                              v-text="`Studio ID Number: ${i + 1}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`studioShortName: ${item.studioShortName}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`studioLongName: ${item.studioLongName}`"
                            ></v-list-item-title>                            
                            <v-list-item-title
                              v-text="`currentMonthRevenue: ${item.currentMonthRevenue}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`previousMonthRevenue: ${item.previousMonthRevenue}`"
                            ></v-list-item-title>
                            <v-list-item-title
                              v-text="`totalRevenue: ${item.totalRevenue}`"
                            ></v-list-item-title>                            
                          </v-list-item-content>
                        </template>
                      </v-list-item>
                    </template>
                  </v-list-item-group>
                </v-list>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </div>
  </v-main>
</template>

<script>
export default {
  data() {
    return {
      dialog: false,
      picker: new Date().toISOString().substr(0, 10),
      cards: [
        {
          title: "Archived Group Data",
          src:
            "https://images.pexels.com/photos/853168/pexels-photo-853168.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
        },
        {
          title: "Archived Stream Data",
          src: "https://miro.medium.com/max/970/0*AB_I3rxxmNRsBL43.jpg"
        },
        {
          title: "Archived Studio Data",
          src: "https://www.reminetwork.com/wp-content/uploads/filmstudio.jpg"
        }
      ]
    };
  },
  computed: {
    groupArchive() {
      return this.$store.state.archive.groupArchive.map(i => JSON.parse(i.replace(/'/g, '"')));
    },
    streamArchive() {
      return this.$store.state.archive.streamArchive.map(i => JSON.parse(i.replace(/'/g, '"')));
    },
    studioArchive() {
      return this.$store.state.archive.studioArchive.map(i => JSON.parse(i.replace(/'/g, '"')));
    }
  },
  methods: {
    sumbitArch() {
      const formData = {
        Date: this.picker
      };
      this.$store.dispatch("displayarchive", formData);
      this.dialog = false;
    }
  }
};
</script>

<style scoped>
#title {
  height: 7vh;
  margin: auto;
}
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
h2,p {
  color: white;
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
