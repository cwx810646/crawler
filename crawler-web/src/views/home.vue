<template>
  <div class="home">
    <Header />
    <div> 
        <h1 id="greet" align="center">{{greet}}</h1>
    </div>
  </div>
</template>

<script lang="ts">

import Header from '@/components/header';
import { defineComponent } from 'vue'; 
import constant from '@/assets/script/constant'; 

export default defineComponent({ 
  components: { Header },
  created(){  
    this.hello();
  },
  data(){
    return {
      greet: '',
    }
  },
  methods: {
    hello(){
      let _this = this;
      constant.httpApi.helloApi.hello().then(result=>{ 
        if(result.code === 200){
          _this.greet = result.data;
        }else{

        }
      }) 
    }  
  }
})
</script>
