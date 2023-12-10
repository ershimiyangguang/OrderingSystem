let key=0;
function login() {
    let uname = document.getElementById("uname").value;
    let password = document.getElementById("password").value;
    let value = document.getElementById("value").value;
    let xhr = new XMLHttpRequest();
    xhr.open("post", "LoginServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    window.open("main.html", "_self");
                }else{
                    let s = document.getElementById("message");
                    s.innerHTML=res.reason;
                }
            }
        }
    }
    xhr.send("uname="+uname+"&password="+password+"&key="+key+"&value="+value);
}