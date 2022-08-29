import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue3 from 'bootstrap-vue-3'
import axios from 'axios'

// import axios from '@bundled-es-modules/axios'
import store from './vuex/store'

import './css/Index.css'
import './bootstrap/bootstrap-5.1.3/dist/css/bootstrap.min.css'
import '@coreui/coreui/dist/css/coreui.min.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

const app = createApp(App)
app.use(BootstrapVue3)
app.use(router)
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = '//localhost:8081'
app.config.globalProperties.$store = store
app.mount('#app')
app
    .use(router)
    .use(store)
app.productionTip = false


