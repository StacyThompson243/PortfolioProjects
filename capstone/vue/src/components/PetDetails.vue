<template>
  <!-- <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}"> -->
    <div class="info">
      <h2 class="pet-name">Hi, I'm {{ pet.petName }}!</h2>
      <img :src='pet.petImage'/>
      <h3 class='pet-type'>Type: {{ pet.type }}</h3>
      <h3 class='pet-breed'>Breed: {{ pet.breed }}</h3>
      <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">
      <button v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">Learn More</button>
   </router-link> 
   </div>

</template>

<script>
export default {
  name: "pet-details",
  props: 
    ['pet'],
};
</script>

<style scoped>
img{
  height: 100px;
  width: auto;
}

.info {
  color: #6F2CF0;
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 400px;
  text-align: center;
  margin: 20px 50px;
  background-color:#C7EADD;
}
</style>