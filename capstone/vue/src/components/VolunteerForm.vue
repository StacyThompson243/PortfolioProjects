<template>
<div>
  <h1 class="form-title">New Volunteer Form</h1>
  <!-- <a><iframe src="https://docs.google.com/forms/d/e/1FAIpQLSc5rUXlj9__lDBWQhbUfWbKfDY7n_c7gDRajhMNgXD4wGQ2pQ/viewform?embedded=true" width="640" height="1050" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe></a> -->
  <form class="form"
  v-on:submit.prevent="saveVolunteer()"
  >
        <div>
<<<<<<< HEAD
            <label for="first-name">First Name:</label>
            <input v-model="volunteer.volunteerFirstName" id="first-name" name="first-name" type="text" required/>
        </div>
               <div>
            <label for="last-name">Last Name:</label>
            <input v-model="volunteer.volunteerLastName" id="last-name" name="last-name" type="text" required/>
=======
            <label for="name">Name:</label>
            <input v-model="volunteer.volunteerName" id="name" name="name" type="text" required/>
>>>>>>> main
        </div>
        <div>
            <label for="email">Email:</label>
            <input v-model="volunteer.email" id="email" name="email" type="email" required/>
        </div>
<<<<<<< HEAD
                <div>
            <label for="confirmation">Are you over 18?:</label>
            <input v-model="volunteer.over18" id="confirmation" name="confirmation" type="checkbox"/>
        </div>
<div>Areas of Interest:</div>
                <div>
            <label for="veterinary">Veterinary: </label>
            <input v-model="volunteer.veterinary" id="veterinary" name="veterinary" type="checkbox"/>
        </div>
                <div>
            <label for="cleaning">Cleaning: </label>
            <input v-model="volunteer.cleaning" id="cleaning" name="cleaning" type="checkbox"/>
        </div>
                <div>
            <label for="dataEntry">Data Entry: </label>
            <input v-model="volunteer.dataEntry" id="dataEntry" name="dataEntry" type="checkbox"/>
        </div>
                <div>
            <label for="photography">Photography: </label>
            <input v-model="volunteer.photography" id="photography" name="photography" type="checkbox"/>
        </div>

=======
        <div>
            <label for="confirmation">Are you over 18?:</label>
            <input v-model="volunteer.over18" id="confirmation" name="confirmation" type="checkbox"/>
        </div>
>>>>>>> main
        <input type="submit">
    </form>
  </div>
</template>
<script>
<<<<<<< HEAD

=======
>>>>>>> main
import VolunteerService from "../services/VolunteerService"
export default {
  data(){
    return {
      volunteer: {
<<<<<<< HEAD
        volunteerFirstName: '',
        volunteerLastName: '',
        email: '',
        over18: false,
        veterinary: false,
        cleaning: false,
        dataEntry: false,
        photography: false,
=======
        volunteerName: '',
        email: '',
        over18: false,
>>>>>>> main
      }
    }
  },
methods: {
  saveVolunteer() {
    console.log(this.volunteer)
  VolunteerService.addVolunteer(this.volunteer).then(response => {
    if(response.status === 201){
     alert("Thank you for applying to be a volunteer!")
      this.$router.push("/volunteer/apply")
<<<<<<< HEAD
      this.resetForm();
    }
  }) 
      
=======
    }
  })
      this.resetForm();
>>>>>>> main
    },
    resetForm(){
      this.volunteer = {
        volunteerName: '',
<<<<<<< HEAD
        volunteerLastName: '',
        email: '',
        over18: false,
        veterinary: false,
        cleaning: false,
        dataEntry: false,
        photography: false,
      }
    }
=======
        email: '',
        over18: false,
      }
    }
//     resetForm(){
//       this.volunteer= {
//         name: '',
//         email: '',
//         over18: false,
//       },
>>>>>>> main
 }
}
</script>
<style>
.form-title{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
.form{
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: flex-start;
<<<<<<< HEAD
  align-items: flex-start;
=======
  align-items: center;
>>>>>>> main
  align-content: stretch;
}
</style>