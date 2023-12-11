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
                        "<a class='order' href=\"order.html\">我的订单</a>";
                }
            }
        }
    }
    xhr.send();
})