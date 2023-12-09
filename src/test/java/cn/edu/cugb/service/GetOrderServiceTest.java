package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.GetOrderServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetOrderServiceTest {
    @Test
    public void GetOrderServiceTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        GetOrderServiceImpl getOrderService = applicationContext.getBean("GetOrderService", GetOrderServiceImpl .class);

        System.out.print(getOrderService.GetOrder("test"));
    }
}
