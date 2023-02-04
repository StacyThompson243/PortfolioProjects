<template>
  <div class="page">
    <h1>New Volunteer Form</h1>
    <div class="bottomLine"></div>
    <!-- <a><iframe src="https://docs.google.com/forms/d/e/1FAIpQLSc5rUXlj9__lDBWQhbUfWbKfDY7n_c7gDRajhMNgXD4wGQ2pQ/viewform?embedded=true" width="640" height="1050" frameborder="0" marginheight="0" marginwidth="0">Loading…</iframe></a> -->
    <form class="form" v-on:submit.prevent="saveVolunteer()">
      <div class="topContainer">
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
      </div>
      <div class="bottomContainer">
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

h1 {
  margin-top: 85px;
  padding: 20px 0 15px 0;
}

* {
  color: black;
}
/* .bottomLine {
  border-bottom: 2px solid #82F2C1;
  width: 200px;
  margin: auto;
  margin-bottom: 15px;
} */

.page {
  background-image: url("https://static.onecms.io/wp-content/uploads/sites/34/2018/07/12170256/cat-playing-getty-845697720.jpg");
  height: 100vh;
  width: 100vw;
  background-size: cover;
  position: fixed;
  top: 0px;
  z-index: -1;
}

.form {
  margin: auto;
  background-color: #c5c4f4;
  background: rgba(204, 204, 204, 0);
  background: rgba(204, 204, 204, 0.4);
  box-shadow: 8px 8px 16px rgba(255, 255, 255, 0.2);
  width: 500px;
  padding: 30px 50px;
  border-radius: 8px;
  font-weight: 300;
}

.topContainer div, .bottomContainer div {
  margin-top: 4px;
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

.emailDiv label {
  margin-top: 4px;
}

.checkBoxDiv {
  display: flex;
  justify-content: space-between;  
  padding: 4px 0;
}

.bottomContainer div:nth-child(even) {
  background-color: rgba(255, 255, 255, 0.5);
}

.bottomContainer div:nth-child(odd) {
  background-color: rgba(255, 255, 255, 0.2);
}

.checkBoxDiv label {
  width: 95%;
}

input[type="text"], input[type="email"] {
  padding: 10px 6px;
  height: 20px;
}

input[type="checkbox"] {
  height: 20px;
  width: 20px;
}

input[type="checkbox"]:checked {
  /* background-color: brown; */
}

.btn {
  background-color: rgba(255, 255, 255);
  border: none;
  color: black;
  padding: 18px 54px;
  font-size: 16px;
  border-radius: 5px;
  margin: 27px 0 0;
}

.btn:hover {
  background-color: #A1F5D0;
  transition: 0.5s;
}

.btn:hover {
  cursor: pointer;
}
</style>
