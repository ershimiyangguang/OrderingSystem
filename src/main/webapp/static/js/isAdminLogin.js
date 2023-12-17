window.addEventListener("load",()=>{
    let xhr = new XMLHttpRequest();
    xhr.open("get", "IsAdminLoginServlet", true);
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==1) {
                    window.open("adminLogin.html","_self");
                }
            }
        }
    }
    xhr.send();
})