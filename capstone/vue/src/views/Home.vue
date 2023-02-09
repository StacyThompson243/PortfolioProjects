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
.page {
  /* background: rgb(223, 251, 240);
  background: linear-gradient(
    90deg,
    rgb(220, 251, 240) 0%,
    rgba(227, 244, 251, 1) 100%
  ); */
  background-image: url(../assets/home.jpg);
  /* filter: blur(3px); */
}

.blurredImg {
  /* height: 100%; */
}
</style>
