package test.service.black1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.DeleteUserService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUserTest {

    @Test
    public void DeleteUserTest01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteUserService deleteUserService = applicationContext.getBean("DeleteUserService", DeleteUserService.class);

        Message message = deleteUserService.deleteUser("root1234");
        System.out.println("测试用例01输出：");
        System.out.println(message);
    }

    @Test
    public void DeleteUserTest02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteUserService deleteUserService = applicationContext.getBean("DeleteUserService", DeleteUserService.class);

        Message message = deleteUserService.deleteUser("root123");
        System.out.println("测试用例02输出：");
        System.out.println(message);
    }
}
