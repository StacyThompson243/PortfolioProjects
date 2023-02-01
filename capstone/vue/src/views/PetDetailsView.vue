<template>
  <div class='container'>
  <img :src='pet.petImage'/>
      <h1>Hi! My Name is {{pet.petName}} !</h1>
       <h2>I am a {{pet.type}}.</h2>
      <h2>My breed is: {{pet.breed}}.</h2>
      <h2>I weigh {{pet.weight}} lbs.</h2>
      <h2>I am {{pet.age}} years old</h2>
      <h2>About Me...</h2>
      <p>{{pet.description}}</p>
      </div>
 
</template>

<script>
export default {
props:['petId'],
computed: {
  pet(){
    return this.$store.getters.pet;
  }
},
created(){
  const activePetId = this.$route.params.petId;
  this.$store.commit('SET_ACTIVE_PET', activePetId)
}
}
</script>

<style scoped>

.container{
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}

img{
  padding-top: 40px;
  text-align: center;
  height: 450px;
}



</style>