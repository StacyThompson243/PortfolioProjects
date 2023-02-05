<template>
  <nav class="navigation">      
    <div class="logoContainer">
      <ul>
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
      </ul>
    </div>
    <div class="buttonsContainer">
      <ul>
        <li><router-link v-bind:to="{ name: 'pets' }">Browse Pets</router-link></li>
        <li><router-link v-bind:to="{ name: 'volunteer' }">Volunteer</router-link></li>
        <li v-if="$store.state.user.role === 'ROLE_ADMIN'"><router-link v-bind:to="{ name: 'volunteerApplications' }">Volunteer Apps</router-link></li>
        <!-- possibly v-on hover, toggle visibility v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN' " -->
        <li v-if="$store.state.token == ''"><router-link to="/login">Log In</router-link></li>
        <li v-else><router-link to="/logout">Logout</router-link></li>
      </ul>
    </div>      
  </nav>
</template>

<script></script>

<style>
nav {
  display: flex;
  justify-content: space-between;
  padding: 30px;
  background-color: #0F4F6A;
}

nav div {
  display: inline-block;
}

.buttonsContainer ul {
  display: flex;
}

.buttonsContainer ul li {
  margin: 0 25px;
}

a {
  color: #ffffffd2;
}

a:hover {
  font-weight: 500;
  color: #82F2C1;
  transition: 0.25s;
}
</style>