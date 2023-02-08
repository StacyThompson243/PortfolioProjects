<template>
  <div class="carousel">
    <div :key="petSrc.id">
      <img :src="petSrc.petImage" alt="" />
      {{ petSrc.petName }}
    </div>
  </div>
</template>
<script>
import PetService from "../services/PetService.js";
export default {
  name: "pet-carousel",
  data() {
    return {
      petSrc: null,
      pets: [],
    };
  },
  created() {
    let self = this;
    PetService.getAdoptablePets().then((response) => {
      this.pets = response.data;
      setInterval(function () {
        self.petSrc = self.pets[Math.floor(Math.random() * self.pets.length)];
      }, 5000);
    });
  },
};
</script>
<style scoped>
.carousel,
img {
  width: 500px;
  height: 360px;
}
</style>
