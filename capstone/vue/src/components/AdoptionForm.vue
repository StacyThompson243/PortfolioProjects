<template>
  <div class="page">
<div id="titleDiv">
    <h1>Adoption Form</h1>
</div>
<form action="form" v-on:submit.prevent="saveAdoptionRequest()">


</form>
  </div>
</template>

<script>
export default {
data() {
    return {
      adopter: {
        fullName: "",
        email: "",
        phoneNumber: "",
        city: "",
        state: "",
        zipcode: null,
        anyPets: false,
        numberOfPets: null,
      },
    };
  },
  methods: {
      saveAdoptionRequest(){
    //       console.log(this.volunteer);
    //   VolunteerService.addVolunteer(this.volunteer).then((response) => {
    //     if (response.status === 201) {
    //       alert("Thank you for applying to be a volunteer!");
    //       this.$router.push("/volunteer/apply");
    //     }
    //   });
    //   this.resetForm();
      },
    resetForm() {
      this.adopter = {
        fullName: "",
        email: "",
        phoneNumber: "",
        city: "",
        state: "",
        zipcode: null,
        anyPets: false,
        numberOfPets: null,
      };
    },
  }
}
</script>

<style>

</style>