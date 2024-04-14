package test.service.black2;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.UpdateUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateUserServiceImplTest {


    @Test
    public void testUpdateUser_ValidInput() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateUserServiceImpl updateUserService = applicationContext.getBean("UpdateUserService", UpdateUserServiceImpl.class);

        // 调用被测试的方法，传入有效的用户名和密码参数
        Message<User> result = updateUserService.updateUser("test", "1234");

        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void testUpdateUser_EmptyPassword() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateUserServiceImpl updateUserService = applicationContext.getBean("UpdateUserService", UpdateUserServiceImpl.class);

        // 调用被测试的方法，传入空的密码参数
        Message<User> result = updateUserService.updateUser("testuser", "");

        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }

    @Test
    public void testUpdateUser_NonexistentUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateUserServiceImpl updateUserService = applicationContext.getBean("UpdateUserService", UpdateUserServiceImpl.class);

        // 调用被测试的方法，传入不存在的用户名
        Message<User> result = updateUserService.updateUser("nonexistentUser", "newPassword");

        // 验证结果
        System.out.println("测试用例03输出：");
        System.out.println(result);
    }

    // 可以继续添加其他测试用例来覆盖不同的情况

}