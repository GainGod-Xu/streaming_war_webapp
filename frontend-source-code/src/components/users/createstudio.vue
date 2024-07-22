<template>
  <v-main app>
    <div id="background">
      <div class="myform">
        <h2 class="input">Create Studio</h2>
        <form @submit.prevent="onSubmit">
          <!-- [4] create_stream,<short name>,<long name>, -->
          <div class="input">
            <label for="ShortName">ShortName</label>
            <input type="ShortName" id="ShortName" @blur="$v.ShortName.$touch()" v-model="ShortName" />
          </div>
          <div class="input">
            <label for="LongName">LongName</label>
            <input type="LongName" id="LongName" @blur="$v.LongName.$touch()" v-model="LongName" />
          </div>         
          
          <p id="message">{{this.$store.state.operation_response}}</p>
          <div class="submit">
            <v-btn
              class="mr-6"
              type="submit"
              :disabled="$v.$invalid"
              light
              outlined
              color="black"
            >Submit</v-btn>
          </div>
        </form>
      </div>
    </div>
  </v-main>
</template>

<script>
import { required } from 'vuelidate/lib/validators';

export default {
  data() {
    return {
      ShortName:'',
      LongName:''
    };
  },
  validations: {
    ShortName: {
      required
    },
    LongName: {
      required
    }
  },
  methods: {
    onSubmit() {
      const formData = {
        ShortName: this.ShortName,
        LongName: this.LongName
      };
      this.$store.dispatch('createstudio', formData);
      this.ShortName = '';
      this.LongName = '';
    }
  }
};
</script>

<style scoped>
#message {
  color: green;
}
#forget{
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
  margin:  auto;
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
