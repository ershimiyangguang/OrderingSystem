let key=0;
function login() {
    let uname = document.getElementById("uname").value;
    let password = document.getElementById("password").value;
    let value = document.getElementById("value").value;
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "LoginServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    window.open("main.html", "_self");
                }else{
                    document.getElementById("uname").style="border:orange 1px solid;"
                    document.getElementById("value").style="border:orange 1px solid;"
                    document.getElementById("password").style="border:orange 1px solid;"
                    if (res.code==1) {
                        document.getElementById("uname").style="border:red 1px solid;"
                    }else if (res.code==2) {
                        document.getElementById("password").style="border:red 1px solid;"
                    }else{
                        document.getElementById("value").style="border:red 1px solid;"
                    }
                    let s = document.getElementById("message");
                    s.style="padding: 5px;border: red 1px solid;"
                    s.innerHTML=res.reason;
                }
            }
        }
    }
    xhr.send("uname="+uname+"&password="+password+"&key="+key+"&value="+value);
}