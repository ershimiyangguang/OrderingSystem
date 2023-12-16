package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.dao.impl.AdminDaoImpl;
import cn.edu.cugb.dao.impl.DishDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoTest {
    @Test
    public void getAdminByName(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AdminDaoImpl adminDao = applicationContext.getBean("adminDao", AdminDaoImpl.class);
        Admin admin = adminDao.getAdminByName("admin");
        System.out.println(admin);
        System.out.println(adminDao.getAdminByName("4444"));
    }

}
