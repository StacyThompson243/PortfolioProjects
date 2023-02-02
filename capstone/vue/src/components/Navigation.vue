<template>
<div class='header'>
     <nav class="navigation">
    <ul>
        <li><router-link v-bind:to="{name: 'home'}">Home</router-link></li>
        <li><router-link v-bind:to="{name: 'pets'}">Browse Pets</router-link></li>
        <li><router-link v-bind:to="{name: 'volunteer'}">Volunteer</router-link></li>
        <li v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN' "><router-link v-bind:to="{name: 'volunteerApplications'}">Volunteer Apps</router-link></li>
        <li v-if="$store.state.token == '' "><router-link  v-bind:to="{path: 'login'}">Log In</router-link></li>
        <li v-else><router-link  v-bind:to="{path: 'logout'}">Logout</router-link></li>
    </ul>
</nav>
</div>
</template>

<script>

</script>

<style>

.header{
   padding: 30px;
   display: flex;
   flex-direction: row;
   background-color:#90EBDD;
}

nav{
   flex-grow: 1;
} 

nav ul {
  margin: 0;
  padding: 0;
  list-style-type: none;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  flex-wrap: wrap;

}

li {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
  color: black;
  padding: 0 30px 0 0;
  margin-left: 20px;
}

a:hover{
  color: #6F2CF0;
}

a{
  text-decoration: none;
}

</style>