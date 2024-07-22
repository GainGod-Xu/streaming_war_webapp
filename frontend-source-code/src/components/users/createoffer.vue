<template>
  <v-main app>
    <div id="background">
      <div class="myform">
        <h2 class="input">Create Offer</h2>
        <form @submit.prevent="onSubmit">
          <v-radio-group v-model="type" row>
            <v-radio light label="movie" value="movie">movie</v-radio>
            <v-radio light label="ppv" value="ppv">ppv</v-radio>
          </v-radio-group>
          <div class="input">
            <label for="service">Streaming Service</label>
            <input type="service" id="service" @blur="$v.service.$touch()" v-model="service" />
          </div>
          <div class="input">
            <label for="ShortName">Event Name</label>
            <input
              type="ShortName"
              id="ShortName"
              @blur="$v.ShortName.$touch()"
              v-model="ShortName"
            />
          </div>
          <div class="input">
            <label for="year">Year Produced</label>
            <input type="year" id="year" @blur="$v.year.$touch()" v-model="year" />
          </div>
           <p id="error" v-if="$v.year.$error">Please Enter Valid Number</p>
          <div class="input" v-if="type === 'ppv'">
            <label for="viewingprice">Viewing Price</label>
            <input
              type="viewingprice"
              id="viewingprice"
              @blur="$v.viewingprice.$touch()"
              v-model="viewingprice"
            />
          </div>
          <p id="error" v-if="$v.viewingprice.$error">Please Enter Valid Number</p>
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
import { required,integer } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      type: "movie",
      ShortName: "",
      year: "",
      service: "",
      viewingprice: 0
    };
  },
  validations: {
    type: {
      required
    },
    ShortName: {
      required
    },
    year: {
      required,
      integer
    },
    service: {
      required
    },
    viewingprice: {
      required,
      integer
    }
  },
  methods: {
    onSubmit() {
      let formData;
      if (this.type === "ppv") {
        formData = {
          ShortName: this.ShortName,
          Type: this.type,
          Year: this.year,
          Service: this.service,
          Viewingprice: this.viewingprice
        };
      } else {
        formData = {
          ShortName: this.ShortName,
          Type: this.type,
          Year: this.year,
          Service: this.service
        };
      }
      this.$store.dispatch("createoffer", formData);
    }
  }
};
</script>

<style scoped>
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
