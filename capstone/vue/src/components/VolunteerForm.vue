<template>
  <div>
    <h1>New Volunteer Form</h1>
    <!-- <a><iframe src="https://docs.google.com/forms/d/e/1FAIpQLSc5rUXlj9__lDBWQhbUfWbKfDY7n_c7gDRajhMNgXD4wGQ2pQ/viewform?embedded=true" width="640" height="1050" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe></a> -->
    <form class="form" v-on:submit.prevent="saveVolunteer()">
      <div class="namesDiv">
        <div>
          <label for="first-name">First Name:</label>
          <input
            v-model="volunteer.volunteerFirstName"
            id="first-name"
            name="first-name"
            type="text"
            required
          />
        </div>
        <div>
          <label for="last-name">Last Name:</label>
          <input
            v-model="volunteer.volunteerLastName"
            id="last-name"
            name="last-name"
            type="text"
            required
          />
        </div>
      </div>
      <div class="emailDiv">
        <label for="email">Email:</label>
        <input
          v-model="volunteer.email"
          id="email"
          name="email"
          type="email"
          required
        />
      </div>
      <div class="checkBoxDiv">
        <label for="confirmation">Are you over 18?</label>
        <input
          v-model="volunteer.over18"
          id="confirmation"
          name="confirmation"
          type="checkbox"
        />
      </div>
      <!-- <div>Areas of Interest:</div> -->
        <div class="checkBoxDiv">
          <label for="veterinary">Veterinary: </label>
          <input
            v-model="volunteer.veterinary"
            id="veterinary"
            name="veterinary"
            type="checkbox"
          />
        </div>
        <div class="checkBoxDiv">
          <label for="cleaning">Cleaning: </label>
          <input
            v-model="volunteer.cleaning"
            id="cleaning"
            name="cleaning"
            type="checkbox"
          />
        </div>
        <div class="checkBoxDiv">
          <label for="dataEntry">Data Entry: </label>
          <input
            v-model="volunteer.dataEntry"
            id="dataEntry"
            name="dataEntry"
            type="checkbox"
          />
        </div>
        <div class="checkBoxDiv">
          <label for="photography">Photography: </label>
          <input
            v-model="volunteer.photography"
            id="photography"
            name="photography"
            type="checkbox"
          />
        </div>
      <input class="btn" type="submit" />
    </form>
  </div>
</template>
<script>
import VolunteerService from "../services/VolunteerService";
export default {
  data() {
    return {
      volunteer: {
        volunteerFirstName: "",
        volunteerLastName: "",
        email: "",
        over18: false,
        veterinary: false,
        cleaning: false,
        dataEntry: false,
        photography: false,
      },
    };
  },
  methods: {
    saveVolunteer() {
      console.log(this.volunteer);
      VolunteerService.addVolunteer(this.volunteer).then((response) => {
        if (response.status === 201) {
          alert("Thank you for applying to be a volunteer!");
          this.$router.push("/volunteer/apply");
        }
      });
      this.resetForm();
    },
    resetForm() {
      this.volunteer = {
        volunteerFirstName: "",
        volunteerLastName: "",
        email: "",
        over18: false,
        veterinary: false,
        cleaning: false,
        dataEntry: false,
        photography: false,
      };
    },
  },
};
</script>
<style scoped>

.form {
  margin: auto;
  background-color: #c5c4f4;
  width: 500px;
  padding: 30px 50px;
  border-radius: 8px;
}

.form div {
  margin: 4px 0;
  /* display: flex; */
  /* justify-content: space-between; */
}

.namesDiv {
  display: flex;
  justify-content: space-between;
}

.namesDiv div {
  display: flex;
  flex-direction: column;
}

.emailDiv {
  display: flex;
  flex-direction: column;
}

.checkBoxDiv {
  display: flex;
  justify-content: space-between;
}

input[type="text"] {
  height: 20px;
}

input[type="checkbox"] {
  height: 20px;
  width: 20px;
}

.btn {
  background-color: #d3d2f7;
  border: none;
  color: black;
  padding: 18px 54px;
  font-size: 16px;
  border-radius: 5px;
  margin: 27px 0 0;
}

.btn:hover {
  cursor: pointer;
}
/* .form-title{
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
.form{
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: flex-start;
  align-items: flex-start;
  align-content: stretch;
} */
</style>
