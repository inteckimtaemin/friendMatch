import { createRouter, createWebHistory } from 'vue-router'

// Admin Page View
import AdMiniStarTorView from "@/components/Admin/AdMiniStarTorView.vue";
import AdMinView from "@/components/Admin/UserList.vue";

// Chatting Page View
import ChattingView from "@/components/Chat/ChattingView.vue";

// Login SUCCESS Page View
import LoginSUCCESView from "@/components/common/UserLoginSuccessView.vue";
import SettingView from "@/components/common/UserSettingsView.vue";
import userPostView from "@/components/Post/userPostView.vue";
import userPostEditView from "@/components/Post/userPostEditView";
import userPostWriteView from "@/components/Post/userPostWriteView";
import userProfileView from "@/components/UsersProfile/ProfileView.vue";

// Extension Page View
import DevProfileView from "@/components/DevProfileView.vue";
import WelcomeView from "@/components/WelcomeView.vue";
import loginView from "@/components/LoginView.vue";
import notFoundView from "@/components/NotFoundView.vue";
import registerView from "@/components/RegisterView.vue";
import registerView2 from "@/components/RegisterView2.vue";

const routes = [
  {
    path: '/',
    name: 'welcome',
    component: WelcomeView,
  },
  {
    path: '/devProfile',
    name: 'DeveloperPage',
    component: DevProfileView,
    meta: {}
  },
  {
    path: '/login',
    name: 'login',
    component: loginView,
    children : [
      {
        path: '/userPost',
        name: 'userPost',
        component: userPostView,
        children: [
          {
            path: '/:{userNickName}/write',
            name: 'userPostWrite',
            component: userPostWriteView,
          },
          {
            path: '/:{userNickName}/edit',
            name: 'userPostEdit',
            component: userPostEditView,
          },
        ]
      },
      {
        path: '/success',
        name: 'loginSUCCESS',
        component: LoginSUCCESView,
      },
      {
        path: '/:{userNickName}/Profile',
        name: 'Profile',
        component: userProfileView,
        children: [
          {
            path: '/:{userNickName}/setting',
            name: 'ProfileSetting',
            component: SettingView,
          },
        ],
      },
      {
        path: '/admin/:{userNickName}',
        name: 'AdminPost',
        component: AdMiniStarTorView,
      },
      {
        path: '/chat/:{userNickName}',
        name: 'ChattingPage',
        component: ChattingView,
        // children: [
        //
        // ]
      }
    ]
  },
  {
    path: '/register',
    name: 'register',
    component: registerView,
  },
  {
    path: '/register2',
    name: 'register2',
    component: registerView2,
  },
  {
    path: '/profile',
    name: 'profileView',
    component: userProfileView,
  },
  {
    path: '/Admin',
    name: 'AdminView',
    component: AdMinView,
  },
  {
    path: '/:catchAll(.*)+',
    name: 'error404',
    component: notFoundView,
  },
]

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router;
