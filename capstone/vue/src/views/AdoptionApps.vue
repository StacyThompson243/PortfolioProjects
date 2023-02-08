<template>
  <div class="background">
<h1>Volunteer Applications</h1>
    <div id="bottomLine"></div>
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
                numberOfPets: 0,
            }
        }
    },
    computed: {
        filterApplications(){
            let arr = this.adoptionList;


            return arr;
        }
    },
    created(){
AdoptionService.viewAdoptionApplications().then((response) => {
    if (response.status === 200) {
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