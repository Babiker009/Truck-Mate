<script>
import axios from 'axios'

export default {
  data() {
    return {
      fname: "",
      lname: "",
      email: "",
      password: "",
      searchEmail: "",
      users: []
    }
  },

  mounted() {
    axios.get('http://localhost:8080/users')
      .then(res => {
        this.users = res.data
      })
  },

  methods: {
    createUser() {
      axios.post('http://localhost:8080/user', {
        fname: this.fname,
        lname: this.lname,
        email: this.email,
        pw: this.password
      }).then(res => {
        this.users.push(res.data)
      })

      this.fname = ""
      this.lname = ""
      this.email = ""
      this.password = ""
    },

    showUser(email) {
      return this.users.find(u => u.email === email)
    }
  }
}
</script>

<template>
  <h1>Users</h1>

  <input v-model="fname" placeholder="First name" />
  <input v-model="lname" placeholder="Last name" />
  <input v-model="email" placeholder="Email" />
  <input v-model="password" type="password" placeholder="Password" />

  <button @click="createUser">Create</button>

  <hr />

  <div v-for="user in users" :key="user.email">
    {{ user.fname }} {{ user.lname }} - {{ user.email }}
  </div>

  <hr />

  <input v-model="searchEmail" placeholder="Search email" />

  <div v-if="showUser(searchEmail)">
    Found: {{ showUser(searchEmail).fname }} {{ showUser(searchEmail).lname }}
  </div>
</template>