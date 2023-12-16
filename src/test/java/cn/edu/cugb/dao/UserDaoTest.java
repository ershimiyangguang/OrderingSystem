package cn.edu.cugb.dao;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.impl.OrderDaoImpl;
import cn.edu.cugb.dao.impl.UserDaoImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {
    @Test
    public void UserDaoTest() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDaoImpl.getUserByName("test"));
        User user = userDaoImpl.getUserByName("lisi");
        if(user==null){
            System.out.println("未查到该用户，返回为空");
        }
    }
    @Test
    public void addUser(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
        User user=new User("wangwu","123456");
        boolean bool = userDaoImpl.addUser(user);
        System.out.println(bool);
    }
    @Test
    public void getUserList(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDaoImpl.getUserList(0, 2));
        System.out.println(userDaoImpl.getUserList(0, 0));
    }
   @Test
    public void getUserNumber(){
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
       System.out.println(userDaoImpl.getUserNumber());
   }
   @Test
    public void updateUser(){
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
       User user=new User();
       user.setUName("test");
       user.setUPassword("123456");
       System.out.println(userDaoImpl.updateUser(user));
       User user1=new User("lisi","123456");
       System.out.println(userDaoImpl.updateUser(user1));
   }
   @Test
    public void deleteUser(){
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
       OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
       System.out.println(userDaoImpl.deleteUser("lisi"));
       System.out.println(orderDao.getOrderByUname("test"));
       System.out.println(userDaoImpl.deleteUser("test"));
   }




}