<template>
  <div class="page">
    <h1>{{ pet.petName }}</h1>
    <div id="bottomLine"></div>
    <div id="wrapper">
      <img :src="pet.petImage" />
      <div class="card">
        <div>
          <div class="horizontalAlign">
            <div class="left">
              <p>Type:</p>
              <p>Breed:</p>
              <p>Gender:</p>
              <p>Weight:</p>
              <p>Age:</p>
            </div>
            <div class="right">
              <p>{{ pet.type }}</p>
              <p>{{ pet.breed }}</p>
              <p>{{ pet.gender }}</p>
              <p>{{ pet.weight }} lbs</p>
              <p>{{ pet.age }} years old</p>
            </div>
          </div>
          <p id="description">{{ pet.description }}</p>
        </div>
        <div class="buttonContainer">
          <button class="btn">Apply to Adopt</button>
          <router-link v-bind:to="{ name: 'pets' }"
            ><button class="btn">Browse Pets</button></router-link
          >
        </div>
      </div>
      <!-- <div id="editHolder">
        <a id="update" v-on:click="setUpEdit" v-if="$store.state.token != ''"
          >Edit</a
        >
      </div> -->
    </div>
  </div>
</template>

<script>
export default {
  props: ["petId"],
  computed: {
    pet() {
      return this.$store.getters.pet;
    },
  },
  created() {
    const activePetId = this.$route.params.petId;
    this.$store.commit("SET_ACTIVE_PET", activePetId);
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

#wrapper {
  margin-top: 30px;
  display: flex;
  justify-content: center;
}

h1 {
  margin-top: 92px;
}

.card {
  background-color: rgb(253, 253, 253);
  /* background-color: rgb(255, 255, 255, 0.5); */
  border-radius: 0 8px 8px 0;
  padding: 10px;
  width: 350px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  box-shadow: 2px 4px 4px rgb(204, 204, 204);
}

.horizontalAlign {
  display: flex;
}

.left {
  font-weight: 800;
}

.right {
  margin-left: 20px;
}

img {
  border-radius: 8px 0 0 8px;
  height: 475px;
  box-shadow: 2px 4px 4px rgb(204, 204, 204);
}

p {
  margin-top: 4px;
}

#description {
  margin-top: 10%;
}

#editHolder {
  display: flex;
  justify-content: flex-end;
}

#update {
  /* text-align: right; */
  margin-left: 10px;
}

#update:hover {
  cursor: pointer;
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
