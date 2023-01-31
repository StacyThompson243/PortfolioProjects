<template>
<div class="pet-container">
  <pet-details v bind:pet="pet" v-for="pet in pets" v-bind:key="pet.petId"/>
  </div>
</template>

<script>
import PetDetails from '../components/PetDetails.vue'

export default {
name: 'pet-list',
components: {
PetDetails
},
data(){
  return{
    pets: []
  }
},
created(){
  this.pets=this.$store.state.pets;
}
}
</script>

<style>

.pet-container{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>