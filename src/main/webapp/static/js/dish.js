let index;
let isLogin=false;
window.addEventListener("load",()=>{
    let xhr = new XMLHttpRequest();
    xhr.open("get", "IsLoginServlet", true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    let shop = document.getElementById("shopping");
                    shop.innerHTML="<div class='icon-shopping-cart'>" +
                        "<a class='toOrder' href=\"order.html\">我的订单</a>";
                    isLogin=true;
                }
            }
        }
    }
    xhr.send();
    index=getQueryVariable("did");
    loadInfo();
})
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
function loadInfo() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DisplayOneDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    document.getElementById("dimg").src=res.dImage;
                    document.getElementById("dName").innerText=res.dName;
                    document.getElementById("dD").innerText=res.dDescription;
                    document.getElementById("dPrice").innerText=res.dPrice+"元";
                }
            }
        }
    }
    xhr.send("index="+index);
}
function add(i) {
    let t = document.getElementById("number");
    let num = Number(t.value)+Number(i);
    if (num!=num) {
        num=1;
    }
    if (num>99) {
        num=99;
    }
    if (num<1) {
        num=1;
    }
    t.value = num;
}
function addShoppingCart() {
    if (isLogin) {
        let xhr = new XMLHttpRequest();
        xhr.withCredentials=true;
        xhr.open("post", "AddOrderServlet", true);
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        let count = document.getElementById("number").value;
        xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    window.open("order.html", "_self");
                }
            }
        }
    }
    xhr.send("did="+index+"&count="+count);
    }else{
        window.open("login.html", "_self");
    }
}