<template>
  <div class="pet-list">
    <h1>Adoptable Pets</h1>
    <div class="search">
       <label for="pet type">Pet Type:</label>
      <input name='pet type' type="text" v-model="filter.type" placeholder="search pet type" />
     
      <label for="breed">Breed:</label>
      <input name='breed' type="text" v-model="filter.breed" placeholder="search breed" />
      
      <label for="search gender">Gender:</label>
      <select 
      v-model="filter.gender" name="search gender" placeholder="search gender">
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      </select>

       <label for="weight">Weight:</label>
      <input name='weight' type="text" v-model="filter.weight" placeholder="search weight" />
      
       <label for="age">Age:</label>
      <input name="age" type="text" v-model="filter.age" placeholder="search age" />
    </div>

    <div class="pet-container">
      <pet-details
        v-bind:pet="pet"
        v-for="pet in filteredPets"
        v-bind:key="pet.petId"
      />
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
.pet-list {
  text-align: center;
}

input{
  margin-right: 20px;
}

select{
  margin-right: 20px;
}

.pet-container {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>