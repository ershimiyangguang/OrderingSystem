package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.BuyServiceImpl;
import cn.edu.cugb.service.impl.CleanShoppingCartServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CleanShoppingCartServiceTest {
    @Test
    public void  BuyServiceTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        CleanShoppingCartService cleanShoppingCartService  = applicationContext.getBean("CleanShoppingCartService", CleanShoppingCartServiceImpl.class);

        System.out.print(cleanShoppingCartService.cleanShoppingCart("test"));

    }
}
