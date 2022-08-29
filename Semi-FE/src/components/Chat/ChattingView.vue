<template>
  <div class="container-box">
    <div class="container">
      <div class="leftSide"></div>
        <!-- header -->
        <div class="header">
          <div class="userimg">
            <img src="user.png" class="cover" alt="유저 프로필 이미지">
          </div>
          <ul class="nav_icons">
            <li><ion-icon name="scan-circle-outline"></ion-icon></li>
            <li><ion-icon name="chatbox"></ion-icon></li>
            <li><ion-icon name="ellipsis-vertical"></ion-icon></li>
          </ul>
        </div>
      <!-- search -->
      <div class="search_chat">
        <div>
          <input type="text" placeholder="Search or start new chat">
          <ion-icon name="search-outline"></ion-icon>
        </div>
        <!-- chat list -->
        <div class="ChatList">
          <div class="block active">
            <div class="ImgBx">
              <img src="img1.png" class="cover" alt="배경 이미지">
            </div>
            <div class="details">
              <div class="listHead">
                <h4>User Name</h4>
                <p class="time">10:56</p>
              </div>
              <div class="message_p">
                <p>How to make Whatsapp</p>
              </div>
            </div>
          </div>
          <div class="block unread">
            <div class="ImgBx">
              <img src="img2.png" class="cover" alt="배경 이미지">
            </div>
            <div class="details">
              <div class="listHead">
                <h4>User Name</h4>
                <p class="time">10:56</p>
              </div>
              <div class="message_p">
                <p>How to make Whatsapp</p>
                <b>1</b>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="rightSide">
        <div class="header">
          <div class="imgText">
            <img src="user.png" class="cover" alt="유저 프로필 이미지">
          </div>
          <h4>User Name<br /><span>online</span></h4>
          <ul class="nav_icons">
            <li><ion-icon name="search-outline"></ion-icon></li>
            <li><ion-icon name="ellipsis-vertical"></ion-icon></li>
          </ul>
        </div>

        <!-- chatbox -->
        <div class="chatBox">
          <div class="message my_message">
            <p>Hi<br /><span>12:15</span></p>
          </div>
          <div class="message frnd_message">
            <p>wow..! Hello, Man this is a test right?<br /><span>12:15</span></p>
          </div>
          <div class="message my_message">
            <p>Hi<br /><span>12:15</span></p>
          </div>
          <div class="message frnd_message">
            <p>wow..! Hello, Man this is a test right?<br /><span>12:15</span></p>
          </div>
          <div class="message my_message">
            <p>Hi<br /><span>12:15</span></p>
          </div>
          <div class="message frnd_message">
            <p>wow..! Hello, Man this is a test right?<br /><span>12:15</span></p>
          </div>
          <div class="message my_message">
            <p>Hi<br /><span>12:15</span></p>
          </div>
          <div class="message frnd_message">
            <p>wow..! Hello, Man this is a test right?<br /><span>12:15</span></p>
          </div>
        </div>

        <!-- chat input -->
        <div class="chatBox_input">
          <ion-icon name="happy-outline"></ion-icon>
          <ion-icon name="attach-outline"></ion-icon>
          <input type="text" placeholder="Type a message">
          <ion-icon name="mic"></ion-icon>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  name: "ChattingView"
}
</script>

<style scoped>
/*@import url('https://fonts.googleapis.com/css2?family=Akaya+Telivigala&family=Open+Sans:wght@300;400;500;600&display=swap');*/
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  /*font-family: 'Open Sans', sans-serif;*/
  overflow: hidden;
}


.container-box /* body */
{
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(#009688 0%, #009688 130px, #d9dbd5 130px, #d9dbd5 100%);
}

.container
{
  position: relative;
  width: 1396px;
  max-width: 100%;
  height: calc(100vh - 40px);
  background: #fff;
  box-shadow: 0 1px 1px 0 rgba(0,0,0,0.06),0 2px 5px 0 rgba(0,0,0,0.06);
}

.container .leftSide
{
  position: relative;
  flex: 30%;
  background: #fff;
  border-right: 1px solid rgba(0,0,0,0.2);
}

.container .rightSide
{
  position: relative;
  flex: 70%;
  background: #e5ddd5;
  border-right:  1px solid #000;
}

.container .rightSide::before
{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url(user.png);
  opacity: 0.06;
}

.header
{
 position: relative;
  width: 100%;
  height: 60px;
  background: #ededed;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 15px;
}

.userimg
{
  position: relative;
  width: 40px;
  height: 40px;
  overflow: hidden;
  border-radius: 50%;
}

.cover
{
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.nav_icons
{
  display: flex;
}

.nav_icons li
{
  display: flex;
  list-style: none;
  cursor: pointer;
  color: #51585c;
  font-size: 1.5em;
  margin-left: 22px;
}

.search_chat
{
  position: relative;
  width: 100%;
  height: 50px;
  background: #f6f6f6;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 15px;
}

.search_chat div
{
  width: 100%;
}

.search_chat div input
{
  width: 100%;
  outline: none;
  border: none;
  background: #fff;
  padding: 6px;
  height: 38px;
  border-radius: 30px;
  font-size: 14px;
  padding-left: 40px;
}
.search_chat div input::placeholder
{
  color: #bbb;
}

.search_chat div ion-icon
{
  position: absolute;
  left: 30px;
  top: 14px;
  font-size: 1.2em;
}

.ChatList
{
  position: relative;
  height: calc(100% - 110px); /* 60 + 80 = 110 */
  overflow-y: auto;
}

.ChatList .block
{
  position: relative;
  width: 100%;
  display: flex;
  align-items: center;
  padding: 15px;
  border-bottom: 1px solid rgba(0,0,0,0.06);
  cursor: pointer;
}
.ChatList .block active
{
  background: #ebebeb;
}

.ChatList .block:hover
{
  background: #f5f5f5;
}

.ChatList .block .ImgBx
{
  position: relative;
  min-width: 45px;
  height: 45px;
  overflow: hidden;
  border-radius: 50%;
  margin-right: 10px;
}

.ChatList .block .details
{
  position: absolute;
  width: 100%;
}

.ChatList .block .details .listHead
{
  display: flex;
  justify-content: space-between;
  margin-bottom: 5px;
}

.ChatList .block .details .listHead h4
{
  font-size: 1.1em;
  font-weight: 600;
  color: #111;
}

.ChatList .block .details .listHead .time
{
  font-size: 0.75em;
  color: #aaa;
}

.ChatList .block .details .listHead .time
{
  color: #111;
}

.ChatList .block.unread  .details .listHead .time
{
  color: #06d755;
}
.message_p
{
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.message_p p
{
  color: #aaa;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  font-size: 0.9em;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;
}

.message_p b
{
  background: #06d755;
  color: #fff;
  min-width: 20px;
  height: 20px;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.75em;
}

.imgText
{
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.imgText h4
{
  font-weight: 500;
  line-height: 1.2em;
  margin-left: 15px;
}

.imgText h4 span
{
  font-size: 0.8em;
  color: #555;
}
/* chat box */
.chatBox
{
  position: relative;
  width: 100%;
  height: calc(100% - 120px); /* 60 + 60 = 120 */
  padding: 50px;
  overflow-y: auto;
}

.message
{
  position: relative;
  display: flex;
  width: 100%;
  margin: 5px 0;
}

.message p
{
  position: relative;
  right: 0;
  text-align: right;
  max-width: 65%;
  padding: 12px;
  background: #dcf8c6;
  border-radius: 10px;
  font-size: 0.9em;
}

.message p::before
{
  contain: '';
  position: absolute;
  top: 0;
  left: -12px;
  width: 20px;
  height: 20px;
  background: linear-gradient(135deg, #dcf8c6 0%, #dcf8c6 50%, transparent 50%, transparent);
}

.message p span
{
  display: block;
  margin-top: 5px;
  font-size: 0.85em;
  opacity: 0.5;
}

.my_message
{
  justify-content: flex-end;
}

.frnd_message
{
  justify-content: flex-start;
}

.frnd_message p
{
  background: #fff;
  text-align: left;
}

.message .frnd_message p::before
{
  contain: '';
  position: absolute;
  top: 0;
  left: -12px;
  width: 20px;
  height: 20px;
  background: linear-gradient(225deg, #fff 0%, #fff 50%, transparent 50%, transparent);
}

.chatBox_input
{
  position: absolute;
  width: 100%;
  height: 60px;
  background: #f0f0f0;
  padding: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.chatBox_input ion-icon
{
  cursor: pointer;
  font-size: 1.8em;
  color: #51585c;
}
.chatBox_input ion-icon:nth-child(1)
{
  margin-right: 15px;
}
.chatBox_input input
{
  position: relative;
  width: 90%;
  margin: 0 20px;
  padding: 10px 20px;
  border: none;
  outline: none;
  border-radius: 30px;
  font-size: 1em;
}


</style>