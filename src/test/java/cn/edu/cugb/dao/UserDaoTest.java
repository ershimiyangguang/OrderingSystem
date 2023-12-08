package cn.edu.cugb.dao;

import cn.edu.cugb.bean.User;
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
}