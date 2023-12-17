let key=0;
let max=8;
window.addEventListener("load",()=>{
    change();
})
function change() {
    key = Math.floor(Math.random()*max);//0-(max-1)
    document.getElementById("verify").src="static/code_img/code"+key+".png"
}
function login() {
    let uname = document.getElementById("aname").value;
    let password = document.getElementById("password").value;
    let value = document.getElementById("value").value;
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "AdminLoginServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    window.open("admin.html", "_self");
                }else{
                    change();
                    document.getElementById("aname").style="border:orange 1px solid;"
                    document.getElementById("value").style="border:orange 1px solid;"
                    document.getElementById("password").style="border:orange 1px solid;"
                    if (res.code==1) {
                        document.getElementById("aname").style="border:red 1px solid;"
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
    xhr.send("aname="+uname+"&apassword="+password+"&key="+key+"&value="+value);
}