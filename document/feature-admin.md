# 管理员端功能

## 1. 管理员登录

### 数据库

创建admin表，字段为a_name, a_password，与users表类似，用于管理员登录。

插入数据"admin", "1234"

sql语句写到MySQL.sql里

### bean层

#### 类名：Admin

类似于User

属性：aName, aPassword

### dao层

#### 接口名：AdminDao

|     |                                     |
| --- | ----------------------------------- |
| 方法  | Admin getAdminByName(String aName); |
| 作用  | 根据aName查询admin                      |
| 返回值 | - 查找到:admin <br/>- 没查到:null         |

### service层

#### 接口名：AdminLoginService

|     |                                                                                   |
| --- |-----------------------------------------------------------------------------------|
| 方法  | Message\<Admin\> login(String aName, String aPassword, String key, String value); |
| 参数  | aName: 管理员名 <br/> aPassword: 用户密码 <br/> key: 验证码编号 <br/> value: 验证码值              |
| 作用  | 判断验证码是否正确、判断账号是否存在、判断密码是否有误 ,登录成功后message的result储存admin                           |
| 返回值 | - 无误:0, null, admin <br/> - 有误:code, reason, null                                 |

### servlet层

#### 类名：AdminLoginServlet

|     |                                                               |
| --- |---------------------------------------------------------------|
| 返回值 | - 登录成功：{code:0}、将Admin存入Session <br/> - 登录失败:{code:, reason:} |

## 2. 是否已登录

### servlet层

#### 类名：IsAdminLoginServlet

|     |                                             |
| --- |---------------------------------------------|
| 返回值 | - 已登录:{code:0, aname:} <br/> - 未登录:{code:1} |

## 3. 查看用户表

### dao层

#### 接口名：UserDao

|     |                                                 |
| --- | ----------------------------------------------- |
| 方法  | List\<User> getUserList(int start, int length); |
| 作用  | 返回从start开始的后length个用户，按照用户名排序                   |
| 返回  | - 存在:List\<User> <br/> - 不存在:null               |

### service层

#### 接口名：GetUserListService

|     |                                    |
| --- | ---------------------------------- |
| 方法  | List\<User> getUserList(int page); |
| 作用  | 返回第page页用户，一页有10个用户信息，page从1开始     |
| 返回值 | - 存在:List\<User> <br/> - 不存在:null  |

### servlet层

#### 类名：GetUserListServlet

|     |                                                                                                          |
| --- |----------------------------------------------------------------------------------------------------------|
| 参数  | page: 第几页的用户表                                                                                            |
| 返回值 | - 存在:\[{uname:,upassword},<br/>{uname:,upassword}\]返回类似这样的数组 <br/> - 不存在:[] |

## 4. 查询用户总数

### dao层

#### 接口名：UserDao

|     |                      |
| --- | -------------------- |
| 方法  | int getUserNumber(); |

### service层

#### 接口名：GetUserNumberService

|     |                      |
| --- | -------------------- |
| 方法  | int getUserNumber(); |

### servlet层

#### 类名：GetUserNumberServlet

|     |             |
| --- | ----------- |
| 返回值 | {number:总数} |

## 5. 修改用户

### dao层

#### 接口名：UserDao

|     |                                |
| --- | ------------------------------ |
| 方法  | boolean updateUser(User user); |
| 作用  | 将用户名为user.uname的用户的信息改为与user相同 |

### service层

#### 接口名：UpdateUserService

|     |                                             |
| --- |---------------------------------------------|
| 方法  | Message updateUser(String uName, String uPassword); |
| 作用  | 将用户名为uname的用户的信息改为与user相同，用户不存在返回code与reason|

### servlet层

#### 类名：UpdateUserServlet

|     |                                              |
| --- |----------------------------------------------|
| 参数  | uname: 用户名 <br/> upassword: 用户密码             |
| 返回值 | - 修改成功: {code:0} <br/> - 修改失败: {code,reason} |

## 6. 删除用户

### dao层

#### 接口名：UserDao

|     |                                   |
| --- | --------------------------------- |
| 方法  | boolean deleteUser(String uName); |

### service层

#### 接口名：DeleteUserService

|    |                                   |
|----|-----------------------------------|
| 方法 | Message deleteUser(String uName); |
| 作用 | 用户不存在返回code与reason                |
| 返回 | code, reason, null                |

### servlet层

#### 类名：DeleteUserServlet

|    |                                               |
|----|-----------------------------------------------|
| 参数 | uname: 用户名                                    |
| 返回 | - 删除成功: {code:0} <br/> - 删除失败: {code:,reason} |

## 7. 添加菜品

### dao层

#### 接口名：DishDao

|     |                             |
| --- |-----------------------------|
| 方法  | boolean addDish(Dish dish); |

|     |                                   |
| --- |-----------------------------------|
| 方法  | Dish getDishByName(String dName); |

### service层

#### 接口名：AddDishService

|    |                                                                       |
|----|-----------------------------------------------------------------------|
| 方法 | Message addDish(String did,String dName, String dPrice, String dDesc); |
| 作用 | 判断输入的参数格式是否正确（将部分字符串转化为数字，检测字符串长度）<br/>图片路径=images/菜品名.jpg<br/>检测编号与菜品名是否已存在 |
| 返回 | code, reason, null     |

### servlet层

#### 类名：AddDishServlet

|     |                                               |
| --- |-----------------------------------------------|
| 参数  | did，dname，dprice，dDesc                        |
| 返回值 | - 添加成功: {code:0} <br/> - 添加失败: {code:,reason} |

## 8. 修改菜品

### dao层

#### 接口名：DishDao

|     |                                |
| --- |--------------------------------|
| 方法  | boolean updateDish(Dish dish); |
| 作用  | 将用户名为dish.did的菜品的信息改为与dish相同   |

### service层

#### 接口名：UpdateDishService

|     |                                                                           |
| --- |---------------------------------------------------------------------------|
| 方法  | Message updateDish(String did,String dName, String dPrice, String dDesc); |
| 作用  | 判断输入的参数格式是否正确，将用户名为dish.did的菜品的信息改为与dish相同，菜品不存在返回code与reason             |

### servlet层

#### 类名：UpdateDishServlet

|     |                                              |
| --- |----------------------------------------------|
| 参数  | did，dname，dprice，ddesc                       |
| 返回值 | - 修改成功: {code:0} <br/> - 修改失败: {code,reason} |

## 9. 根据编号删除菜品

### dao层

#### 接口名：DishDao

|     |                                  |
| --- |----------------------------------|
| 方法  | boolean deleteDishById(int dId); |

### service层

#### 接口名：DeleteDishByIdService

|    |                                     |
|----|-------------------------------------|
| 方法 | Message deleteDishById(String dId); |
| 作用 | 格式是否正确，菜品是否存在，返回code与reason         |
| 返回 | code, reason, null                  |

### servlet层

#### 类名：DeleteDishByIdServlet

|    |                                               |
|----|-----------------------------------------------|
| 参数 | did                                           |
| 返回 | - 删除成功: {code:0} <br/> - 删除失败: {code:,reason} |
## 10. 根据菜品名删除菜品

### dao层

#### 接口名：DishDao

|     |                                         |
| --- |-----------------------------------------|
| 方法  | boolean deleteDishByName(String dName); |

### service层

#### 接口名：DeleteDishByNameService

|    |                                         |
|----|-----------------------------------------|
| 方法 | Message deleteDishByName(String dName); |
| 作用 | 菜品是否存在，返回code与reason                    |
| 返回 | code, reason, null                      |

### servlet层

#### 类名：DeleteDishByNameServlet

|    |                                               |
|----|-----------------------------------------------|
| 参数 | dname                                         |
| 返回 | - 删除成功: {code:0} <br/> - 删除失败: {code:,reason} |

## 11. 上传图片

### servlet层

#### 类名：UploadImageServlet

|    |                                               |
|----|-----------------------------------------------|
| 参数 | 参考B站javaweb课程的upload例子                        |
| 作用 | 上传图片，如果文件的格式不为jpg则不允许上传                       |
| 返回 | - 上传成功: {code:0} <br/> - 上传失败: {code:,reason} |

