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
              <tr>
                  <td><input type="text" v-model="filters.applicationId" id="idFilter"></td>
                  <td><input type="text" v-model="filters.volunteerFullName" id="fullNameFilter"></td>
                  <td><input type="text" v-model="filters.email" id="emailFilter"></td>
                  <td>
                      <select v-model="filters.over18" id="over18Filter">
                        <option value="Show All" selected="true">Show All</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                      </select>
                </td>
                <td>
                      <select v-model="filters.veterinary" id="veterinaryFilter">
                        <option value="Show All" selected="true">Show All</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                      </select>
                </td>
                <td>
                      <select v-model="filters.cleaning" id="cleaningFilter">
                        <option value="Show All" selected="true">Show All</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                      </select>
                </td>
                <td>
                      <select v-model="filters.dataEntry" id="dataEntryFilter">
                        <option value="Show All" selected="true">Show All</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                      </select>
                </td>
                <td>
                      <select v-model="filters.photography" id="photographyFilter">
                        <option value="Show All" selected="true">Show All</option>
                        <option value="Yes">Yes</option>
                        <option value="No">No</option>
                      </select>
                </td>

              <td></td>
              </tr>
          </tbody>
       
         <tbody>
              <tr v-for="(volunteer, key) in filterApplications" v-bind:key="key">
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
        filters: {
                applicationId: "",
                volunteerFullName: "",
                email: "",
                over18: "Show All",
                veterinary: "Show All",
                cleaning: "Show All",
                dataEntry: "Show All",
                photography: "Show All",
        },
    }
},
computed: {
    filterApplications(){

    //    return this.volunteerList;


       let arr = this.volunteerList
       if (this.filters.applicationId != ''){
        arr = arr.filter( (eachVolunteer) => {
          return eachVolunteer.applicationId == parseInt(this.filters.applicationId)
        })
       } 
       if (this.filters.volunteerFullName != ''){
        arr = arr.filter( (eachVolunteer) => {
          return eachVolunteer.volunteerFirstName.toLowerCase().includes(this.filters.volunteerFullName.toLowerCase()) || 
          eachVolunteer.volunteerLastName.toLowerCase().includes(this.filters.volunteerFullName.toLowerCase())
        })
       }
        if (this.filters.email != ''){
        arr = arr.filter( (eachVolunteer) => {
          return eachVolunteer.email.toLowerCase().includes(this.filters.email.toLowerCase())
        })
       } 
        if (this.filters.over18 != 'Show All'){
        arr = arr.filter( 
            (eachVolunteer) => { 
                let booleanValue = this.filters.over18 == "Yes"? true : false;  

                return eachVolunteer.over18 === booleanValue;
            }
        );
       }

       if (this.filters.veterinary != 'Show All'){
        arr = arr.filter( 
            (eachVolunteer) => { 
                let booleanValue = this.filters.veterinary == "Yes"? true : false;  

                return eachVolunteer.veterinary === booleanValue;
            }
        );
       } 
       if (this.filters.cleaning != 'Show All'){
        arr = arr.filter( 
            (eachVolunteer) => { 
                let booleanValue = this.filters.cleaning == "Yes"? true : false;  

                return eachVolunteer.cleaning === booleanValue;
            }
        );
       } 
         if (this.filters.dataEntry != 'Show All'){
        arr = arr.filter( 
            (eachVolunteer) => { 
                let booleanValue = this.filters.dataEntry == "Yes"? true : false;  

                return eachVolunteer.dataEntry === booleanValue;
            }
        );
       } 
       if (this.filters.photography != 'Show All'){
        arr = arr.filter( 
            (eachVolunteer) => { 
                let booleanValue = this.filters.photography == "Yes"? true : false;  

                return eachVolunteer.photography === booleanValue;
            }
        );
       } 
            return arr;
    

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