package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.AddDishServiceImpl;
import cn.edu.cugb.service.impl.AddOrderServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddDishServiceTest {
    @Test
    public void test() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
       AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        // 调用被测试的方法

        Message<Dish> result = addDishService.addDish("33","testdish","29","Test");

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
