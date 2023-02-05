<template>
  <div class="page">
  <div id="login" class="text-center">  
  <form class="form-signin" @submit.prevent="login">
      <h1>Welcome Back!</h1>
      <div id="bottomLine"></div>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div id="container">
      <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          v-model="user.username"
          required
          autofocus
        />
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          v-model="user.password"
          required
        />
        <button type="submit">Sign in</button>
      </div>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
    </form>
  </div>
  </div>
</template>

<script>

import authService from "../services/AuthService";



export default {
  name: "login",
  components: {
   
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.page {
  background-image: url("https://www.southernliving.com/thmb/ZuS1MlY7N7G67Lyvl2zDIoktRDU=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/gettyimages-837898820-1-4deae142d4d0403dbb6cb542bfc56934.jpg")
}

#container {
  margin: auto;
  width: 400px;
  padding: 50px 50px;
  border-radius: 5px;
  display: flex;  
  flex-direction: column;
  background-color: #7ACAED;
}

#container input {
  margin-bottom: 5px;
}


</style>
