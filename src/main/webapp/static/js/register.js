let key=0;
let max=8;
window.addEventListener("load",()=>{
    change();
})
function change() {
    key = Math.floor(Math.random()*max);//0-(max-1)
    document.getElementById("verify").src="static/code_img/code"+key+".png"
}
function register() {
    let uname = document.getElementById("uname").value;
    let password1 = document.getElementById("password1").value;
    let password2 = document.getElementById("password2").value;
    let value = document.getElementById("value").value;
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "RegisterServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    window.open("login.html", "_self");
                }else{
                    change();
                    document.getElementById("uname").style="border:orange 1px solid;"
                    document.getElementById("value").style="border:orange 1px solid;"
                    document.getElementById("password1").style="border:orange 1px solid;"
                    document.getElementById("password2").style="border:orange 1px solid;"
                    if (res.code==1) {
                        document.getElementById("uname").style="border:red 1px solid;"
                    }else if (res.code==2) {
                        document.getElementById("password1").style="border:red 1px solid;"
                    }else if (res.code==3) {
                        document.getElementById("password2").style="border:red 1px solid;"
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
    xhr.send("uname="+uname+"&upassword1="+password1+"&upassword2="+password2+"&key="+key+"&value="+value);
}