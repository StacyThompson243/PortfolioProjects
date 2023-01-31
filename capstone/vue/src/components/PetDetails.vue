<template>
  <!-- <router-link v-bind:to="{ name: 'petDetails', params: { id: pet.petId } }"> -->
    <div class="info">
      <h2 class="pet-name">{{ pet.name }}</h2>
      <img src="pet.img" />
      <h3 class="pet-type">{{ pet.type }}</h3>
      <h3 class="pet-breed">{{ pet.breed }}</h3>
      <p class="description">{{ pet.description }}</p>
    </div>
  <!-- </router-link> -->
</template>

<script>
export default {
  name: "pet-details",
  props: 
    ['pet'],
};
</script>

<style>
.info {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
}
</style>