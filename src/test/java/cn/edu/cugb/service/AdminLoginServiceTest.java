package cn.edu.cugb.service;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.AddOrderServiceImpl;
import cn.edu.cugb.service.impl.AdminLoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AdminLoginServiceTest {
    // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
    @Test
  public   void Test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AdminLoginServiceImpl adminLoginService = applicationContext.getBean("AdminLoginService", AdminLoginServiceImpl.class);
        // 调用被测试的方法

        Message<Admin> result;

        {
            try {
                result = adminLoginService.login("admin", "1234", "0", "0313");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(result);

    }

}
