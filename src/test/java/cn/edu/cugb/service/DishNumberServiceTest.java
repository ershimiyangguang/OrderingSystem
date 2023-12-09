package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.DishNumberServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DishNumberServiceTest {
    @Test
    public  void  DishNumberTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DishNumberServiceImpl dishNumberService = applicationContext.getBean("DishNumberService", DishNumberServiceImpl .class);

        System.out.print( dishNumberService.dishNumberService());
    }
}
