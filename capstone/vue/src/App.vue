<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
    </div>
    <navigation />
    <router-view />
  </div>
</template>

<script>
import Navigation from './components/Navigation.vue'


export default{
  components: {
    Navigation
  
  }
}

</script>

<style>

#app{
  background-color: #EEE6FA;
  height: 200vh;
}

</style>

