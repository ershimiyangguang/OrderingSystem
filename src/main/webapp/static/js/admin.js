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
    file = document.getElementById("file");
    file.addEventListener("change",()=>{
        document.getElementById("imgsrc").innerText=file.value;
    })
    item = new Vue({
        el:"#item",
        data:{
            transform:"transform: translate(0,100%);"
        }
    })
    getUser = new Vue({
        el:"#getUser",
        data:{
            currentPage:1,
            maxPage:1
        }
    });
    getDish = new Vue({
        el:"#getDish",
        data:{
            currentPage:1,
            maxPage:1
        }
    });
    addUser = new Vue({
        el:"#addUser",
        data:{
            
        }
    })
    updateUser = new Vue({
        el:"#updateUser",
        data:{
            
        }
    })
    deleteUser = new Vue({
        el:"#deleteUser",
        data:{
            
        }
    })
    addDish = new Vue({
        el:"#addDish",
        data:{
            
        }
    })
    updateDish = new Vue({
        el:"#updateDish",
        data:{
            
        }
    })
    deleteDish = new Vue({
        el:"#deleteDish",
        data:{
            
        }
    })
    uploadImage = new Vue({
        el:"#uploadImage",
        data:{
            
        }
    })
    hideAll();
    getUser.$el.style="display:block;";
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
    getUser.$el.style="display:block;";
    item.transform="transform: translate(0,100%);";
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
    getDish.$el.style="display:block;";
    item.transform="transform: translate(0,600%);";
}
function toAddDishPage() {
    hideAll();
    addDish.$el.style="display:block;";
    item.transform="transform: translate(0,700%);";
}
function toUploadImagePage() {
    hideAll();
    uploadImage.$el.style="display:block;";
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
    file.click();
}
