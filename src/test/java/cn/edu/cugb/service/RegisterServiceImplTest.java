package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.LoginServiceImpl;
import cn.edu.cugb.service.impl.RegisterServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class RegisterServiceImplTest {
    @Test
 public    void RegisterTest() throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       RegisterServiceImpl registerService = applicationContext.getBean("RegisterService", RegisterServiceImpl .class);

        System.out.print( registerService.register ("test4","1234","1234","0","0313"));
    }
}
