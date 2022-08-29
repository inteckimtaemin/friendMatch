<template>
	<div class="login">
		<h1>SemiColon</h1>
		<br />
		<form class="LoginForm" @submit.prevent="fnLogin">
			<p>
				<label for="memberIdInput">NICKAME</label>&nbsp;
				<input type="text" id="memberIdInput" class="input_text" ref="memberIdInput" 
					placeholder="닉네임을 입력하세요." v-model="user_id"/>
			</p>
			<p>
				<label for="memberPasswordInput">PW</label>
				<input type="password" id="memberPasswordInput" class="input_text" ref="memberPasswordInput" placeholder="비밀번호를 입력하세요." v-model="user_pw"/>
			</p>
			<div class="login_etc">
				<div class="checkbox">
					<input type="checkbox" name="SaveSession" id="SaveSession"> 정보를 저장할까요?
				</div>
				<br />
				<div class="forgot_account">
					<a @click="fnFindId"> 아이디</a> 혹은 <a @click="fnFindPw"> 비밀번호</a>를 잊으셨나요?
				</div>
			</div>
			<br />
			<div class="SubmitAccount">
				<span>만약 계정이 없다면, <router-link to="/register">회원가입</router-link>을 먼저 진행해주세요!</span>
			</div>
			<p class="buttons">
				<button @click="fnLogin" type="button" class="btn btn-primary" data-bs-toggle="modal">로그인</button>
				<button @click="fnLoginV2" type="button" class="btn btn-primary" data-bs-toggle="modal">로그인 2</button>
				<button @click="doCancel" type="button" class="btn btn-primary" data-bs-toggle="modal">취소</button>
			</p>
		</form>
	</div>
  <button @click="fnFindUsers">Test</button>
</template>

<script>
import axios from 'axios'
import {mapActions, mapGetters} from 'vuex'

export default {
	name: 'LoginForm',
	data : function() {
		return {
			// memberId : '',
			// memberPassword : '',
			// errorMessage : '',
      user_id: '',
      user_pw: '',
      users: [],
			// data : userList,
      // users: {
      //   userInfoId: "",
      //   userEmail: "",
      //   password: "",
      //   userNickName: "",
      //   userInfoCreateDate : [],
      //   userUniqueID: "",
      //   userProfileImageUrl:"",
      //   userDescription: "",
      //   reportList: [],
      //   commentList: [],
      //   friendList: [],
      // },
      // arrayI: [],  // array 배열 2
      // userInfoId: null, //uid
      // userNickName: '', //닉네임
      // password: '', //비밀번호
      // userEmail: '',  //이메일
      // userInfoCreateDate: '', //가입일
      // userUniqueID: null, //권한 (1 : user, 2 : vip, 3 : admin)
      // userDescription: '', // 설명
		};
	},
	methods : {
    fnLoginV2() {
      try {
          axios.get('/api/').then(res => {
            console.log(res.data);
            this.users = res.data;
            if(res.data) {
              console.log(this.users[this.users.length].userNickName);
              // for(let i = 0; i < this.users.length; i++){
                // console.log(this.users[i].userNickName);
                // console.log(this.users[i].password);
                // return (this.users[i].password, this.users[i].userNickName);
              // }
            }else {
              console.log("데이터 가져오기 실패");
            }
          });
        if(this.user_id === '') {
          alert('닉네임을 입력해주세요');
          return
        }
        if(this.user_pw === '') {
          alert('비밀번호를 입력해주세요.');
          return
        }
        if(this.users[this.users.length].userNickName != null) {
          console.log(this.users[this.users.length].userNickName);
        }
      } catch (err) {
          console.warn(err);
      }
    },
    ...mapActions(['login']),
    async fnLogin() {
      if(this.user_id === '') {
        alert('닉네임을 입력해주세요.');
        return
      }
      if(this.user_pw === '') {
        alert('비밀번호를 입력해주세요.');
        return
      }
      // 로그인 API 호출
      try {
        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})
          if (loginResult) {
            // if ()
            alert('로그인 성공')
            console.warn('로그인 결과 : ' + loginResult);
          } else {
            alert('로그인 실패!')
          }
          for(let i = 0; i < this.users.length; i++){
            // alert(vm.users[i]);
            // document.write(vm.users[i] + "<br>");
            // console.log(this.users[i]);
            console.log(this.users[i].userNickName);
            console.log(this.users[i].password);
            // return NICKNAME, EMAIL, PASSWORD;
          }
        } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }
      }
    },
    fnFindUsers() {
      const vm = this;
      axios.get('/api/')
          .then(function(response) {
            console.log(response.data);
            vm.users = response.data;
            // const UN = vm.users.userNickName;
            // const UP = vm.users.password;
            console.log("-------------");
            console.log(vm.users);
            console.log("-------------");
            // const usersLength = vm.users.length;
            // console.log(vm.users.userNickName);
            // console.log(vm.users.password);
            for(var i = 0; i < vm.users.length; i++){
              // alert(vm.users[i]);
              // document.write(vm.users[i] + "<br>");
              console.log(vm.users[i]);
              console.log("-------------");
              console.log(vm.users[i].userEmail);
              console.log(vm.users[i].password);
            }
          })
          .catch(function(error) {
            console.log(error);
          });
    },
		doCancel() {
			document.getElementById("memberIdInput").value = null;
			document.getElementById("memberPasswordInput").value = null;
			document.getElementById("memberIdInput").focus();
		},
		fnFindId() {
			// this.$refs.memberIdInput && this.memberPasswordInput.trim();
			this.$router.push('/findId')
		},
		fnFindPw() {
			// this.$refs.memberIdInput && this.memberPasswordInput.trim();
			this.$router.push('/findPw')
		},
	},
	mounted() {
		document.getElementById("memberIdInput").focus();
    // axios.get('/api/').then((response) => {
      // this.users = response.data
      // this.arrayI = response.data.length
    // })
	},
  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
};
</script>

<style scoped>
/* Google Fonts Import */
@import url("https://fonts.googleapbody {
margin: 0;
}is.com/css2?family=Black+Han+Sans&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");

/* Import End */



div {
	box-sizing: border-box;
}

.black-bg {
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	padding: 20px;
}

.white-bg {
	width: 100%;
	background: white;
	border-radius: 8px;
	padding: 20px;
}

div .login { background-color: white; }

.login { 
	width: 800px; 
	margin: 20px auto;
}
.login h1 { 
	text-align: center; 
	font-family: 'Black Han Sans', sans-serif; 
}
.LoginForm { 
	margin: auto; 
	text-align: left;
}
.LoginForm p > label { 
	display: inline-block; 
	font-size: 24px; 
	padding-right: 16px;
	align-items: center; 
	font-family: 'Black Han Sans', sans-serif; 
}
.LoginForm p > .input_text { 
	width: 100%;
	height: 50px;
	text-align: center;
	font-family: 'Jua', sans-serif;
	border-radius: 30px;
	margin-top: 10px;
	outline: none;
	font-size: 22px;
	align-items: center;
}

.LoginForm p > .input_text:focus { 
	font-size: 180%;
}

.buttons { 
	position:relative; 
	height:32px; 
	margin-top:20px; 
	text-align: center;
}
/* .buttons > .button { overflow:visible; cursor:pointer; min-width:125px; height:32px; margin:0 2px; padding:0 15px; line-height:32px; font-size:14px; border:1px solid #dfdfdf; background:#fff; border-radius:10px;  margin-top: 20px; width: 80%; font-weight: bold; } */
.buttons > .button { 
	overflow: visible; 
	cursor: pointer; 
	min-width:125px; 
	height: 40px;
	margin:0 2px; 
	padding:0 15px; 
	line-height: 32px; 
	font-size: 1.2em;
	border: 0;
	/* border:1px solid #dfdfdf;  */
	background: #D3D3D3; 
	border-radius: 40px;  
	margin-top: 20px;
	margin-left: 10px;
	width: 80%; 
	font-weight: bold; 
	outline: none;
}

.buttons > .button.blue { 
	color:#fff; 
	border-color:#0099d2 !important; 
	background:#0099d2 !important; 
	margin-top: 20px; 
	align-items: center;
	width: 80%; 
	font-weight: bold;
	border-radius: 40px;
}

.login_etc {
  padding: 12px;
  width: 100%;
  font-size: 16px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-weight: bold;
  text-align: center;
  margin-left: 10px;
}

.login_etc > .forgot_account > a {
	text-decoration: underline;
}

div .SubmitAccount {
	padding: 12px;
	width: 100%;
	font-size: 16px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-weight: bold;
	text-align: center;
	margin-left: 10px;
}
</style>
