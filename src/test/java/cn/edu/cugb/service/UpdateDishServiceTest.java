package cn.edu.cugb.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateDishServiceTest {
    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       UpdateDishService updateDishService = applicationContext.getBean("UpdateDishService", UpdateDishService .class);
        // 调用被测试的方法

        int result = updateDishService.updateDish("33","test3dish","29","Test").getCode();

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
