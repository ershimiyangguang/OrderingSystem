package test.service.white1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.impl.RegisterServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ResigterServiceTest {
    @Test
    public void RegisterServiceTest01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("root","123456","123456","0","1466");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例01：");
        System.out.println(userMessage);

    }
    @Test
    public void RegisterServiceTest02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("root","","","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例02：");
        System.out.println(userMessage);
    }
    @Test
    public void RegisterServiceTest03(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("管理员","123456","123456","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例03：");
        System.out.println(userMessage);
    }
    @Test
    public void RegisterServiceTest04(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("root","123456","1234567","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例04：");
        System.out.println(userMessage);
    }
    @Test
    public void RegisterServiceTest05(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("root","123456","123456","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例05：");
        System.out.println(userMessage);
    }
    @Test
    public void RegisterServiceTest06(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("root","管理员","管理员","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例06：");
        System.out.println(userMessage);
    }
    @Test
    public void RegisterServiceTest07(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterServiceImpl registerService=applicationContext.getBean("RegisterService", RegisterServiceImpl.class);
        Message<User> userMessage=null;
        try {
            userMessage=registerService.register("test01","123456","123456","0","0313");
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        System.out.println("测试用例07：");
        System.out.println(userMessage);
    }
}


