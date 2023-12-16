package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.dao.impl.DishDaoImpl;
import cn.edu.cugb.dao.impl.OrderDaoImpl;
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
    @Test
    public void addDish(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
        Dish dish=new Dish(19,"九转大肠",100,"美味","images/500019.jpg");
        System.out.println(dishDao.addDish(dish));
    }
    @Test
    public void getDishByName(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
        System.out.println(dishDao.getDishByName("九转大肠"));
        System.out.println(dishDao.getDishByName("九转大肠1"));
    }
   @Test
    public void updateDish(){
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
       System.out.println(dishDao.updateDish(new Dish(19, "小鸡炖蘑菇", 100, "美味可口",
               "images/500013.jpg")));
       System.out.println(dishDao.updateDish(new Dish(20, "小鸡炖蘑菇", 100, "美味可口",
               "images/500013.jpg")));
   }
  @Test
    public void deleteDishById(){
      ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
      DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
      OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
      System.out.println(orderDao.addOrder("test", 19, 2));//添加记录
      System.out.println(orderDao.getOrderByUname("test"));
      System.out.println(dishDao.deleteDishById(19));
      System.out.println(orderDao.getOrderByUname("test"));
    }
  @Test
    public void deleteDishByName(){
      ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
      DishDaoImpl dishDao = applicationContext.getBean("dishDao", DishDaoImpl.class);
      OrderDaoImpl orderDao = applicationContext.getBean("orderDao", OrderDaoImpl.class);
      System.out.println(orderDao.addOrder("test", 19, 2));//添加记录
      System.out.println(orderDao.getOrderByUname("test"));
      System.out.println(dishDao.deleteDishByName("小鸡炖蘑菇"));
      System.out.println(orderDao.getOrderByUname("test"));
  }

}
