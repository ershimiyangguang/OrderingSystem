package test.service.white1;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.AddDishServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddDishServiceTest {
    // 一个方法代表一个测试用例
    // 方法名为被测试的类名+Test+编号
    @Test
    public void AddDishServiceTest01() {
        // 通过spring的方法获取对象，要获取其他对象将getBean的第一个字符串参数“AddDishService”改成其他要测试的类名
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //调用被测试的方法
        Message<Dish> result = addDishService.addDish("33","testdish","wjjwoei","Test");
        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest02() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("33","testdish","wjjwoei","Test");
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}
