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
  data(){
    return {
      isLoading: true,
    }
  },
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

.page-loader{
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    /* background-color: blue; */
    z-index: 999
}

</style>
