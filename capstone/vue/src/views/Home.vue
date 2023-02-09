<template>
  <div class="page">
    <div class="blurredImg"></div>
    <pet-carousel />
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
.blurredImg {
  background-image: url(../assets/home.jpg);
  filter: blur(3px);
}
</style>
