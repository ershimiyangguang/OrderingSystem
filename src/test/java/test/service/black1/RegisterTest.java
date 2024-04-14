package test.service.black1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.RegisterService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class RegisterTest {

    @Test
    public void RegisterTest01() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register(null, null, null, "0", "0313");
        System.out.println("测试用例01输出：");
        System.out.println(registerUser);
    }
    @Test
    public void RegisterTest02() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test1", "1234", "1234", "0", "0319");
        System.out.println("测试用例02输出：");
        System.out.println(registerUser);
    }
    @Test
    public void RegisterTest03() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test1@@@", "1234", "1234", "0", "0313");
        System.out.println("测试用例03输出：");
        System.out.println(registerUser);
    }

    @Test
    public void RegisterTest04() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test1", "1234@@@", "1234",  "0", "0313");
        System.out.println("测试用例04输出：");
        System.out.println(registerUser);
    }

    @Test
    public void RegisterTest05() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test1", "1234", "123456", "0", "0313");
        System.out.println("测试用例05输出：");
        System.out.println(registerUser);
    }

    @Test
    public void RegisterTest06() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test1", "1234", "1234", "0", "0313");
        System.out.println("测试用例06输出：");
        System.out.println(registerUser);
    }

    @Test
    public void RegisterTest07() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register("test123", "1234", "1234",  "0", "0313");
        System.out.println("测试用例07输出：");
        System.out.println(registerUser);
    }

}
