package cn.edu.cugb.dao;

import cn.edu.cugb.dao.impl.DishDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DishDaoTest {
    @Test
    public void getDishNumber(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
        System.out.println(dishDao.getDishNumber());
    }
    @Test
    public void getDishList(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
        System.out.println(dishDao.getDishList(0, 20));
    }
    @Test
    public void getDishById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
        System.out.println(dishDao.getDishById(2));
        System.out.println(dishDao.getDishById(20));
    }


}
