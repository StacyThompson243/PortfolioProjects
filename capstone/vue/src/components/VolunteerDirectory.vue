<template>
  <div>
    <h1>Directory</h1>
    <!-- <form action=""> -->

    <table class="application-table">
      <!-- <div class="filters">
        <input type="text" v-model="search" placeholder="search last name" />
        <input type="text" v-model="search" placeholder="search first name" />
      </div> -->
      <thead>
        <tr>
          <th>Application ID</th>
          <th>Last Name</th>
          <th>First Name</th>
          <th>Email</th>
          <th>Over 18?</th>
          <th>Veterinary Skills</th>
          <th>Cleaning Skills</th>
          <th>Data Entry Skills</th>
          <th>Photography Skills</th>
          <th>Role</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>
            <input
              type="text"
              v-model="filters.applicationId"
              id="idFilter"
              placeholder="search by id"
            />
          </td>
          <td>
            <input
              type="text"
              v-model="filters.volunteerLastName"
              id="lastName"
              placeholder="seach last name"
            />
          </td>
          <td>
            <input
              type="text"
              v-model="filters.volunteerFirstName"
              id="fistName"
              placeholder="search first name"
            />
          </td>
          <td>
            <input
              type="text"
              v-model="filters.email"
              id="emailFilter"
              placeholder="search e-mail"
            />
          </td>
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
          <td>
            <select v-model="filters.role" id="photographyFilter">
              <option value>Show All</option>
              <option value="ROLE_USER">Volunteer</option>
              <option value="ROLE_ADMIN">Admin</option>
            </select>
          </td>

          <td></td>
        </tr>
      </tbody>

      <tbody>
        <tr v-for="(volunteer, key) in filterVolunteers" v-bind:key="key">
          <td>{{ volunteer.applicationId }}</td>
          <td>{{ volunteer.volunteerLastName }}</td>
          <td>{{ volunteer.volunteerFirstName }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.over18 ? "Yes" : "No" }}</td>
          <td>{{ volunteer.veterinary ? "Yes" : "No" }}</td>
          <td>{{ volunteer.cleaning ? "Yes" : "No" }}</td>
          <td>{{ volunteer.dataEntry ? "Yes" : "No" }}</td>
          <td>{{ volunteer.photography ? "Yes" : "No" }}</td>
          <!-- <td>{{volunteer.role}}</td> -->
          <td v-if="volunteer.role == 'ROLE_USER'">Volunteer</td>
          <td v-if="volunteer.role == 'ROLE_ADMIN'">Admin</td>

          <!-- <router-link v-bind:to="{name: 'PromoteVolunteer', params: { applicationId: volunteer.applicationId }}"> -->
          <td
            v-if="
              volunteer.role == 'ROLE_USER' &&
              $store.state.user.role === 'ROLE_ADMIN'
            "
          >
            <button v-on:click="updateRole(volunteer)">
              promote to Admin
            </button>
          </td>
          <!-- </router-link> -->
        </tr>
      </tbody>
    </table>
    <!-- </form> -->
  </div>
</template>

<script>
import VolunteerService from "../services/VolunteerService.js";

export default {
  name: "volunteer-directory",
  // props: ['volunteer'],
  data() {
    return {
      volunteers: [],
      filters: {
        applicationId: "",
        volunteerFirstName: "",
        volunteerLastName: "",
        email: "",
        over18: "Show All",
        veterinary: "Show All",
        cleaning: "Show All",
        dataEntry: "Show All",
        photography: "Show All",
        role: "",
      },
    };
  },
  created() {
    VolunteerService.viewDirectory().then((response) => {
      this.volunteers = response.data;
      this.$store.commit("SET_VOLUNTEERS", this.volunteers);
    });
  },
  computed: {
    filterVolunteers() {
      let arr = this.volunteers;
      if (this.filters.applicationId != "") {
        arr = arr.filter((eachVolunteer) => {
          return (
            eachVolunteer.applicationId == parseInt(this.filters.applicationId)
          );
        });
      }
      if (this.filters.volunteerLastName != "") {
        arr = arr.filter((eachVolunteer) => {
          return eachVolunteer.volunteerLastName
            .toLowerCase()
            .includes(this.filters.volunteerLastName.toLowerCase());
        });
      }
      if (this.filters.volunteerFirstName != "") {
        arr = arr.filter((eachVolunteer) => {
          return eachVolunteer.volunteerFirstName
            .toLowerCase()
            .includes(this.filters.volunteerFirstName.toLowerCase());
        });
      }
      if (this.filters.email != "") {
        arr = arr.filter((eachVolunteer) => {
          return eachVolunteer.email
            .toLowerCase()
            .includes(this.filters.email.toLowerCase());
        });
      }
      if (this.filters.over18 != "Show All") {
        arr = arr.filter((eachVolunteer) => {
          let booleanValue = this.filters.over18 == "Yes" ? true : false;

          return eachVolunteer.over18 === booleanValue;
        });
      }

      if (this.filters.veterinary != "Show All") {
        arr = arr.filter((eachVolunteer) => {
          let booleanValue = this.filters.veterinary == "Yes" ? true : false;

          return eachVolunteer.veterinary === booleanValue;
        });
      }
      if (this.filters.cleaning != "Show All") {
        arr = arr.filter((eachVolunteer) => {
          let booleanValue = this.filters.cleaning == "Yes" ? true : false;

          return eachVolunteer.cleaning === booleanValue;
        });
      }
      if (this.filters.dataEntry != "Show All") {
        arr = arr.filter((eachVolunteer) => {
          let booleanValue = this.filters.dataEntry == "Yes" ? true : false;

          return eachVolunteer.dataEntry === booleanValue;
        });
      }
      if (this.filters.photography != "Show All") {
        arr = arr.filter((eachVolunteer) => {
          let booleanValue = this.filters.photography == "Yes" ? true : false;

          return eachVolunteer.photography === booleanValue;
        });
      }
      if (this.filters.role != "") {
        arr = arr.filter((eachVolunteer) => {
          return (
            eachVolunteer.role.toLowerCase() == this.filters.role.toLowerCase()
          );
        });
      }
      return arr;
    },
    methods: {
      reloadPage() {
      window.location.reload();
    },
      updateRole(volunteer) {
        if (confirm("Click OK to confirm role change") == true) {
          VolunteerService.promoteToAdmin(
            volunteer.applicationId,
            volunteer
          ).then((response) => {
            if (response.status === 200) {
              alert("Volunteer Role has been updated");
             
              // this.$router.push("/volunteer/directory");
              //  this.volunteerList = this.volunteerList.filter((eachVolunteer) => {
              //    return eachVolunteer.status === "Pending";
              // });
            }
          });
        }
      },
    },
    
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
  },
};
</script>

<style>
.application-table,
th,
td {
  border: 1px solid black;
  border-collapse: collapse;
}

.filters {
  display: flex;
}
</style>