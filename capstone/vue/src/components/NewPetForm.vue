<template>
  <div class="newform">
    <h1>New Pet Form</h1>
    <div class="bottomLine"></div>
    <form class="new-pet-form" v-on:submit.prevent="savePet">
      <label for="petName">Name:</label>
      <input
        class="name-input"
        type="text"
        name="petName"
        placeholder="Pet Name"
        v-model="pet.petName"
      />
      <label for="petImage">Image URL:</label>
      <input
        class="image-input"
        type="text"
        name="petImage"
        placeholder="Pet Image"
        v-model="pet.petImage"
      />
      <button @click.prevent="uploadImage">Upload Image</button>

      <label for="petType">Pet Type:</label>
      <input
        class="type-input"
        type="text"
        name="petType"
        placeholder="Pet Type"
        v-model="pet.type"
      />
      <label for="petAge">Age:</label>
      <input
        class="age-input"
        type="text"
        name="petAge"
        placeholder="Age"
        v-model="pet.age"
      />
      <label for="petGender">Gender:</label>
      <input
        class="gender-input"
        type="text"
        name="petGender"
        placeholder="Gender"
        v-model="pet.gender"
      />
      <label for="petBreed">Breed:</label>
      <input
        class="breed-input"
        type="text"
        name="petBreed"
        placeholder="Breed"
        v-model="pet.breed"
      />
      <label for="petWeight">Weight(lbs):</label>
      <input
        class="weight-input"
        type="text"
        name="petWeight"
        placeholder="Weight"
        v-model="pet.weight"
      />
      <label for="description">Description:</label>
      <input
        class="description"
        type="text"
        name="description"
        placeholder="Description"
        v-model="pet.description"
      />
      <button class="btn">Save Pet</button>
    </form>

    <div class="cancel">
      <button v-on:click="cancel">Cancel</button>
    </div>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";

export default {
  data() {
    return {
      selectedImage: null,
      pet: {
        petName: "",
        petImage: "",
        type: "",
        age: "",
        gender: "",
        breed: "",
        weight: "",
        description: "",
      },
    };
  },
  methods: {
    savePet() {
      PetService.addPet(this.pet).then((response) => {
        if (response.status === 201) {
          alert("Pet Successfully Added!");
          this.$router.push("/pets");
        }
      });
    },
    uploadImage() {
      this.myWidget.open();
    },
    cancel() {
      this.$router.push("/pets");
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
};
</script>

<style scoped>
.newform {
  text-align: center;
}

.new-pet-form {
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
}
</style>

