<template>
<div>
  <h1 class="form-title">New Volunteer Form</h1>
  <!-- <a><iframe src="https://docs.google.com/forms/d/e/1FAIpQLSc5rUXlj9__lDBWQhbUfWbKfDY7n_c7gDRajhMNgXD4wGQ2pQ/viewform?embedded=true" width="640" height="1050" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe></a> -->
  <form class="form"
  v-on:submit.prevent="saveVolunteer()"
  >
        <div>
            <label for="name">Name:</label>
            <input v-model="volunteer.volunteerName" id="name" name="name" type="text" required/>
        </div>
        <div>
            <label for="email">Email:</label>
            <input v-model="volunteer.email" id="email" name="email" type="email" required/>
        </div>
        <div>
            <label for="confirmation">Are you over 18?:</label>
            <input v-model="volunteer.over18" id="confirmation" name="confirmation" type="checkbox"/>
        </div>
        <input type="submit">
    </form>
  </div>
</template>
<script>

import VolunteerService from "../services/VolunteerService"
export default {
  data(){
    return {
      volunteer: {
        volunteerName: '',
        email: '',
        over18: false,
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
    }
  })
      this.resetForm();
    },
    resetForm(){
      this.volunteer = {
        volunteerName: '',
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
  align-items: center;
  align-content: stretch;
}
</style>