<template>
  <v-main app>
    <div id="background">
      <div class="myform">
        <h2 class="input">Watch Event</h2>
        <form @submit.prevent="onSubmit">
          <div class="input">
            <label for="EventName">Event Name</label>
            <input
              type="EventName"
              id="EventName"
              @blur="$v.EventName.$touch()"
              v-model="EventName"
            />
          </div>
          <div class="input">
            <label for="ShortName">Group Name</label>
            <input
              type="ShortName"
              id="ShortName"
              @blur="$v.ShortName.$touch()"
              v-model="ShortName"
            />
          </div>

          <div class="input">
            <label for="streamName">Stream Name</label>
            <input
              type="streamName"
              id="streamName"
              @blur="$v.streamName.$touch()"
              v-model="streamName"
            />
          </div>

          <div class="input">
            <label for="Percentage">Watch Percentage</label>
            <input
              type="Percentage"
              id="Percentage"
              @blur="$v.Percentage.$touch()"
              v-model="Percentage"
            />
          </div>
          <p id="error" v-if="$v.Percentage.$error">Please Enter Valid Number</p>

          <div class="input">
            <label for="year">Year Produced</label>
            <input type="year" id="year" @blur="$v.year.$touch()" v-model="year" />
          </div>
          <p id="error" v-if="$v.year.$error">Please Enter Valid Number</p>

          <p id="message">{{ this.$store.state.operation_response }}</p>

          <div class="submit">
            <v-btn class="mr-6" type="submit" :disabled="$v.$invalid" light outlined color="black"
              >Submit</v-btn
            >
          </div>
        </form>
      </div>
    </div>
  </v-main>
</template>

<script>
import { required, integer } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      streamName: "",
      ShortName: "",
      Percentage: "",
      EventName: "",
      year: ""
    };
  },
  validations: {
    EventName: {
      required
    },
    streamName: {
      required
    },
    ShortName: {
      required
    },
    year: {
      required,
      integer
    },
    Percentage: {
      required,
      integer
    }
  },
  methods: {
    onSubmit() {
      const formData = {
        demoShortName: this.ShortName,
        streamName: this.streamName,
        eventName: this.EventName,
        year: this.year,
        percentage: this.Percentage
      };
      this.$store.dispatch("watchevent", formData);
    }
  }
};
</script>

<style scoped>
p {
  color: red;
}
#message {
  color: green;
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
#select {
  color: black;
}
</style>
