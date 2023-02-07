<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="480"
      img-height="auto"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide v-for="pet in pets" :key="pet.petId"
        ><b-img :img-src="pet.petImage"
      /></b-carousel-slide>
    </b-carousel>

    <p class="mt-4">
      Slide #: {{ slide }}<br />
      Sliding: {{ sliding }}
    </p>
  </div>
</template>

<script>
import PetService from "../services/PetService.js";

export default {
  name: "pet-carousel",
  data() {
    return {
      slide: 0,
      sliding: null,
      pets: [],
    };
  },
  created() {
    PetService.getAdoptablePets().then((response) => {
      this.pets = response.data;
    });
  },
  methods: {
    onSlideStart(slide) {
      console.log(slide);
      this.sliding = true;
    },
    onSlideEnd(slide) {
      console.log(slide);
      this.sliding = false;
    },
  },
};
</script>

<style scoped></style>
