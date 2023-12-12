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
        System.out.println(orderDao.addOrder("test", 4, 5));
        System.out.println(orderDao.getOrderByUname("test"));
    }
    @Test
    public void getOrderByUname(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.getOrderByUname("test", 0));
        System.out.println(orderDao.getOrderByUname("test", 1));
    }
    @Test
    public  void getOrderByUname2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.getOrderByUname("test"));
    }
    @Test
    public void updateOrderStateByuname(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.UpdateOrderStateByUname("test"));
        System.out.println(orderDao.UpdateOrderStateByUname("lisi"));
    }
    @Test
    public void deleteOrderByUname(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
        System.out.println(orderDao.deleteOrderByUname("test"));
        System.out.println(orderDao.deleteOrderByUname("lisi"));
    }

}
