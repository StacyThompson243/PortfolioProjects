<template>
  <div>
    <div class="carousel">
      <pet-carousel />
      <!-- <img src="" alt=""> -->
    </div>
    <div class="petDescription"></div>
  </div>
</template>

<script>
import PetCarousel from "../components/PetCarousel.vue";

export default {
  name: "home",
  components: {
    PetCarousel,
  },
};
</script>

<style scoped>
.petDescription {
  width: 500px;
  height: 250px;
  background-color: brown;
}
</style>
