package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GetUserListServiceTest {
    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       GetUserListService getUserListService = applicationContext.getBean("GetUserListService", GetUserListService .class);
        // 调用被测试的方法

        List<User> result = getUserListService.getUserList(1);

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
