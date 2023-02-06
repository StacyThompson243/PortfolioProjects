<template>
  <div class="form">
    <h1>Update Pet Listing</h1>
    <form class="update-form" v-on:submit.prevent="updatePetDetails">
      <label for="name">Name:</label>
      <input type="text" v-model="pet.petName" />
      <label for="img">Image Url:</label>
      <input type="text" v-model="pet.petImage" />

      <button @click.prevent="uploadImage">Upload Image</button>

      <label for="type">Type:</label>
      <input type="text" v-model="pet.type" />
      <label for="age">Age:</label>
      <input type="text" v-model="pet.age" />
      <label for="gender">Gender:</label>
      <input type="text" v-model="pet.gender" />
      <label for="breed">Breed:</label>
      <input type="text" v-model="pet.breed" />
      <label for="weight">Weight(lbs):</label>
      <input type="text" v-model="pet.weight" />
      <label for="description">Description:</label>
      <input style="height: 100px" type="text" v-model="pet.description" />
      <label for="adopted">Adopted?</label>
      <input id="true" type="radio" value="true" v-model="pet.adopted" />
      <label for="true">True</label>
      <input id="false" type="radio" value="false" v-model="pet.adopted" />
      <label for="false">False</label>



      <button class="btn" type="submit">Save Updates</button>
    </form>
    <br />
    <div class="cancel">
      <button v-on:click="cancel">Cancel</button>
    </div>
  </div>
</template>

<script>
import PetService from "../services/PetService";

export default {
  name: "update-pet",
  data() {
    return {
      pet: {
        petId: "",
        petName: "",
        petImage: "",
        type: "",
        age: "",
        gender: "",
        breed: "",
        weight: "",
        decription: "",
        adopted: "",
      },
    };
  },
  methods: {
    updatePetDetails() {
      PetService.updatePet(this.pet.petId, this.pet).then((response) => {
        if (response.status === 202) {
          alert("Updates Successful!");
          this.$router.push("/pets");
        }
      });
    },
    cancel() {
      this.$router.push("/pets");
    },
    uploadImage() {
      this.myWidget.open();
    },
  },
  mounted() {
    this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here,
        // see the documentation
        cloudName: "difcq8eki",
        uploadPreset: "fjc27lbt",
      },
      (error, result) => {
        if (!error && result && result.event === "success") {
          console.log("Done! Here is the image info: ", result.info);
          console.log("Image URL: " + result.info.url);
          this.pet.petImage = result.info.url;
        }
      }
    );
  },
  created() {
    // PetService.getPetById(this.petId).then((response) => {
    //   this.$store.commit("SET_ACTIVE_PET", response.data);
    // });
    this.pet = this.$store.state.activePet;
    if (Object.keys(this.$store.state.activePet).length == 0) {
      alert("Could Not Find Listing");
    }
  },
};
</script>

<style scoped>
.form {
  display: flex;
  flex-direction: column;
  text-align: center;
}

.update-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  font-family: "Lucida Sans", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
  font-size: 1.65em;
}

.btn {
  margin-top: 20px;
}
.cancel {
  margin-top: 20px;
  text-align: center;
}
</style>