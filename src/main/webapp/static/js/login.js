function toRegister() {
    window.open("register.html");
}
function login() {
    let uid = document.getElementById("uid").value;
    let password = document.getElementById("password")
    let xhr = new XMLHttpRequest();
    xhr.open("post", "LoginServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code===0) {
                    
                }else{
                    let s = document.getElementById("message");
                    s.innerHTML=res.reason;
                }
            }
        }
    }
    xhr.send("uid="+uid+"&upassword="+password);
}