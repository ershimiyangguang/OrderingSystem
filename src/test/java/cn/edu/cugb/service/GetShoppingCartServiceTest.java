package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.GetShoppingCartServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetShoppingCartServiceTest {
    @Test
    public void GetShoppingCartServiceTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        GetShoppingCartServiceImpl getShoppingCartService = applicationContext.getBean("GetShoppingCartService", GetShoppingCartServiceImpl .class);

        System.out.print( getShoppingCartService.getShoppingCart("test3"));
    }
}
