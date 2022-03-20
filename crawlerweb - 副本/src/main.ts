import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';  
import '@/assets/css/baseStyle.less';
import constant from '@/assets/script/constant'; 

const app = createApp(App);
(async ()=>{
   await init();
   app.use(store)
   .use(router) 
   .mount('#app');
})();


function init(){ 
   // constant.cookieUtil.setCookie("domainName", "cwx810646");
   let domainName = constant.cookieUtil.getCookie("domainName");
   domainName &&  store.commit('setDomainName', domainName);  
   return true;
}
