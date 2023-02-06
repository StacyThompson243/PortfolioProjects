<template>
  <div>
  <img :src='pet.petImage'/>
  <div class='card'>
    <h2>{{pet.petName}}</h2>
    <div class="pHolder">
      <div>
        <p>Type: {{pet.type}}</p>
      </div>
      <div>
        <p>Breed: {{pet.breed}}</p>
      </div>
      <div>
        <p>Weight: {{pet.weight}} lbs</p>
      </div>
      <div>
        <p>Age: {{pet.age}} years old</p>
      </div>
    </div>
    <p>{{pet.description}}</p>
  </div>
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

h2 {
  margin-bottom: 3px;
  color: #0F4F6A;
}

img {
  display: block;
  margin: auto;
  margin-top: 60px;
  margin-bottom: 30px;
  height: 385px;
  /* object-fit: contain; */
  box-shadow: 2px 4px 4px rgb(138, 138, 138);
}

.card {
  margin: auto;  
  overflow:hidden;
  box-shadow: 2px 4px 4px rgb(204, 204, 204);
  width: 500px
}

.pHolder:nth-child(even) {
  background-color: rgba(255, 255, 255, 0.5);
}

.pHolder:nth-child(odd) {
  background-color: rgba(255, 255, 255, 0.2);
}
</style>