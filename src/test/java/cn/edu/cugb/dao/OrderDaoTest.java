package cn.edu.cugb.dao;

import cn.edu.cugb.dao.impl.OrderDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDaoTest {
    @Test
    public  void addOrderTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.addOrder(2, 1, 5));
    }
    @Test
    public void getOrderByuid(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.getOrderByUid(1, 0));
        System.out.println(orderDao.getOrderByUid(2, 1));
    }
    @Test
    public  void getOrderByuid2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.getOrderByUid(1));
    }
    @Test
    public void updateOrderStateByuid(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.UpdateOrderStateByUid(1));
        System.out.println(orderDao.UpdateOrderStateByUid(3));
    }
}
