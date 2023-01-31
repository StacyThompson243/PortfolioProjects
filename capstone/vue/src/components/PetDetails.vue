<template>
    <router-link v-bind:to="{name: 'petDetails', params: {id: pet.id}}">
    <div class="pet-info">
    <h2 class="pet-name">Pet Name</h2>
    <img v-bind:src="'https://res.cloudinary.com/difcq8eki/image/upload/v1675116120/Dogs/pexels-ylanite-koppens-612813_oddfwy.jpg'" />
    <h3 class="pet-type">Pet Type</h3>
    <h3 class="pet breed">Pet Breed</h3>
    <p class="description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Animi exercitationem minima, dolore deserunt autem eius harum recusandae magnam illum fugiat.</p>
    
  </div>
    </router-link>
  
  
 
</template>

<script>
export default {

}
</script>

<style>
.pet-info {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}


</style>