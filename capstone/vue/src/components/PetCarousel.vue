<template>
  <div class="carousel">
    <h1>Critter Cabin</h1>
    <div id="bottomLine"></div>
    <div :key="petSrc.id">
      <div class="card">
        <img :src="petSrc.petImage" alt="" />
        <div id="petInfo">
          <h2 id="name">{{ petSrc.petName }}</h2>
          <p id="description">{{ petSrc.description }}</p>

          <button class="btn">{{ petSrc.petName }}'s page</button>
        </div>
      </div>
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

      self.petSrc = self.pets[Math.floor(Math.random() * self.pets.length)];

      // setInterval(function () {
      //   self.petSrc = self.pets[Math.floor(Math.random() * self.pets.length)];
      // }, 3000);
    });
  },
};
</script>
<style scoped>
h1 {
  margin-top: 92px;
}

#bottomLine {
  margin-bottom: 30px;
}

.card {
  display: flex;
  height: 475px;
  justify-content: center;
}

img {
  box-shadow: 2px 4px 4px rgb(204 204 204);
  height: 475px;
  border-radius: 8px 0 0 8px;
}

/* div #petInfo {
  text-align: center;
  vertical-align: middle;
  margin-top: 20px;
  background-color: blueviolet;
} */

#petInfo {
  vertical-align: middle;
  background-color: rgb(253, 253, 253);
  border-radius: 0 8px 8px 0;
  width: 350px;
  padding: 10px;
  box-shadow: 2px 4px 4px rgb(204 204 204);
}

h2 {
  text-align: center;
  margin-bottom: 5px;
  color: #0f4f6a;
}

.btn {
  background-color: #20a7e1;
  color: rgb(245, 245, 245);
  width: 100%;
}

.btn:hover {
  background-color: #1a92c5;
  transition: 0.3s;
  cursor: pointer;
}
</style>
