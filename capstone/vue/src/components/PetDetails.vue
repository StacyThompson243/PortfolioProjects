<template>
  <!-- <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}"> -->
  <div class="container">
    <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">
    <div class="card">
      <img :src='pet.petImage'/>
      <div class="cardText">
        <h2 class="pet-name">{{ pet.petName }}</h2>
        <p class='pet-type'>Type: {{ pet.type }}</p>
        <p class='pet-breed'>Breed: {{ pet.breed }}</p>
      </div>
      <!-- <router-link v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}"> -->
      <!-- <button class='learnMore' v-bind:to="{name: 'petDetailsView', params: { petId: pet.petId }}">Learn More</button><br> -->
    <!-- </router-link>  -->

      <!-- <router-link v-bind:to="{name: 'updatePet', params: {petId: pet.petId}}">
        <button class='update' v-if="$store.state.token != ''">Edit This Listing</button>
        </router-link> -->
    </div>  
    </router-link>  
    <div id="editHolder">
      <a v-on:click="setUpEdit" id='update' v-if="$store.state.token != ''">Edit</a>
    </div>
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
.container {
  margin: 0 3%;
}

.card {
  margin: 30px 0 10px 0;
  /* padding: 5px; */
  /* border: 1px solid black; */
  width: 300px;
  overflow:hidden;
  box-shadow: 2px 4px 4px rgb(204, 204, 204);
  /* background-color: #0F4F6A; */
  /* margin: 0 20%; */
}

.card:hover {
  background-color: #C5E8F7;
  transition: 0.2s;
}

img {
  display: block;
  margin: auto;
  height: 250px;
  /* min-width: 100%; */
  object-fit: contain;
  /* box-shadow: 2px 4px 4px; */
  /* width: 250px; */
}

.cardText {
  margin: 5px;
}

.learnMore {
  background-color: rgba(255, 255, 255);
  border: none;
  color: black;
  /* padding: 18px 54px; */
  font-size: 16px;
  border-radius: 5px;
}

h2 {
  margin-bottom: 3px;
  color: #0F4F6A;
}

a {
  color: black;
}

#editHolder {
  display: flex;
  justify-content: flex-end;
}

#update {
  text-align: right;
}

#update:hover {  
  cursor: pointer;
}
</style>