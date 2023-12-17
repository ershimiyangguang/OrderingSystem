package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUserServiceTest {
    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       DeleteUserService deleteUserService = applicationContext.getBean("DeleteUserService", DeleteUserService .class);
        // 调用被测试的方法

        Message<User> result = deleteUserService.deleteUser("test");

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
