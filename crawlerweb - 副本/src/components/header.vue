<template>
    <div class="header">
        <div>
            welcome to crawler !
        </div>
        <div>
            {{domainName}}
        </div>
    </div>
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
   computed: {
       domainName(){ 
           return this.$store.state.domainName
       }
   }, 
   created(){}
})
</script>
<style lang="less" scoped>
.header{
    height: 50px;
    line-height: 50px;
    background-color: #333;
    color: #FFF;
    padding: 0 20px;

    display: flex;
    justify-content: space-between;
}
</style>
