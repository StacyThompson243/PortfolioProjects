<template>
  <div class="page">
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
  background: rgb(223, 251, 240);
  background: linear-gradient(
    90deg,
    rgb(220, 251, 240) 0%,
    rgba(227, 244, 251, 1) 100%
  );
}
</style>
