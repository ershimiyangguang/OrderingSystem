package test.service.black2;

import cn.edu.cugb.service.impl.AddOrderServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddOrderServiceTest {
    // 一个方法代表一个测试用例
    // 方法名为被测试的类名+Test+编号
    @Test
    public void AddOrderServiceImplTest01() {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “AddOrderService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddOrderServiceImpl addOrderService = applicationContext.getBean("AddOrderService", AddOrderServiceImpl.class);
        // 调用被测试的方法
        boolean result = addOrderService.addOrder("testuser", 1, 5);
        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void AddOrderServiceImplTest02() {
        // 通过 Spring 的方法获取对象，要获取其他对象将 getBean 的第一个字符串参数 “AddOrderService” 改成其他要测试的类名
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddOrderServiceImpl addOrderService = applicationContext.getBean("AddOrderService", AddOrderServiceImpl.class);
        // 调用被测试的方法
        boolean result = addOrderService.addOrder("root", 1, -100000);
        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}
