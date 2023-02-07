<template>
  <div class="page" >
    <form id="updatePassword" class="form-register" @submit.prevent="updatePassword">
        <h1>Welcome, {{user.username}}!</h1>
        <div id="bottomLine"></div> 

        <div class="form">
        <h3>Please update your password:</h3>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>

      <!-- change username to detect username, not assign new -->
      <!-- <label for="username" class="sr-only">Username: </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /> -->

      <!-- <label for="oldPassword" class="sr-only">Previous Password</label>
      <input
        type="oldPassword"
        id="oldPassword"
        class="form-control"
        placeholder="Old Password"
        v-model="user.password" -> backend needs a place to put old and new password jdbcuser, make sure old password matches before changing it.
        required
      /> -->
<div>    </div>

      <label for="password" class="sr-only">New Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />

      <div></div>
      <label for="password2" class="sr-only">Confirm Password: </label><input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />

      <div></div>
      <button class="btn" type="submit">
        Update Account
      </button>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'login-first-time',
  data() {
    return {
      user: {
        username: this.$store.state.user.username,
        password: '',
        confirmPassword: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    updatePassword() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .updatePassword(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.page {
  background-image: url(../assets/login.jpg);
}

h1 {
  /* text-align:initial; */
  /* margin-left: 10vw; */
  margin-top: 92px;
}

.form {
  /* margin-left: 5vw; */
  display: flex;  
  flex-direction: column;
  width: 400px;
}

#updatePassword {
  width: 400px;
  margin-left: 10vw;
}

input[type="password"] {
  margin-bottom: 8px;
}

.btn {
  margin-bottom: 8px;
}

a {
  font-size: 14px;
  color: black;
}

a:hover {
  color: rgb(123,45,212);
  transition: 0.2s;
}

</style>