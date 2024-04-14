package test.service.black2;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class LoginServiceImplTest {  // 一个方法代表一个测试用例
    // 方法名为被测试的类名+Test+编号
    @Test
    public void LoginServiceImplTest01() throws IOException {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “LoginService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService = applicationContext.getBean("LoginService", LoginServiceImpl.class);
        // 调用被测试的方法
        Message<User> result = loginService.login("root", "123", "0", "0313");
        // 验证结果
        System.out.println("测试用例03输出：");
        System.out.println(result);
    }
    @Test
    public void LoginServiceImplTest02() throws IOException {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “LoginService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService = applicationContext.getBean("LoginService", LoginServiceImpl.class);
        // 调用被测试的方法
        Message<User> result = loginService.login("33", "", "key", "value");
        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}