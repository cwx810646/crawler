import axios from "../axios";

export default {
    hello(){
        return axios({
            url: 'hello',
            method: 'get'
        })
    }
}