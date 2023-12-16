package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateUserServiceTest {

    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateUserService updateUserService = applicationContext.getBean("UpdateUserService", UpdateUserService .class);
        // 调用被测试的方法

        Message<User> result = updateUserService.updateUser("root","114");

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
