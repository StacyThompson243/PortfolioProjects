<template>
  <div>
      <h1>Directory</h1>
            <form action="">
      <table class="application-table">
          <thead>
          <tr>
              <th>Role</th>
              <th>Full Name</th>
              <th>Email</th>
              <th>Over 18?</th>
              <th>Veterinary Skills</th>
              <th>Cleaning Skills</th>
              <th>Data Entry Skills</th>
              <th>Photography Skills</th>
              
          </tr>
          </thead>
          <tbody>
              <tr v-for="(volunteer, key) in volunteerList" v-bind:key="key">
                <td>{{volunteer.role}}</td>
                  <td>{{volunteer.volunteerFirstName}} {{volunteer.volunteerLastName}}</td>
                  <td>{{volunteer.email}}</td>
                  <td>{{volunteer.over18}}</td>
                  <td>{{volunteer.veterinary}}</td>
                  <td>{{volunteer.cleaning}}</td>
                  <td>{{volunteer.dataEntry}}</td>
                  <td>{{volunteer.photography}}</td>
                  
              </tr>
          </tbody>
      </table>
      </form>
  </div>
</template>

<script>

export default {
name: "volunteerDirectory",
data(){
    return {
        volunteerList: [],
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