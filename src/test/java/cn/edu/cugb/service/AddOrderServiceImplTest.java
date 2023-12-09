package cn.edu.cugb.service;

import static org.junit.Assert.assertTrue;


import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.dao.impl.DishDaoImpl;
import cn.edu.cugb.service.impl.AddOrderServiceImpl;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddOrderServiceImplTest {





    @Test
    public void testAddOrder() {
        // 设置 OrderDao 的行为（例如，使用 Mockito.when().thenReturn()）
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
     AddOrderServiceImpl addOrderService = applicationContext.getBean("addOrderService", AddOrderServiceImpl .class);
        // 调用被测试的方法

        boolean result = addOrderService.addOrder("test3", 4, 5);

        System.out.println(result);
        // 验证结果

        // 可以添加其他验证或断言
    }
}
