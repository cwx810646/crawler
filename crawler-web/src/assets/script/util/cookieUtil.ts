function setCookie(key : string, value : string){
    let cookie = key + '=' + value;
    document.cookie = cookie;
}

function getCookie(name : string){ 
    let cookieStr = document.cookie;
    if(cookieStr){
        let cookieArr = cookieStr.split(';');
        for(let i in cookieArr){
            let pairs = cookieArr[i].split('=');
            let key = pairs[0];
            let value = pairs[1];
            if(key === name){
                return value;
            }
        }
    } 
}

export default{
    setCookie,
    getCookie
}