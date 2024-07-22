<template>
  <v-main app>
    <div id="dashboard">
      <h1>Streaming War Dashboard</h1>
      <p v-if="!auth">You should only get here if you're authenticated! Please login again</p>

      <v-row v-if="auth" id="time" justify="space-around">
        <h3>
          Current System Date: {{ this.$store.state.curtime.Year }}-{{
            this.$store.state.curtime.Month
          }}
        </h3>
        <v-dialog v-if="admin" v-model="dialog" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              Archive
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              Archive Current Month
            </v-card-title>
            <v-card-text>Do you want to archive all the current month data?</v-card-text>
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
        <v-dialog v-if="admin" v-model="dialog1" persistent max-width="290">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark v-bind="attrs" v-on="on">
              Next Month
            </v-btn>
          </template>
          <v-card>
            <v-card-title class="headline">
              Next Month
            </v-card-title>
            <v-card-text>Do you want to set time to next month?</v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="green darken-1" text @click="dialog1 = false">
                Cancel
              </v-btn>
              <v-btn color="green darken-1" text @click="nextmonth()">
                Submit
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-row>

      <v-card id="card" v-if="auth" class="mx-auto" max-width="1500" color="white">
        <v-container fluid>
          <v-row dense>
            <v-col v-for="card in filterdList" :key="card.title" :cols="card.flex">
              <v-card>
                <v-img
                  :src="card.src"
                  class="white--text align-end"
                  gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
                  height="200px"
                >
                  <v-card-title v-text="card.title"></v-card-title>
                </v-img>

                <v-card-actions>
                  <v-list flat min-height="210">
                    <v-list-item link v-for="link in card.links" :key="link.text" :to="link.route">
                      <v-list-item-action>
                        <v-icon>{{ link.icon }}</v-icon>
                      </v-list-item-action>
                      <v-list-item-content>
                        <v-list-item-title>{{ link.text }}</v-list-item-title>
                      </v-list-item-content>
                    </v-list-item>
                  </v-list>
                </v-card-actions>
              </v-card>
            </v-col>
          </v-row>
        </v-container>
      </v-card>

      <v-snackbar v-model="snackbar">
        {{ this.$store.state.operation_response }}
      </v-snackbar>
    </div>
  </v-main>
</template>
<script>
export default {
  data() {
    return {
      snackbar: false,
      date: "",
      dialog: false,
      dialog1: false,
      cards: [
        {
          title: "Group",
          src:
            "https://images.pexels.com/photos/853168/pexels-photo-853168.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260",
          flex: 4,
          links: [
            {
              icon: "mdi-play-box-outline",
              text: "Display Group",
              route: "/displaydemo",
              requireAdmin: false
            },
            {
              icon: "mdi-pencil-plus",
              text: "Create Group",
              route: "/createdemo",
              requireAdmin: true
            },
            {
              icon: "mdi-update",
              text: "Update group",
              route: "/updatedemo",
              requireAdmin: true
            },
            {
              icon: "mdi-credit-card-marker-outline",
              text: "Watch Event",
              route: "/watchevent",
              requireAdmin: true
            }
          ]
        },
        {
          title: "Service",
          src: "https://miro.medium.com/max/970/0*AB_I3rxxmNRsBL43.jpg",
          flex: 4,
          links: [
            {
              icon: "mdi-play-box-outline",
              text: "Display Service",
              route: "/displaystream",
              requireAdmin: false
            },
            {
              icon: "mdi-pencil-plus",
              text: "Create Service",
              route: "/createstream",
              requireAdmin: true
            },
            {
              icon: "mdi-update",
              text: "Update Service",
              route: "/updatestream",
              requireAdmin: true
            }
          ]
        },
        {
          title: "Studio",
          src: "https://www.reminetwork.com/wp-content/uploads/filmstudio.jpg",
          flex: 4,
          links: [
            {
              icon: "mdi-play-box-outline",
              text: "Display Studio",
              route: "/displaystudio",
              requireAdmin: false
            },
            {
              icon: "mdi-pencil-plus",
              text: "Create Studio",
              route: "/createstudio",
              requireAdmin: true
            }
          ]
        },
        {
          title: "Event",
          src: "https://i.insider.com/5f578371e6ff30001d4e76be?width=1136&format=jpeg",
          flex: 6,
          links: [
            {
              icon: "mdi-play-box-outline",
              text: "Display Event",
              route: "/displayevent",
              requireAdmin: false
            },
            {
              icon: "mdi-pencil-plus",
              text: "Create Event",
              route: "/createevent",
              requireAdmin: true
            },
            {
              icon: "mdi-update",
              text: "Update Event",
              route: "/updateevent",
              requireAdmin: true
            }
          ]
        },
        {
          title: "Offer",
          src:
            "https://ei.marketwatch.com/Multimedia/2020/05/21/Photos/ZQ/MW-IG985_Movies_20200521113911_ZQ.jpg?uuid=378c769c-9b79-11ea-bd9d-9c8e992d421e",
          flex: 6,
          links: [
            {
              icon: "mdi-play-box-outline",
              text: "Display Offer",
              route: "/displayoffer",
              requireAdmin: false
            },
            {
              icon: "mdi-pencil-plus",
              text: "Create Offer",
              route: "/createoffer",
              requireAdmin: true
            },
            {
              icon: "mdi-delete",
              text: "Retract Offer",
              route: "/retractoffer",
              requireAdmin: true
            }
          ]
        }
      ]
    };
  },
  computed: {
    auth() {
      return !this.$store.getters.isAuth ? false : this.$store.getters.isAuth;
    },
    admin() {
      return this.$store.getters.user.admin;
    },
    filterdList() {
      return this.admin
        ? this.cards
        : this.cards.map(element => {
            return {
              ...element,
              links: element.links.filter(links => links.requireAdmin === this.admin)
            };
          });
    }
  },
  methods: {
    sumbitArch() {
      this.dialog = false;
      this.snackbar = true;
      this.$store.dispatch('archive');
      setTimeout(() => {
        this.snackbar = false;
      }, 2000);
    },
    nextmonth() {
      this.dialog1 = false;
      this.$store.dispatch("nextmonth");
      setTimeout(() => {
        this.currentDate();
      }, 2000);
    },
    currentDate() {
      this.$store.dispatch("time");
    }
  },
  created() {
    this.currentDate();
  }
};
</script>
<style scoped>
#time {
  margin: 0;
}
#card {
  background-image: url("../../assets/2.jpg");
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
}
h1,
p {
  text-align: center;
  color: white;
  margin: auto;
}
</style>
