package test.service.black2;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.AdminLoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AdminLoginServiceTest {

    @Test
    public void AdminLoginServiceImplTest01() throws IOException {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “AdminLoginService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AdminLoginServiceImpl adminLoginService = applicationContext.getBean("AdminLoginService", AdminLoginServiceImpl.class);
        // 调用被测试的方法
        Message<Admin> result = adminLoginService.login("admin", "password", "key", "value");
        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void AdminLoginServiceImplTest02() throws IOException {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “AdminLoginService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AdminLoginServiceImpl adminLoginService = applicationContext.getBean("AdminLoginService", AdminLoginServiceImpl.class);
        // 调用被测试的方法
        Message<Admin> result = adminLoginService.login("admin", "123", "key", "value");
        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}
