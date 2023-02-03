<template>
  <div id="app">
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

