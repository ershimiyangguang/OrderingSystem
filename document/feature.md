# 功能
## 1. 登录
### dao层
-[ ] UserDao
  - User getUserById(String uname);
    - uname: 用户名
    - 根据用户名字查询user
    - 查找到:user
    - 没查到:null
### service层
-[ ] LoginService
  - Message\<User\> login(String uname, String upassword, String key, String value);
    - uname: 用户名
    - upassword: 用户密码
    - key: 验证码编号
    - value: 验证码值
    - 判断验证码是否正确（验证码键值对存放在resources/properties/verification-code.properties文件中）
    - 判断账号是否存在
    - 判断密码是否有误
    - 无误:0, null, user
    - 有误:code, reason, null
### servlet层
-[ ] LoginServlet
  - uname: 用户名
  - upassword: 密码
  - key: 验证码编号
  - value: 验证码值
  - 登录成功:
    - {code:0}
    - 将User存入Session
  - 登录失败:{code:, reason:}
### view层
-[ ] login.html: 登录界面
-[ ] main.html: 选菜界面

## 2. 注册
### dao层
-[ ] UserDao
  - boolean addUser(User user);
    - user: 要注册的用户
    - 将user存入数据库
    - 成功:true
    - 没成功:false
### service层
-[ ] RegisterService
  - Message\<User\> login(String uname, String upassword1, String upassword2 String key, String value);
    - uname: 用户名
    - upassword1: 用户第一次输入的密码
    - upassword2: 用户第二次输入的密码
    - key: 验证码编号
    - value: 验证码值
    - 判断验证码是否正确（验证码键值对存放在resources/properties/verification-code.properties文件中）
    - 判断是否有属性为空字符串或null
    - 判断输入的内容是否可行（账号密码只能由数字、英文构成，用户名无所谓，字符串长度都在1—25）
    - 用户名由数字与英文组成，不能有重复
    - 判断两次输入的密码是否相同
    - 无误:0, null, null
    - 有误:code, reason, null
### servlet层
-[ ] RegisterServlet
  - uname: 用户名
  - upassword1: 第一次的密码
  - upassword2: 第二次的密码
  - key: 验证码编号
  - value: 验证码值
  - 注册成功:{code:0}
  - 注册失败:{code:, reason:}
### view层
-[ ] register.html: 注册界面
## 3. 是否已登录
### servlet层
-[ ] IsLoginServlet
  - 已登录:{code:0, uname:}
  - 未登录:{code:1}
## 4. 返回一共有几道菜
### dao层
-[ ] DishDao
  - int getDishNumber();
    - 返回菜的总数
### service层
-[ ] DishNumberService
  - int getDishNumber();
    - 返回菜的总数
### servlet层
-[ ] DishNumberServlet
  - 返回{number:}
## 5. 展示菜单
### dao层
-[ ] DishDao
  - List<Dish> getDishList(int start, int length);
    - start:开始，从0开始
    - length:菜的数量
    - 返回从start开始的后length道菜，例如start=3，length=4为第3，4，5，6道记录
      （因为使用limit函数，第3，4，5，6道菜不一定是id为3，4，5，6的记录）
    - 存在:List<Dish>
    - 不存在:null
### service层
-[ ] DisplayDishListService
  - List<Dish> displayDishList(int page);
    - page: 第几页的菜单（page从1开始）
    - 一页有5道菜，菜从1开始
    - 存在:List<Dish>
    - 不存在:null
### servlet层
-[ ] DisplayDishServlet
  - page: 第几页的菜单
    - 存在:\[{dId:, dName:, dPrice:, dDescription:, dImage:},
      {dId:, dName:, dPrice:, dDescription:, dImage:}
      {dId:, dName:, dPrice:, dDescription:, dImage:}
      {dId:, dName:, dPrice:, dDescription:, dImage:}
      {dId:, dName:, dPrice:, dDescription:, dImage:}\]
      返回类似这样的数组
    - 不存在:[]
## 6. 展示某道菜
### dao层
-[ ] DishDao
  - Dish getDishById(int dId);
    - did: 菜的id
    - 返回菜
    - 存在:Dish
    - 不存在:null
### service层
-[ ] DisplayOneDishService
  - Dish displayOne(int index);
    - index: 第几道菜（从0开始计算）
    - 存在:Dish
    - 不存在:null
### servlet层
-[ ] DisplayOneDishServlet
  - index: 第几道菜（从0开始计算）
    - 存在:{dId:, dName:, dPrice:, dDescription:, dImage}
    - 不存在:{dId:-1}
### view层
-[ ] dish.html
## 订购
### dao层
-[ ] OrderDao
  - boolean addOrder(String uname, int did, int count);
    - uname: 用户名
    - did: 菜id
    - count: 数量
    - 添加成功: true
    - 添加失败: false
### service层
-[ ] addOrderService
  - boolean addOrder(String uid, int did, int count);
    - uname:用户名
    - did: 菜id
    - count: 数量
    - 添加成功: true
    - 添加失败: false
### servlet层
-[ ] addOrderServlet
  - did: 菜id
  - count: 数量
  - 添加成功: {code:0}
  - 添加失败: {code:1}
## 7. 展示购物车
### dao层
-[ ] OrderDao
  - List<Order> getOrderByUid(String uname, int isShop);
    - uname: 用户名
    - isShop: 1表示返回已付款的订单，0表示返回未付款的订单（购物车）
    - 返回所有uid为此用户的Order
    - 存在:List\<Order>
    - 不存在:null
### service层
-[ ] GetShoppingCartService
  - Map\<Dish,Integer> getShoppingCart(String uname);
    - uname: 用户名
    - Map中储存Dish以及对应的数量
    - 存在: Map\<Dish,Integer>
    - 不存在:null
### servlet层
-[ ] GetShoppingCartServlet
    - 存在:\[{dId:, dName:, dPrice:, dDescription:, dImage:,count:},
      {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
      {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
      {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
      {dId:, dName:, dPrice:, dDescription:, dImage:,count:}\]
      返回类似这样的数组
    - 不存在:[]
## 8. 展示订单
### dao层
-[ ] OrderDao
  - List<Order> getOrderByUid(String uname);
    - uname: 用户名
    - 返回所有uname为此用户的Order
    - 存在:List\<Order>
    - 不存在:null
### service层
-[ ] GetOrderService
  - Map\<Dish,Integer> GetOrder(String uname);
    - uname: 用户名
    - Map中储存Dish以及对应的数量
    - 存在: Map\<Dish,Integer>
    - 不存在:null
### servlet层
-[ ] GetOrderServlet
      - 存在:\[{dId:, dName:, dPrice:, dDescription:, dImage:,count:},
        {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
        {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
        {dId:, dName:, dPrice:, dDescription:, dImage:,count:}
        {dId:, dName:, dPrice:, dDescription:, dImage:,count:}\]
        返回类似这样的数组
      - 不存在:[]
## 9. 购买
### dao层
-[ ] OrderDao
  - boolean UpdateOrderStateByUid(String uname);
    - uname: 用户名
    - 将uname为此用户的所有order都改成已支付
    - 成功:true
    - 不成功(没有记录可更改，即购物车为空):false
### service层
-[ ] BuyService
  - boolean buyOrder(String uname);
    - uname: 用户名
    - 将uname为此用户的所有order都改成已支付
    - 成功:true
    - 不成功:false
### servlet层
-[ ] BuyServlet
  - 将此用户的所有order都改成已支付
  - 成功:{code:0}
  - 不成功:{code:1}
## 10. 清空购物车
### dao层
-[ ] OrderDao
  - boolean deleteOrderByUname(String uname);
    - uname: 用户名
    - 删除所有属于该用户且未支付的订单
    - 成功:true
    - 不成功(没有记录可更改，即购物车为空):false
### service层
-[ ] ClearShoppingCartService
  - boolean buyOrder(String uname);
    - uname: 用户名
    - 删除所有属于该用户且未支付的订单
    - 成功:true
    - 不成功:false
### servlet层
-[ ] ClearShoppingCartServlet
  - 删除所有属于该用户且未支付的订单
  - 成功:{code:0}
  - 不成功:{code:1}

