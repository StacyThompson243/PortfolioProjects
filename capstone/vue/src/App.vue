<template>
  <div>
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
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Comfortaa', cursive;
}

html {
  background-color: #D4EEF9;
}

ul {
  list-style-type: none;
}

a {
  text-decoration: none;
}
</style>

