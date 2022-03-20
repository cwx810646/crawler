import axios from 'axios';

//  全局配置
axios.defaults.baseURL = process.env.VUE_APP_API_URL; 
axios.defaults.headers.post['Content-Type'] = 'application/json';

export default (param: any) => {
    return new Promise((resolve, reject) => {
        let instance = axios.create();   
        instance(param).then((response)=>{
            if(response.status === 200){
                resolve(response.data);     
            }else{
                reject(response);
            }
        })
    })
}
