<template>
  <div>
    <h1>Add Photos for</h1>
    <h1>{{ pet.petName }}</h1>
    <div id="imgUploadDiv">
      <div>
        <label for="petImage">Image URL:</label>
        <input type="text" name="petImage" v-model="pet.petImage" />
      </div>
      <button id="upload" @click.prevent="uploadImage">Upload Image</button>
      <br>
      <button @click="addImage">Finished?</button>
    </div>
  </div>
</template>

<script>
 import PetImageService from "../services/PetImageService.js"
export default {
  // props: ['petId'],
  name: "add-photos",
  data(){
    return{
    petImages: [],
    pet: {}
    }
  },
  computed:{
    petImage(){
      return this.$store.getters.petImage;
    }
  },
  created() {
    this.pet = this.$store.state.activePet;
    

    // const activeImageId = this.$route.params.petId;
    // this.$store.commit("SET_ACTIVE_PET,", activeImageId)

  },
  methods: {
    addImage(){
      const newPet = {
        petImage : this.pet.petImage,
        petId: this.$route.params.petId
      }
      PetImageService.addPetImage(this.$route.params.petId, newPet).then((response)=>{
        if (response.status === 201) {
          alert("Images Added!");
          this.$router.push("/pets");
        }
        });
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
};
</script>

<style>
</style>