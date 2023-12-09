package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.DisplayDishListServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisplayDishListServiceTest {
    @Test
    public  void  DisplayDishListServiceTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       DisplayDishListServiceImpl displayDishListService = applicationContext.getBean("DisplayDishListService", DisplayDishListServiceImpl .class);

        System.out.print( displayDishListService.displayDishList(1));
    }
}
