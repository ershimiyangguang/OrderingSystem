package test.service.white1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.DeleteUserService;
import cn.edu.cugb.service.impl.DeleteDishByIdServiceImpl;
import cn.edu.cugb.service.impl.DeleteUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUserServiceTest {
    @Test
    public void DeleteUserServiceTest01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteUserService deleteUserService=applicationContext.getBean("DeleteUserService", DeleteUserServiceImpl.class);
        Message<User> userMessage=deleteUserService.deleteUser("test01");
        System.out.println("测试用例01：");
        System.out.println(userMessage);
    }
    @Test
    public void DeleteUserServiceTest02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteUserService deleteUserService=applicationContext.getBean("DeleteUserService", DeleteUserServiceImpl.class);
        Message<User> userMessage=deleteUserService.deleteUser("test");
        System.out.println("测试用例02：");
        System.out.println(userMessage);
    }
}
