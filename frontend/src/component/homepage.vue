<script>
export default {
  name: 'home-page',

  data() {
    return {
      email:"",
      password:"",

    }
  },

  methods:{
    credential(){
        alert(`Email: ${this.email} / Password: ${this.password}`);

    }

  }
}
</script>

<template>
  <h1>You did it!</h1>
  <label style="padding: 50px"> Enter email</label> <input v-model="email" type="text" placeholder="Enter email" />
  <br />
  <label style="padding: 50px"> Enter email</label>
  <input v-model="password" type="password" placeholder="Enter password" /> <br />
  <button style="margin-left: 200px" @click="credential">
    Login
  </button>
</template>

<style scoped></style>
