import { createStore } from 'vuex'

export default createStore({
  state: {
    domainName: '未登录'
  },
  getters: {
  },
  mutations: {
    setDomainName(state, domainName){
      state.domainName = domainName;
    }
  },
  actions: { 
  },
  modules: {
  }
})
