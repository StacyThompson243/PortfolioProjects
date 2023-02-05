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

.btn {
  background-color: rgba(255, 255, 255);
  border: none;
  color: black;
  padding: 18px 54px;
  font-size: 16px;
  border-radius: 5px;
  margin: 27px 0 0;
}

.btn:hover {
  background-color: #A1F5D0;
  transition: 0.5s;
}

.page {
  height: 100vh;
  width: 100vw;
  background-size: cover;
  position: fixed;
  top: 0px;
  z-index: -1;
}

input[type="text"], input[type="email"], input[type="password"] {
  padding: 14px 10px;
  height: 20px;
  border: 1px solid rgb(182, 182, 182);
  border-radius: 4px;
}

input[type="checkbox"] {
  height: 20px;
  width: 20px;
}
</style>