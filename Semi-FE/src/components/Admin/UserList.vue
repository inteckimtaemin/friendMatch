<template>
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="main-box clearfix">
          <div class="table-responsive">
            <table class="table user-list">
              <thead>
              <tr>
                <th><span>유저</span></th>
                <th><span>계정 생성일</span></th>
                <th class="text-center"><span>상태</span></th>
                <th><span>이메일</span></th>
                <th><span>관리</span></th>
                <th>&nbsp;</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="(row) in users" :key="row">
                <td>
                  <img src="" alt="None">
                  <a href="#" class="user-link">{{ row.userNickName }}</a>
                </td>
                <td>
                  {{ row.userInfoCreateDate[0] }}년 {{ row.userInfoCreateDate[1] }}월 {{ row.userInfoCreateDate[2] }}일
                </td>
                <td class="text-center">
                  <span class="label label-default">Online</span>
                </td>
                <td class="email-center">
                  <a href="#">{{ row.userEmail }}</a>
                </td>
                <td style="width: 20%;">
                  <a href="#" class="table-link">
									<span class="fa-stack">
                    <i class='bx bx-search-alt'></i>
									</span>
                  </a>
                  <a href="#" class="table-link">
									<span class="fa-stack">
                    <i class='bx bxs-pencil'></i>
									</span>
                  </a>
                  <a href="#" class="table-link danger">
									<span class="fa-stack">
                    <i class='bx bxs-trash'></i>
									</span>
                  </a>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
<!--          <ul class="pagination pull-right">-->
<!--            <li><a href="#"><i class="fa fa-chevron-left"></i></a></li>-->
<!--            <li><a href="#">1</a></li>-->
<!--            <li><a href="#">2</a></li>-->
<!--            <li><a href="#">3</a></li>-->
<!--            <li><a href="#">4</a></li>-->
<!--            <li><a href="#">5</a></li>-->
<!--            <li><a href="#"><i class="fa fa-chevron-right"></i></a></li>-->
<!--          </ul>-->
        </div>
      </div>
    </div>
  </div>
  <br /><br /><br />
  <tr>현재 접속중 :  {{ arrayI }} 명과 함께하고 있습니다.</tr>
</template>


<script>
import axios from 'axios'

export default {
  name: 'ProfileView',
  data() {
    return {
      users: [],  // 배열
      arrayI: [],  // array 배열 2
      userInfoId: null, //uid
      userNickName: '', //닉네임
      password: '', //비밀번호
      userEmail: '',  //이메일
      userInfoCreateDate: '', //가입일
      userUniqueID: null, //권한 (1 : user, 2 : vip, 3 : admin)
      userDescription: '', // 설명
    };
  },
  methods: {
  },
  mounted () {
    axios.get('/api/').then((response) => {
      this.users = response.data
      this.arrayI = response.data.length
    })
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Mukta:wght@200;300;400;500;600;700;800&display=swap');

th {
  font-family: 'Jua', sans-serif;
  font-size: 18px;
  /*text-align: left;*/
}

td {
  font-family: 'Mukta', sans-serif;
  font-size: 16px;
  /*text-align: left;*/
}

.th-box > th {
  text-align: center;
  padding: 15px;
}

.tr-box > td {
  text-align: center;
  padding: 5px;
}

.blow {
  margin-left: 60px;
  /*font-family: 'Jua', sans-serif;*/
}

/* template */

body{margin-top:20px;}

/* USER LIST TABLE */
.user-list tbody td > img {
  position: relative;
  max-width: 50px;
  float: left;
  margin-right: 15px;
}
.user-list tbody td .user-link {
  display: block;
  font-size: 1.25em;
  padding-top: 3px;
  margin-left: 60px;
}
.user-list tbody td .user-subhead {
  font-size: 0.875em;
  font-style: italic;
}

/* TABLES */
.table {
  border-collapse: separate;
}
.table-hover > tbody > tr:hover > td,
.table-hover > tbody > tr:hover > th {
  background-color: #eee;
}
.table thead > tr > th {
  border-bottom: 1px solid #C2C2C2;
  padding-bottom: 0;
}
.table tbody > tr > td {
  font-size: 1em;
  background: #f5f5f5;
  border-top: 10px solid #fff;
  vertical-align: middle;
  padding: 12px 8px;
}
.table tbody > tr > td:first-child,
.table thead > tr > th:first-child {
  padding-left: 20px;
}
.table thead > tr > th span {
  border-bottom: 2px solid #C2C2C2;
  display: inline-block;
  padding: 0 5px;
  padding-bottom: 5px;
  font-weight: normal;
  font-size: 1.125em;
}
.table thead > tr > th > a span {
  color: #344644;
}
.table thead > tr > th > a span:after {
  content: "\f0dc";
  font-family: FontAwesome;
  font-style: normal;
  font-weight: normal;
  text-decoration: inherit;
  margin-left: 5px;
  font-size: 0.75em;
}
.table thead > tr > th > a.asc span:after {
  content: "\f0dd";
}
.table thead > tr > th > a.desc span:after {
  content: "\f0de";
}
.table thead > tr > th > a:hover span {
  text-decoration: none;
  color: #2bb6a3;
  border-color: #2bb6a3;
}

.table.table a {
  font-size: 1.125em;
}
.table.table-hover tbody > tr > td {
  -webkit-transition: background-color 0.15s ease-in-out 0s;
  transition: background-color 0.15s ease-in-out 0s;
  font-size: 1.125em;
}
.table tbody tr td .call-type {
  display: block;
  font-size: 0.75em;
  text-align: center;
}
.table tbody tr td .first-line {
  line-height: 1.5;
  font-weight: 400;
  font-size: 1.125em;
}
.table tbody tr td .first-line span {
  font-size: 0.875em;
  color: #969696;
  font-weight: 300;
}
.table tbody tr td .second-line {
  font-size: 0.875em;
  line-height: 1.2;
}
.table a.table-link {
  margin: 0 5px;
  /*font-size: 1.125em;*/
  font-size: 1.5em;
}

.table a.table-link:hover {
  text-decoration: none;
  color: #2aa493;
}
.table a.table-link.danger {
  color: #fe635f;
}
.table a.table-link.danger:hover {
  color: #dd504c;
}

.table-products tbody > tr > td {
  background: none;
  border: none;
  border-bottom: 1px solid #ebebeb;
  -webkit-transition: background-color 0.15s ease-in-out 0s;
  transition: background-color 0.15s ease-in-out 0s;
  position: relative;
}
.table-products tbody > tr:hover > td {
  text-decoration: none;
  background-color: #f6f6f6;
}
.table-products .name {
  display: block;
  font-weight: 600;
  padding-bottom: 7px;
}
.table-products .price {
  display: block;
  text-decoration: none;
  width: 50%;
  float: left;
  font-size: 0.875em;
}
.table-products .price > i {
  color: #8dc859;
}
.table-products .warranty {
  display: block;
  text-decoration: none;
  width: 50%;
  float: left;
  font-size: 0.875em;
}
.table-products .warranty > i {
  color: #f1c40f;
}
.table tbody > tr.table-line-fb > td {
  background-color: #9daccb;
  color: #262525;
}
.table tbody > tr.table-line-twitter > td {
  background-color: #9fccff;
  color: #262525;
}
.table tbody > tr.table-line-plus > td {
  background-color: #eea59c;
  color: #262525;
}
.table-stats .status-social-icon {
  font-size: 1.9em;
  vertical-align: bottom;
}
.table-stats .table-line-fb .status-social-icon {
  color: #556484;
}
.table-stats .table-line-twitter .status-social-icon {
  color: #5885b8;
}
.table-stats .table-line-plus .status-social-icon {
  color: #a75d54;
}

</style>