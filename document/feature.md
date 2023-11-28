# 功能
## 1. 登录(login)
### dao层
-[ ] UserDao
  - Message\<User\> getUserById(String uid);
    - uid: user的id
    - 根据id查询user
    - 查找到:0, null, user
    - 没查到:code, reason, null
### service层
-[ ] LoginService
  - Message login(String uid, String password);
    - uid: 用户账号, password: 用户密码
    - 判断输入的登录信息是否有误
    - 无误:0, null, null
    - 有误:code, reason, null
### servlet层
-[ ] LoginServlet
  - uid: 账号, password: 密码
  - 登录成功:跳转到main页面
  - 登录失败:{code, reason}
### view层
-[ ] login.html: 登录界面
-[ ] main.html: 选菜界面