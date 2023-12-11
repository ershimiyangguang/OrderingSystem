let index;
window.addEventListener("load",()=>{
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
        num=0;
    }
    if (num>99) {
        num=99;
    }
    if (num<0) {
        num=0;
    }
    t.value = num;
}