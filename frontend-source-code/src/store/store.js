import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import VueRouter from "../router";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: { email: "", admin: false },
    isAuth: false,
    serverUrl: "http://localhost:8080",
    login_message: "",
    register_message: "",
    operation_response: "",
    allEvent: [],
    allOffer: [],
    demodisplay: {
      Current_period: "",
      Previous_period: "",
      ShortName: "",
      Size: "",
      Total: "",
      LongName: ""
    },
    studio: {
      Current_period: "",
      Previous_period: "",
      ShortName: "",
      Total: "",
      LongName: ""
    },
    stream: {
      SubscriptionFee: "",
      LongName: "",
      ShortName: "",
      CurrentMonthRevenue: "",
      PreviousMonthRevenue: "",
      TotalLicensingFee: "",
      TotalRevenue: ""
    },
    curtime: { Month: "", Year: "" },
    archive:{
      groupArchive:[],
      streamArchive:[],
      studioArchive:[]
    }
  },
  getters: {
    user(state) {
      return state.user;
    },
    isAuth(state) {
      return state.isAuth;
    }
  },
  mutations: {
    clearAuthData(state) {
      state.isAuth = "";
      state.user = {};
    },
    authUser(state, UserData) {
      state.isAuth = true;
      state.email = UserData.email;
      state.user.admin = UserData.admin === "true";
    },
    demodisplay(state, UserData) {
      state.demodisplay.ShortName = UserData.ShortName;
      state.demodisplay.LongName = UserData.LongName;
      state.demodisplay.Size = UserData.Size;
      state.demodisplay.Current_period = UserData.Current_period;
      state.demodisplay.Previous_period = UserData.Previous_period;
      state.demodisplay.Total = UserData.Total;
    },
    archiveData(state, UserData) {
      state.archive.groupArchive = UserData.groupArchive;
      state.archive.streamArchive = UserData.streamArchive;
      state.archive.studioArchive = UserData.studioArchive;
    },
    studiodisplay(state, UserData) {
      state.studio.ShortName = UserData.ShortName;
      state.studio.LongName = UserData.LongName;
      state.studio.Current_period = UserData.Current_period;
      state.studio.Previous_period = UserData.Previous_period;
      state.studio.Total = UserData.Total;
    },
    streamdisplay(state, UserData) {
      (state.stream.ShortName = UserData.ShortName),
        (state.stream.LongName = UserData.LongName),
        (state.stream.SubscriptionFee = UserData.SubscriptionFee),
        (state.stream.CurrentMonthRevenue = UserData.CurrentMonthRevenue),
        (state.stream.PreviousMonthRevenue = UserData.PreviousMonthRevenue),
        (state.stream.TotalLicensingFee = UserData.TotalLicensingFee),
        (state.stream.TotalRevenue = UserData.TotalRevenue);
    }
  },
  actions: {
    register({}, authData) {
      axios
        .post(`${this.state.serverUrl}/register`, {
          email: authData.email,
          password: authData.password,
          confirmPassword: authData.confirmPassword,
          admin: authData.admin
        })
        .then(response => {
          this.state.register_message = response.data.Response;
          setTimeout(() => {
            this.state.register_message = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    login({ commit }, authData) {
      axios
        .post(`${this.state.serverUrl}/login`, {
          email: authData.email,
          password: authData.password
        })
        .then(res => {
          this.state.login_message = res.data.Response;
          if (res.data.Response === "Login Successful") {
            commit("authUser", {
              email: authData.email,
              admin: res.data.Admin
            });
            VueRouter.push({ name: "Dashboard" });
          }
          setTimeout(() => {
            this.state.login_message = "";
          }, 3000);
        })
        .catch(err => {
          console.log(`error! + ${err}`);
        });
    },
    logout({ commit }) {
      commit("clearAuthData");
      VueRouter.push({ name: "Home" });
    },
    creategroup({}, authData) {
      axios
        .post(`${this.state.serverUrl}/createGroup`, {
          demoShortName: authData.ShortName,
          demoLongName: authData.LongName,
          demoAccounts: authData.Account
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    updategroup({}, authData) {
      axios
        .post(`${this.state.serverUrl}/updateGroup`, {
          demoShortName: authData.ShortName,
          demoLongName: authData.LongName,
          demoAccounts: authData.Account
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    displaygroup({ commit }, authData) {
      axios
        .post(`${this.state.serverUrl}/displayGroup`, {
          demoShortName: authData.ShortName
        })
        .then(response => {
          let userData = response.data;
          commit("demodisplay", {
            ShortName: userData.ShortName,
            LongName: userData.LongName,
            Size: userData.Size,
            Current_period: userData.Current_period,
            Previous_period: userData.Previous_period,
            Total: userData.Total
          }),
            (this.state.operation_response = response.data.Response);
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    displaystudio({ commit }, authData) {
      axios
        .post(`${this.state.serverUrl}/displayStudio`, {
          shortName: authData.ShortName
        })
        .then(response => {
          let userData = response.data;
          commit("studiodisplay", {
            ShortName: userData.shortName,
            LongName: userData.longName,
            Current_period: userData.currentMonthRevenue,
            Previous_period: userData.previousMonthRevenue,
            Total: userData.totalRevenue
          });
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    createstudio({}, authData) {
      axios
        .post(`${this.state.serverUrl}/createStudio`, {
          shortName: authData.ShortName,
          longName: authData.LongName
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    createevent({}, authData) {
      axios
        .post(`${this.state.serverUrl}/createEvent`, {
          name: authData.Name,
          eventType: authData.Type,
          year: authData.Year,
          duration: authData.Duration,
          studioShortName: authData.Studio,
          eventLicensingFee: authData.Fee
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    updateevent({}, authData) {
      axios
        .post(`${this.state.serverUrl}/updateEvent`, {
          name: authData.Name,
          eventType: authData.Type,
          year: authData.Year,
          eventLicensingFee: authData.Fee,
          duration:authData.Duration
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    displayevent() {
      axios
        .post(`${this.state.serverUrl}/displayEvents`)
        .then(response => {
          this.state.allEvent = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    watchevent({}, authData) {
      axios
        .post(`${this.state.serverUrl}/watchEvent`, {
          demoShortName: authData.demoShortName,
          streamName: authData.streamName,
          percentage: authData.percentage,
          eventName: authData.eventName,
          year: authData.year
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    displaystream({ commit }, authData) {
      axios
        .post(`${this.state.serverUrl}/displayStream`, {
          shortName: authData.ShortName
        })
        .then(response => {
          let userData = response.data;
          commit("streamdisplay", {
            ShortName: userData.ShortName,
            LongName: userData.LongName,
            SubscriptionFee: userData.SubscriptionFee,
            CurrentMonthRevenue: userData.CurrentMonthRevenue,
            PreviousMonthRevenue: userData.PreviousMonthRevenue,
            TotalLicensingFee: userData.TotalLicensingFee,
            TotalRevenue: userData.TotalRevenue
          });
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    createstream({}, authData) {
      axios
        .post(`${this.state.serverUrl}/createStream`, {
          shortName: authData.ShortName,
          longName: authData.LongName,
          subscriptionFee: authData.Subscription
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    updatestream({}, authData) {
      axios
        .post(`${this.state.serverUrl}/updateStream`, {
          shortName: authData.ShortName,
          longName: authData.LongName,
          subscriptionFee: authData.Subscription
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    createoffer({}, authData) {
      let data;
      if (authData.Type === "ppv") {
        data = {
          service: authData.Service,
          type: authData.Type,
          name: authData.ShortName,
          year: authData.Year,
          viewingPrice: authData.Viewingprice
        };
      } else {
        data = {
          service: authData.Service,
          type: authData.Type,
          name: authData.ShortName,
          year: authData.Year
        };
      }
      axios
        .post(`${this.state.serverUrl}/createOffer`, data)
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    displayoffer() {
      axios
        .post(`${this.state.serverUrl}/displayOffers`)
        .then(response => {
          this.state.allOffer = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    retractoffer({}, authData) {
      axios
        .post(`${this.state.serverUrl}/retractOffer`, {
          Year: authData.Year,
          Service: authData.Service,
          Name: authData.ShortName
        })
        .then(response => {
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    },
    time() {
      axios
        .post(`${this.state.serverUrl}/time`)
        .then(response => {
          this.state.curtime.Month = response.data.Month;
          this.state.curtime.Year = response.data.Year;
        })
        .catch(error => {
          console.log(error);
        });
    },
    nextmonth() {
      axios
        .post(`${this.state.serverUrl}/nextMonth`)
        .then(response => {})
        .catch(error => {
          console.log(error);
        });
    },
    archive() {
      axios
        .post(`${this.state.serverUrl}/archive`)
        .then(response => {
          this.state.operation_response = response.data.Response;
        })
        .catch(error => {
          console.log(error);
        });
    },
    displayarchive({commit}, authData) {
      let userData = authData;
      let year = userData.Date.slice(0, 4);
      let month = +userData.Date.slice(5, 7);
      axios
        .post(`${this.state.serverUrl}/archiveDisplay`, {
          year: year.toString(),
          month: month.toString()
        })
        .then(response => {
          let archiveData = response.data;
          if (!("groupArchive" in archiveData)){
            archiveData.groupArchive = [];
          };
          if (!("streamArchive" in archiveData)){
            archiveData.streamArchive = [];
          };
          if (!("studioArchive" in archiveData)){
            archiveData.studioArchive = [];
          };
          commit("archiveData", {
            groupArchive: archiveData.groupArchive,
            streamArchive: archiveData.streamArchive,
            studioArchive: archiveData.studioArchive
          });
          this.state.operation_response = response.data.Response;
          setTimeout(() => {
            this.state.operation_response = "";
          }, 3000);
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
});
