package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Order;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.impl.UserDaoImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoTest {
    @Test
    public void UserDaoTest() throws Exception {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDaoImpl.getUserById(1));
        User user = userDaoImpl.getUserById(3);
        if(user==null){
            System.out.println("未查到该用户，返回为空");
        }
    }
    @Test
    public void addUser(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UserDaoImpl userDaoImpl = applicationContext.getBean("userDao", UserDaoImpl.class);
        User user=new User(3,"王五","123456");
        boolean bool = userDaoImpl.addUser(user);
        System.out.println(bool);
    }

}