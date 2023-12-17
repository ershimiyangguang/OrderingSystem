package cn.edu.cugb.service;

import cn.edu.cugb.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GetUserNumberServiceTest {
    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       GetUserNumberService getUserNumberService = applicationContext.getBean("GetUserNumberService", GetUserNumberService .class);
        // 调用被测试的方法

        int result = getUserNumberService.getUserNumber();

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
