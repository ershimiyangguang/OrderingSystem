let page=1;
let maxPage;
window.addEventListener("load",()=>{
    getMaxPage();
    list();
})
function getMaxPage() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DishNumberServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    maxPage=Math.ceil(res.number/5);
                    pageNumber();
                }
            }
        }
    }
    xhr.send();
}
function nextPage() {
    if (page<maxPage) {
        page=page+1;
        list();
        pageNumber();
    }
}
function lastPage() {
    if (page>1) {
        page=page-1;
        list();
        pageNumber();
    }
}
function list() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DisplayDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    let ul = document.getElementById("list");
                    let str = "";
                    for (let i=0;i<res.length;i++) {
                        str=str+
                        "<li>"+
                            "<a class=\"dish\" href=\"dish.html?did="+res[i].dId+"\">"+
                                "<img height=\"213px\" src=\""+res[i].dImage+"\">"+
                                "<div class=\"info\">"+
                                    "<h1>"+res[i].dName+"</h1>"+
                                    "<p class=\"illustration\">"+res[i].dDescription+"</p>"+
                                    "<span class=\"priceInfo\">单价:<b class=\"price\">"+res[i].dPrice+"元</b></span>"+
                                "</div>"+
                            "</a>"+
                        "</li>"
                    }
                    ul.innerHTML=str;
                }
            }
        }
    }
    xhr.send("page="+page);
}
function pageNumber() {
    let number = document.getElementById("pageNumber")
    number.innerText="第"+page+"页, 共"+maxPage+"页";
}