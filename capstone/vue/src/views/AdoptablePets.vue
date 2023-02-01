<template>
<div>
  <div class='list'>
      <pet-list />
      <div class="btn">
      <router-link v-bind:to="{name: 'newPetForm'}">
      <button v-if="$store.state.token != ''">Add To Adoptable Pets</button>
      </router-link>
      </div>
  </div>
  </div>
</template>

<script>
import PetList from '../components/PetList.vue'
export default {
  components: { PetList },

}
</script>

<style>

.btn{
  display: flex;
  justify-content: center;
}

</style>