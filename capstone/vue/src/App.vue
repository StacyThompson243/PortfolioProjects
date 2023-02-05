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
  background-color: #F2FAFD;
}

h1 {  
  padding: 20px 0 15px 0;
  text-align: center;
  /* border-bottom: 2px solid #82F2C1; */
}

#bottomLine {
  border-bottom: 2px solid #63EFB2;
  width: 200px;
  margin: auto;
  margin-bottom: 15px;
}

ul {
  list-style-type: none;
}

a {
  text-decoration: none;
}
</style>