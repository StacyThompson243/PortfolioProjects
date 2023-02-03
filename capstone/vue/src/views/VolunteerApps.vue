<template>
  <div>
      <h1>Volunteer Applications</h1>
      <form action="">
      <table class="application-table">
          <thead>
          <tr>
              <th>Application ID</th>
              <th>Full Name</th>
              <th>Email</th>
              <th>Over 18?</th>
              <th>Veterinary Skills</th>
              <th>Cleaning Skills</th>
              <th>Data Entry Skills</th>
              <th>Photography Skills</th>
              <th>Status</th>
              <th>Action</th>
          </tr>
          </thead>
          <tbody>
              <tr v-for="(volunteer, key) in volunteerList" v-bind:key="key">
                  <td>{{volunteer.applicationId}}</td>
                  <td>{{volunteer.volunteerFirstName}} {{volunteer.volunteerLastName}}</td>
                  <td>{{volunteer.email}}</td>
                  <td>{{volunteer.over18 ? "Yes" : "No"}}</td>
                  <td>{{volunteer.veterinary ? "Yes" : "No"}}</td>
                  <td>{{volunteer.cleaning ? "Yes" : "No"}}</td>
                  <td>{{volunteer.dataEntry ? "Yes" : "No"}}</td>
                  <td>{{volunteer.photography ? "Yes" : "No"}}</td>
                  
                  <td>
                      <select 
                      v-model="volunteer.status" name="dropdown-select" id="dropdown-select">
                          <option value="Pending">Pending</option>
                            <option value="Approved">Approve</option>
                              <option value="Denied">Deny</option>
                       </select></td>
                  <td><button v-on:click.prevent="updateStatus(volunteer)">Submit</button></td>
              </tr>
          </tbody>
      </table>
      </form>
  </div>
</template>

<script>
import VolunteerService from "../services/VolunteerService"
export default {
    name: "volunteerApplications",
data(){
    return {
        volunteerList: [],
        filters: ['Veterinary Skills'],
    }
},
computed: {
    filterApplications(){
       return this.volunteerList.filter( eachVolunteer => {
            if(this.filters.includes('Veterinary Skills')){
                return eachVolunteer.veterinary;
            } 
            return false;
        }) 
    }
},
created(){
VolunteerService.viewVolunteer().then((response) =>{
if(response.status === 200){
      this.volunteerList = response.data;
    }
})
},  
methods:{
    updateStatus(volunteer){
        if(confirm('Click OK to confirm status change') == true){
        VolunteerService.updateVolunteerStatus(volunteer.applicationId, volunteer).then((response) =>{ 
            if(response.status === 200){
            alert("Volunteer has been updated")
            this.volunteerList = this.volunteerList.filter(eachVolunteer => {
            return eachVolunteer.status === "Pending";
        })
            }
        })
    }
    }
}
}
</script>

<style>
.application-table, th, td{
    border: 1px solid black;
    border-collapse: collapse;
}
</style>