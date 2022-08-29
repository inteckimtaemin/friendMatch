<template>
  <h1>S</h1>
</template>

<script>
// import axios from 'axios'

export default {
  name: "SIGNUP",
  data : function() {
    return {
      email: '',
    }
  },
  methods: {
    // 이메일  Validation
    checkEmail(value) {
      const regex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      if (regex.test(value) === true) {
        return true;
      }else {
        return false;
      }
    },
    // 비밀번호  Validation
    checkPasswd(value) {
      const regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
      if (regex.test(value) === true) return true;
      return false;
    },

  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>