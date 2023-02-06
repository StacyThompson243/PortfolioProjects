<template>
  <div class="pet-list">    
    <h1>Adoptable Pets</h1>
    <div id="bottomLine"></div>
    <div class="wrapper">
      <div id="sidebar">      
        <div>
          <label for="pet type">Species:</label>
          <input name='pet type' type="text" v-model="filter.type"/>
        </div>
        <div>
          <label for="breed">Breed:</label>
          <input name='breed' type="text" v-model="filter.breed"/>
        </div>
        <div>
          <label for="search gender">Gender:</label>
          <select 
          v-model="filter.gender" name="search gender">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          </select>
        </div>
        <div>
          <label for="weight">Weight:</label>
          <input name='weight' type="text" v-model="filter.weight"/>
        </div>
        <div>
          <label for="age">Age:</label>
          <input name="age" type="text" v-model="filter.age"/>
        </div>

        <router-link v-bind:to="{name: 'newPetForm'}">
          <button class="btn" v-if="$store.state.token != ''">Add Pet</button>
        </router-link>

      </div>
      <div id="sideBorder"></div>

      <div id="pet-container">
        <pet-details
          v-bind:pet="pet"
          v-for="pet in filteredPets"
          v-bind:key="pet.petId"
        />
      </div>
    </div>
  </div>
</template>

<script>
import PetDetails from "../components/PetDetails.vue";
import PetService from "../services/PetService.js";

export default {
  name: "pet-list",
  components: {
    PetDetails,
  },
  data() {
    return {
      pets: [],
      filter: {
        type: "",
        breed: "",
        gender: "",
        age: "",
        weight: "",
      },
    };
  },
  created() {
    PetService.getAdoptablePets().then((response) => {
      this.pets = response.data;
      this.$store.commit("SET_PETS", this.pets);
    });
  },
  computed: {
    filteredPets() {
      let filteredPetsList = this.pets;
      if (this.filter.type != "") {
        filteredPetsList = filteredPetsList.filter((pet) =>
          pet.type.toLowerCase().includes(this.filter.type.toLowerCase())
        );
      }
      if (this.filter.breed != "") {
        filteredPetsList = filteredPetsList.filter((pet) =>
          pet.breed.toLowerCase().includes(this.filter.breed.toLowerCase())
        );
      }
      if (this.filter.gender != "") {
        filteredPetsList = filteredPetsList.filter((pet) =>
          pet.gender.toLowerCase().includes(this.filter.gender.toLowerCase())
        );
      }
      if (this.filter.age != "") {
        filteredPetsList = filteredPetsList.filter((pet) =>
          pet.age.toLowerCase().includes(this.filter.age.toLowerCase())
        );
      }
      if (this.filter.weight != "") {
        filteredPetsList = filteredPetsList.filter((pet) =>
          pet.weight.toLowerCase().includes(this.filter.weight.toLowerCase())
        );
      }
     
      return filteredPetsList;
    },
  },
};
</script>

<style scoped>
.wrapper {
  display: flex;
  /* font-weight: 300; */
}

#pet-container {
  margin-right: 40px;
  /* margin-top: 30px; */
}

#sidebar {
  /* background-color: #D4EEF9; */
  height: 25vh;  
  margin: 0 30px 0 30px;
  position: sticky;
  top: 20vh;
  /* border: 1px solid black; */
  border-radius: 5px;
  padding: 2px;
}

#sidebar div {
  display: flex;
  flex-direction: column;
  padding: 4px 0px;
  margin-bottom: 10px;
}

/* #sidebar div:hover {
  transition: 0.25s;
  background-color: #82F2C1;  
}  */

#sideBorder {
  height: 60vh;
  border-right: 2px solid #7ACAED;
  margin-right: 30px;
  position: sticky;
  top: 20vh
}

.btn {
  background-color: rgb(218, 218, 218);
  width: 100%;
}

.btn:hover {
  background-color: #A1F5D0;
  transition: 0.5s;
  cursor: pointer;
}

#pet-container {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>