<template>
  <div>
    <h1>
      Promote {{ volunteer.volunteerFirstName }}
      {{ volunteer.volunteerLastName }} to Admin Role?
    </h1>

    <div class="btn">
      <button v-on:click.prevent="updateRole(volunteer)">
        Promote Volunteer
      </button>

      <button v-on:click="cancel">Cancel</button>
    </div>
  </div>
</template>

<script>
import VolunteerService from "../services/VolunteerService";
export default {
  props: ["applicationId"],
  computed: {
    volunteer() {
      return this.$store.getters.volunteer;
    },
  },
  created() {
    const activeVolunteerId = this.$route.params.applicationId;
    this.$store.commit("SET_ACTIVE_VOLUNTEER", activeVolunteerId);
  },
  methods: {
    updateRole(volunteer) {
      if (confirm("Click OK to confirm role change") == true) {
        VolunteerService.promoteToAdmin(
          volunteer.applicationId,
          volunteer
        ).then((response) => {
          if (response.status === 200) {
            alert("Volunteer Role has been updated");
            this.$router.push("/volunteer/directory");
            //  this.volunteerList = this.volunteerList.filter((eachVolunteer) => {
            //    return eachVolunteer.status === "Pending";
            // });
          }
        });
      }
    },
    cancel() {
      this.$router.push("/volunteer/directory");
    },
  },
};
</script>


<style scoped>
.btn {
  display: flex;
  justify-content: center;
  background-color: #f2fafd;
}

button {
  margin-left: 20px;
}
</style>