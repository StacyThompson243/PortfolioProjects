<template>
  <div class="page">
<div id="titleDiv">
    <h1>Adoption Form</h1>

</div>
<form action="form" v-on:submit.prevent="saveAdoptionRequest">
<div class="container">

<div class="adopterNameDiv">
        <label for="full-name">Full Name: </label>
        <input 
        v-model="adopter.adopterName" 
        id="full-name" name="full-name" type="text" 
        required/></div>

 <div class="emailDiv">
          <label for="email">Email: </label>
          <input
            v-model="adopter.email"
            id="email" name="email" type="email"
            required/></div>

 <div class="phoneNumberDiv">
          <label for="phoneNumber">Phone Number (1234567890): </label>
          <input
            v-model="adopter.phoneNumber"
            id="phoneNumber" name="phoneNumber"  type="text"
              maxlength="10"
              minlength="10"
            required/></div>

         <div class="cityDiv">
          <label for="city">City: </label>
          <input
            v-model="adopter.city"
            id="city" name="city" type= "text"
            /></div>

        <div class="stateDiv">
          <label for="state">State (abbreviation): </label>
          <input
            v-model="adopter.state"
            id="state" name="state"  type="text"
              maxlength="2"
              minlength="2"

            /></div>

        <div class="zipcodeDiv">
          <label for="zipcode">Zipcode: </label>
          <input
            v-model="adopter.zipcode"
            id="zipcode" name="zipcode" type= "text"
            /></div>

        <div class="anyPetsDiv">
          <label for="anyPets">Do you currently have any pets? (check if yes) </label>
          <input
            v-model="adopter.anyPets"
            id="anyPets" name="anyPets" type= "checkbox"
            /></div>

        <div class="numberOfPetsDiv">
          <label for="numberOfPets"> If so, how many? </label>
          <input
            v-model="adopter.numberOfPets"
            id="numberOfPets" name="numberOfPets" type= "number"
            /></div>

</div>
<button class="btn" type="submit">Submit</button>
</form>
  </div>
</template>

<script>
import AdoptionService from "../services/AdoptionService";
import PetService from "../services/PetService";
export default {
data() {
    return {
      adopter: {
        adopterName: "",
        email: "",
        phoneNumber: "",
        city: "",
        state: "",
        zipcode: null,
        anyPets: false,
        numberOfPets: 0,
        approvalStatus: "Pending",
      },
      pet: {},
    };
  },
      created() {
        PetService.getPetById(this.$route.params.petId).then((response) =>{
            if(response.status == 200){
                this.pet = response.data;
            }
        })
    },
  methods: {
      saveAdoptionRequest(){
          console.log(this.$route.params.petId);
      AdoptionService.addAdoptionRequest(this.$route.params.petId, this.adopter).then((response) => {
        if (response.status === 201) {
          alert("Thank you for applying to adopt this critter!");
        this.$router.push("/pets");
        //   this.pet.adopterId = response.data.adopterId
        //   PetService.updatePet(this.$route.params.petId, this.pet).then((response) => { 
        //       if (response.status === 202){
        // //  back to browse pets
        //   this.$router.push("/pets");
        //   }
        //   })
        }
      });
      this.resetForm();
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
        numberOfPets: 0,
        approvalStatus: "Pending",
      };
    }
  }
}
</script>

<style scoped>
h1 {
  padding: 10px;
  margin: 102px 0 10px 0;
}

#titleDiv {
  margin: auto;
  backdrop-filter: blur(5px);
  width: 350px;
  border-radius: 7px;
}

/* .page {
  background-image: url(../assets/volunteer.jpg);
} */

.form {
  backdrop-filter: blur(1px);
}

.container, div {
  margin-bottom: 4px;
}

/* .fullNameDiv {
  display: flex;
  justify-content: space-between;
}

.fullNameDiv div {
  display: flex;
  flex-direction: column;
}

.emailDiv {
  display: flex;
  flex-direction: column;
  margin-bottom: 4px;
}

.emailDiv label {
  margin-top: 4px;
} */

.checkBoxDiv {
  display: flex;
  justify-content: space-between;
  padding: 4px 0;
}

/* .bottomContainer div:nth-child(even) {
  background-color: rgba(255, 255, 255, 0.5);
}

.bottomContainer div:nth-child(odd) {
  background-color: rgba(255, 255, 255, 0.2);
} */

.checkBoxDiv label {
  width: 95%;
}

.btn {
  width: 10%;
}
</style>