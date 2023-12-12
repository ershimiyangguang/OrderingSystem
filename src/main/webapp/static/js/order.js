let sumPrice=0;
let sumOrderPrice=0;
window.addEventListener("load",()=>{
    isLogin()
})
function isLogin() {
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
                    loadShoppingCart();
                }else{
                    window.open("login.html", "_self");
                }
            }
        }
    }
    xhr.send();
}
function loadShoppingCart() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "GetShoppingCartServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    sumPrice = 0;
                    let buttom = document.getElementById("pay")
                    buttom.innerHTML=
                        "<div class=\"sumPrice\">"+
                            "合计："+
                            "<b id=\"sum\">0元</b>"+
                        "</div>"+
                        "<div class=\"orderbtn\">"+
                            "<div class=\"clearbtn\" onclick=\"clearCart()\">"+
                                "清空购物车"+
                            "</div>"+
                            "<div class=\"paybtn\" onclick=\"pay()\">"+
                                "支付"+
                            "</div>"+
                        "</div>";
                    let orderList = document.getElementById("orderlist");
                    let sum = document.getElementById("sum");
                    let str = "";
                    for (let i=0;i<res.length;i++) {
                        str=str+"<li class=\"orderInfo\">"+
                                "<img src=\""+res[i].dImage+"\">"+
                                "<div class=\"textInfo\">"+
                                    "<h2>"+res[i].dName+"</h2>"+
                                    "<p>"+res[i].dPrice+"元</p>"+
                                    "<span>X"+res[i].count+"</span>"+
                                "</div>"+
                            "</li>";
                        sumPrice=sumPrice+Number(res[i].count)*Number(res[i].dPrice);
                    }
                    orderList.innerHTML=str;
                    sum.innerText=sumPrice+"元"
                }
            }
        }
    }
    xhr.send();
}
function loadOrder() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "GetOrderServlet", false);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    sumOrderPrice = 0;
                    buttom = document.getElementById("pay")
                    buttom.innerHTML=
                        "<div class=\"sumPrice\">"+
                            "合计："+
                            "<b id=\"sum\">0元</b>"+
                        "</div>";
                    let orderList = document.getElementById("orderlist");
                    let str = "";
                    for (let i=0;i<res.length;i++) {
                        str=str+"<li class=\"orderInfo\">"+
                                "<img src=\""+res[i].dImage+"\">"+
                                "<div class=\"textInfo\">"+
                                    "<h2>"+res[i].dName+"</h2>"+
                                    "<p>"+res[i].dPrice+"元</p>"+
                                    "<span>X"+res[i].count+"</span>"+
                                "</div>"+
                            "</li>";
                            sumOrderPrice=sumOrderPrice+Number(res[i].count)*Number(res[i].dPrice);
                    }
                    orderList.innerHTML=str;
                    sum.innerText=sumOrderPrice+"元"
                }
            }
        }
    }
    xhr.send();
}
function pay() {
    if (sumPrice>0) {
        let temp_form = document.createElement("form");
        temp_form.action="AlipayServlet";
        temp_form.target="_self";
        temp_form.method="post";
        temp_form.style.display="none";
        let opt = document.createElement("input");
        opt.name="price";
        opt.value=sumPrice;
        temp_form.appendChild(opt);
        let submit = document.getElementById("submit");
        submit.appendChild(temp_form);
        temp_form.submit();
        submit.innerHTML="";
    }
}
function clearCart() {
}