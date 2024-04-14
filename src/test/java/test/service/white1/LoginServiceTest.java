package test.service.white1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginServiceTest {
    @Test
    public void LoginServiceTest01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService=applicationContext.getBean("LoginService", LoginServiceImpl.class);
        Message<User> userMessage;
        try{
            userMessage=loginService.login("root","123456","0","1466");
        }
        catch(Exception exception){
            userMessage=null;
        }
        System.out.println("测试用例01：");
        System.out.println(userMessage);
    }
    @Test
    public void LoginServiceTest02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService=applicationContext.getBean("LoginService", LoginServiceImpl.class);
        Message<User> userMessage;
        try{
            userMessage=loginService.login("test01","123456","0","0313");
        }
        catch(Exception exception){
            userMessage=null;
        }
        System.out.println("测试用例02：");
        System.out.println(userMessage);
    }
    @Test
    public void LoginServiceTest03(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService=applicationContext.getBean("LoginService", LoginServiceImpl.class);
        Message<User> userMessage;
        try{
            userMessage=loginService.login("root","1234","0","0313");
        }
        catch(Exception exception){
            userMessage=null;
        }
        System.out.println("测试用例03：");
        System.out.println(userMessage);
    }
    @Test
    public void LoginServiceTest04(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginServiceImpl loginService=applicationContext.getBean("LoginService", LoginServiceImpl.class);
        Message<User> userMessage;
        try{
            userMessage=loginService.login("root","123456","0","0313");
        }
        catch(Exception exception){
            userMessage=null;
        }
        System.out.println("测试用例04：");
        System.out.println(userMessage);
    }
    @Test
    public void LoginServiceTest05(){

    }

}
