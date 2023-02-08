<template>
  <div class="background">

<h1>Adoption Applications</h1>
    <div id="bottomLine"></div>
    <form action="">
<table class="adoption-table">
<thead>
    <tr>
        <th>App ID</th>
        <!-- <th>Pet ID</th> -->
        <th>Adopter Full Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>City</th>
        <th>State</th>
        <th>Zipcode</th>
        <th>Any Pets?</th>
        <th># of Pets</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
</thead>

<tbody>
    <tr>
        <td><input type="text" v-model="filters.applicationID"></td>
        <!-- <td><input type="text" v-model="filters.petID"></td> -->
        <td><input type="text" v-model="filters.adopterFullName"></td>
        <td><input type="text" v-model="filters.email"></td>
        <td><input type="text" v-model="filters.phoneNumber"></td>
        <td><input type="text" v-model="filters.city"></td>
        <td><input type="text" v-model="filters.state"></td>
        <td><input type="text" v-model="filters.zipcode"></td>
        <td>
        <select v-model="filters.anyPets">
        <option value="Show All" selected="true">Show All</option>
        <option value="Yes">Yes</option>
        <option value="No">No</option>
        </select></td>
        <td><input type="text" v-model="filters.numberOfPets"></td>
        <td>
              <select v-model="adopter.status" name="dropdown-select">
                <option value="Pending">Pending</option>
                <option value="Approved">Approve</option>
                <option value="Denied">Deny</option>
              </select>
            </td>
            <td>
              <button v-on:click.prevent="updateStatus(adopter)">
                Submit
              </button>
               </td>
    </tr>
</tbody>

<tbody>
    <tr v-for="(adopter, key) in adoptionList" v-bind:key="key">
    <td>{{adopter.adopterId}}</td>
    <td>{{adopter.email}}</td>
    <td>{{adopter.phoneNumber}}</td>
    <td>{{adopter.city}}</td>
    <td>{{adopter.state}}</td>
    <td>{{adopter.zipcode}}</td>
    <td>{{adopter.anyPets}}</td>
    <td>{{adopter.numberOfPets}}</td>
    <td>{{adopter.approvalStatus}}</td>
    </tr>
</tbody>

</table>
    </form>
  </div>
</template>

<script>
import AdoptionService from "../services/AdoptionService";
export default {
    name: "adoptionApplications",
    data(){
        return {
            adoptionList: [],
            filters: {
                applicationID: "",
                adopterFullName: "",
                email: "",
                phoneNumber: "",
                city: "",
                state: "",
                zipcode: "",
                anyPets: "",
                numberOfPets: "",
                status: "",
            }
        }
    },
    computed: {
        filterApplications(){
            let arr = this.adoptionList;
            if (this.filters.applicationID != "") {
                arr = arr.filter((eachAdoption) => {
                    return (eachAdoption.applicationId == parseInt(this.filters.applicationID)
          );
        });
      }
    //   if (this.pet.petId != "") {
    //             arr = arr.filter((eachAdoption) => {
    //                 return (eachAdoption.petId == parseInt(this.pet.petId)
    //       );
    //     });
    //   }
        if (this.filters.adopterFullName != "") {
        arr = arr.filter((eachAdoption) => {
          return (
            eachAdoption.adopterFullName
              .toLowerCase()
              .includes(this.filters.adopterFullName.toLowerCase())
          );
        });
      }
      if (this.filters.email != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.email
            .toLowerCase()
            .includes(this.filters.email.toLowerCase());
        });
      }
        if (this.filters.phoneNumber != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.phoneNumber
            .toLowerCase()
            .includes(this.filters.phoneNumber.toLowerCase());
        });
      }
      if (this.filters.city != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.city
            .toLowerCase()
            .includes(this.filters.city.toLowerCase());
        });
      }
      if (this.filters.state != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.state
            .toLowerCase()
            .includes(this.filters.state.toLowerCase());
        });
      }
      if (this.filters.zipcode != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.zipcode
            .toLowerCase()
            .includes(this.filters.zipcode.toLowerCase());
        });
      }
      if (this.filters.anyPets != "") {
        arr = arr.filter((eachAdoption) => {
            let booleanValue = this.filters.anyPets == "Yes" ? true : false;

          return eachAdoption.anyPets === booleanValue;
        });
      }
      if (this.filters.numberOfPets != "") {
        arr = arr.filter((eachAdoption) => {
          return eachAdoption.numberOfPets
            .includes(this.filters.numberOfPets);
        });
      }

            return arr;
        }
    },
    created(){
        AdoptionService.viewAdoptionApplications().then((response) => {
    if (response.status === 200) {
        console.log("works")
        this.adoptionList = response.data;
    }
})
    },
    // methods: (
    //     updateStatus(){

    //     }
    // ),

}
</script>

<style>

</style>