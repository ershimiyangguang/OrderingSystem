package test.service.black1;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.LoginService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class LoginTest {
    @Test
    public void LoginTest01() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginService loginService = applicationContext.getBean("LoginService", LoginService.class);

        Message<User> loginUser = loginService.login("root1", "1234", "0", "0313");
        System.out.println("测试用例01输出：");
        System.out.println(loginUser);
    }

    @Test
    public void LoginTest02() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginService loginService = applicationContext.getBean("LoginService", LoginService.class);

        Message<User> loginUser = loginService.login("root", "123456", "0", "0313");
        System.out.println("测试用例02输出：");
        System.out.println(loginUser);
    }

    @Test
    public void LoginTest03() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginService loginService = applicationContext.getBean("LoginService", LoginService.class);

        Message<User> loginUser = loginService.login("root", "1234", "0", "0319");
        System.out.println("测试用例03输出：");
        System.out.println(loginUser);
    }

    @Test
    public void LoginTest04() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginService loginService = applicationContext.getBean("LoginService", LoginService.class);

        Message<User> loginUser = loginService.login("test1", "1234", "0", "0313");
        System.out.println("测试用例04输出：");
        System.out.println(loginUser);
    }
}
