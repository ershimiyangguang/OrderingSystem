package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.BuyServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.cglib.core.VisibilityPredicate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BuyServiceTest {
    @Test
    public void  BuyServiceTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        BuyServiceImpl buyService = applicationContext.getBean("BuyService", BuyServiceImpl .class);

        System.out.print( buyService.buyOrder("test"));
    }
}
