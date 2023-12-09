package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.AddOrderServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceTest {
    @Before
    public void SetUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ServiceTest() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService = applicationContext.getBean("LoginService", LoginServiceImpl .class);

        System.out.print( loginService.login("test","1234","0","0313"));
    }
    @Test
    public void ServiceTest2() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService = applicationContext.getBean("LoginService", LoginServiceImpl .class);

        System.out.print( loginService.login("test2","1234","0","0313"));
    }
    @Test
    public void ServiceTest3() throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService = applicationContext.getBean("LoginService", LoginServiceImpl .class);

        System.out.print( loginService.login("test","124","0","0313"));
    }
}