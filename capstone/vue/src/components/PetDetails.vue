<template>
  <!-- <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}"> -->
    <div class="info">
      <h2 class="pet-name">Hi, I'm {{ pet.petName }}!</h2>
      <img :src='pet.petImage'/>
      <h3 class='pet-type'>Type: {{ pet.type }}</h3>
      <h3 class='pet-breed'>Breed: {{ pet.breed }}</h3>
      <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">
      <button class='details' v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">Learn More</button><br>
   </router-link> 

     <!-- <router-link v-bind:to="{name: 'updatePet', params: {petId: pet.petId}}">
      <button class='update' v-if="$store.state.token != ''">Edit This Listing</button>
      </router-link> -->
  <button v-on:click="setUpEdit" class='update' v-if="$store.state.token != ''">Edit This Listing</button>

   </div>

</template>

<script>
export default {
  name: "pet-details",
  props: 
    ['pet'],
  methods:{
    setUpEdit(){
      this.$store.commit("SET_ACTIVE_PET", this.pet);
      this.$router.push({name: 'updatePet', params: {petId: this.pet.petId}})
    }
},

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
.details{
  margin-bottom: 20px;
}

.update{
  margin-bottom: 20px;
}
</style>