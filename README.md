# 点菜系统
## 功能
### 1. 登录(login)
#### dao层
- UserDao
   - Message\<User\> getUserById(String uid);
     - 根据id查询user
     - uid: user的id
#### service层
- LoginService
  - Message login(String uid, String password);
    - 判断输入的登录信息是否有误
    - uid: 用户账号, password: 用户密码
#### servlet层
- LoginServlet
  - 登录
  - uid: 账号, password: 密码
  - 登录成功跳转到main页面，登录失败返回message的code与reason
#### view层
- login.html: 输入账号、密码
- main.html: 选菜界面


