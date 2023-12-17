let item;
let getUser;
let getDish;
let addUser;
let updateUser;
let deleteUser;
let addDish;
let updateDish;
let deleteDish;
let uploadImage;
let file;
window.addEventListener("load",()=>{
    item = new Vue({
        el:"#item",
        data:{
            transform:"transform: translate(0,100%);"
        }
    })
    getUser = new Vue({
        el:"#getUser",
        data:{
            uname:"",
            currentPage:1,
            maxPage:0,
            userList:[]
        }
    });
    getDish = new Vue({
        el:"#getDish",
        data:{
            did:"",
            currentPage:1,
            maxPage:0,
            dishList:[]
        }
    });
    addUser = new Vue({
        el:"#addUser",
        data:{
            uname:"",
            password:""
        }
    })
    updateUser = new Vue({
        el:"#updateUser",
        data:{
            uname:"",
            password:""
        }
    })
    deleteUser = new Vue({
        el:"#deleteUser",
        data:{
            uname:""
        }
    })
    addDish = new Vue({
        el:"#addDish",
        data:{
            did:"",
            dname:"",
            dprice:"",
            ddesc:""
        }
    })
    updateDish = new Vue({
        el:"#updateDish",
        data:{
            did:"",
            dname:"",
            dprice:"",
            ddesc:""
        }
    })
    deleteDish = new Vue({
        el:"#deleteDish",
        data:{
            did:"",
            dname:""
        }
    })
    uploadImage = new Vue({
        el:"#uploadImage",
        data:{
            
        }
    })
    toGetUserPage();
});
function hideAll() {
    getUser.$el.style="display:none;";
    getDish.$el.style="display:none;";
    addUser.$el.style="display:none;";
    updateUser.$el.style="display:none;";
    deleteUser.$el.style="display:none;";
    addDish.$el.style="display:none;";
    updateDish.$el.style="display:none;";
    deleteDish.$el.style="display:none;";
    uploadImage.$el.style="display:none;";
}
function toGetUserPage() {
    hideAll();
    getUser.currentPage=1;
    getMaxUserPage();
    userList();
    getUser.$el.style="display:block;";
    item.transform="transform: translate(0,100%);";
}
function userList() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "GetUserListServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    getUser.userList=res;
                }
            }
        }
    }
    xhr.send("page="+getUser.currentPage);
}
function getMaxUserPage() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "GetUserNumberServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    getUser.maxPage=Math.ceil(res.number/10);
                }
            }
        }
    }
    xhr.send();
}
function nextUserPage() {
    if (getUser.maxPage - getUser.currentPage > 0 ) {
        getUser.currentPage = getUser.currentPage+1;
        userList();
    }
}
function lastUserPage() {
    if (getUser.currentPage > 1 ) {
        getUser.currentPage = getUser.currentPage-1;
        userList();
    }
}
function toAddUserPage() {
    hideAll();
    addUser.$el.style="display:block;";
    item.transform="transform: translate(0,200%);";
}
function toUpdateUserPage() {
    hideAll();
    updateUser.$el.style="display:block;";
    item.transform="transform: translate(0,300%);";
}
function toDeleteUserPage() {
    hideAll();
    deleteUser.$el.style="display:block;";
    item.transform="transform: translate(0,400%);";
}
function toGetDishPage() {
    hideAll();
    getDish.currentPage=1;
    dishList();
    getMaxDishPage();
    getDish.$el.style="display:block;";
    item.transform="transform: translate(0,600%);";
}
function dishList() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DisplayDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    getDish.dishList=res;
                }
            }
        }
    }
    xhr.send("page="+getDish.currentPage);
}
function getMaxDishPage() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DishNumberServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res!=null) {
                    getDish.maxPage=Math.ceil(res.number/5);
                }
            }
        }
    }
    xhr.send();
}
function nextDishPage() {
    if (getDish.maxPage - getDish.currentPage > 0 ) {
        getDish.currentPage = getDish.currentPage+1;
        dishList();
    }
}
function lastDishPage() {
    if (getDish.currentPage > 1 ) {
        getDish.currentPage = getDish.currentPage-1;
        dishList();
    }
}
function toAddDishPage() {
    hideAll();
    addDish.$el.style="display:block;";
    item.transform="transform: translate(0,700%);";
}
function toUploadImagePage() {
    hideAll();
    uploadImage.$el.style="display:block;";
    document.getElementById("imgsrc").innerText="选择文件";
    item.transform="transform: translate(0,800%);";
}
function toUpdateDishPage() {
    hideAll();
    updateDish.$el.style="display:block;";
    item.transform="transform: translate(0,900%);";
}
function toDeleteDishPage() {
    hideAll();
    deleteDish.$el.style="display:block;";
    item.transform="transform: translate(0,1000%);";
}

function upload() {
    let file = document.getElementById("file");
    file.addEventListener("change",()=>{
        document.getElementById("imgsrc").innerText=file.value;
    })
    file.click();
}
function addUserBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "RegisterServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("添加用户成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("uname="+addUser.uname+"&upassword1="+addUser.password+"&upassword2="+addUser.password+"&key=0&value=0313");
}
function updateUserBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "UpdateUserServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("编辑用户成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("uname="+updateUser.uname+"&upassword="+updateUser.password);
}
function deleteUserBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DeleteUserServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("删除用户成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("uname="+deleteUser.uname);
}
function addDishBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "AddDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("添加菜品成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("did="+addDish.did+"&dname="+addDish.dname+"&dprice="+addDish.dprice+"&dDesc="+addDish.ddesc);
}
function updateDishBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "UpdateDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("编辑菜品成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("did="+updateDish.did+"&dname="+updateDish.dname+"&dprice="+updateDish.dprice+"&dDesc="+updateDish.ddesc);
}
function deleteDishByNameBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DeleteDishByNameServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("删除菜品成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("dname="+deleteDish.dname);
}
function deleteDishByIdBtn() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DeleteDishByIdServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse(xhr.responseText);
                if (res.code==0) {
                    alert("删除菜品成功！")
                }else{
                    alert(res.reason);
                }
            }
        }
    }
    xhr.send("did="+deleteDish.did);
}
function searchDish() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "DisplayOneDishServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse("["+xhr.responseText+"]");
                if (res!=null)  {
                    getDish.currentPage=1;
                    getDish.maxPage=1;
                    if (res[0].dName) {
                        getDish.dishList=res;
                    }else{
                        alert("菜品不存在");
                        getDish.dishList=JSON.parse("[]");
                    }
                }
            }
        }
    }
    xhr.send("index="+getDish.did);
}
function searchUser() {
    let xhr = new XMLHttpRequest();
    xhr.withCredentials=true;
    xhr.open("post", "GetUserByNameServlet", true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4) {
            if (xhr.status == 200) {
                let res = JSON.parse("["+xhr.responseText+"]");
                if (res!=null)  {
                    getUser.maxPage=1;
                    getUser.currentPage=1;
                    if (res[0].upassword) {
                        getUser.userList=res;
                    }else{
                        alert("用户不存在");
                        getUser.userList=JSON.parse("[]");
                    }
                }
            }
        }
    }
    xhr.send("uname="+getUser.uname);
}
function toUpdateDish(index) {
    updateDish.did=getDish.dishList[index].dId;
    updateDish.dname=getDish.dishList[index].dName;
    updateDish.dprice=getDish.dishList[index].dPrice;
    updateDish.ddesc=getDish.dishList[index].dDescription;
    toUpdateDishPage();
}
function toUpdateUser(index) {
    updateUser.uname=getUser.userList[index].uname;
    updateUser.password=getUser.userList[index].upassword;
    toUpdateUserPage();
}
