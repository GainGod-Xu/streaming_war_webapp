<template>
  <v-main app>
    <div id="signin">
      <div class="signin-form">
        <form @submit.prevent="onSubmit">
          <div class="input">
            <label for="email">Email</label>
            <input type="email" id="email" @blur="$v.email.$touch()" v-model="email" />
          </div>
          <div class="input">
            <label for="password">Password</label>
            <input type="password" id="password" @blur="$v.password.$touch()" v-model="password" />
          </div>
          <p id="error">{{this.$store.state.login_message}}</p>
          <div class="submit">
            <v-btn
              class="mr-6"
              type="submit"
              :disabled="$v.$invalid"
              light
              outlined
              color="black"
            >Sign in</v-btn>
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
      email: '',
      password: ''
    };
  },
  validations: {
    email: {
      required
    },
    password: {
      required
    }
  },
  methods: {
    onSubmit() {
      const formData = {
        email: this.email,
        password: this.password
      };
      this.$store.dispatch('login', formData);
      this.email = '';
      this.password = '';
    }
  }
};
</script>

<style scoped>
#signin {
  background-image: url("../../assets/2.jpg");
  width: 100%;
  height: 100%;
  background-size: 100% 100%;
}
#forget{
  text-decoration: none;
}
/* #signin {/ */
#error {
  color: red;
}
.signin-form {
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
