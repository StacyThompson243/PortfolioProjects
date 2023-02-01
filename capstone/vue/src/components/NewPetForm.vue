<template>
<div>
  <h1>New Pet Form </h1>
  <form class="new-pet-form" v-on:submit.prevent="savePet">
      <label for="petName">Name:</label>
      <input class="name-input" type="text" name="petName" placeholder="Pet Name" v-model="pet.petName"/>
      <label for="petType">Pet Type:</label>
      <input class="type-input" type="text" name ="petType" placeholder="Pet Type" v-model="pet.type"/>
      <label for="petAge">Age:</label>
      <input class="age-input" type="text" name ="petAge" placeholder="Age" v-model="pet.age"/>
      <label for="petGender">Gender:</label>
      <input class="gender-input" type="text" name ="petGender" placeholder="Gender" v-model="pet.gender"/>
      <label for="petBreed">Breed:</label>
      <input class="breed-input" type="text" name ="petBreed" placeholder="Breed" v-model="pet.breed"/>
      <label for="petWeight">Weight(lbs):</label>
      <input class="weight-input" type="text" name ="petWeight" placeholder="Weight" v-model="pet.weight"/>
      <label for="description">Description:</label>
      <input class="description" type="text" name ="description" placeholder="Description" v-model="pet.description"/>
      <button v-on:click="redirect">Save Pet</button>
      </form>
</div>
</template>

<script>

import PetService from '../services/PetService.js'

export default {
    data(){
        return{
            pet:{
                petName: '',
                type: '',
                age: '',
                gender: '',
                breed: '',
                weight: '',
                description: ''
            }
        }
    },
methods:{
savePet(){
    PetService.addPet(this.pet).then(response => {
    if(response.status === 201){
     alert("Pet Successfully Added!")
      this.$router.push("/pets")
    }
  })
}
}
}
</script>

<style>

</style>