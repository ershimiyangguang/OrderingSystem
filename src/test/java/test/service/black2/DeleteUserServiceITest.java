package test.service.black2;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.impl.DeleteUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUserServiceITest {

    @Test
    public void testDeleteUser_ExistingUser() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteUserServiceImpl deleteUserServiceImpl = applicationContext.getBean("DeleteUserService", DeleteUserServiceImpl.class);

        // 模拟存在的用户名
        String existingUserName = "test";

        // 调用被测试的方法
        Message<User> result = deleteUserServiceImpl.deleteUser(existingUserName);
        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void testDeleteUser_NonExistingUser() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteUserServiceImpl deleteUserServiceImpl = applicationContext.getBean("DeleteUserService", DeleteUserServiceImpl.class);

        // 模拟不存在的用户名
        String nonExistingUserName = "NonExistingUser";

        // 调用被测试的方法
        Message<User> result = deleteUserServiceImpl.deleteUser(nonExistingUserName);
        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}