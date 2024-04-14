package test.service.black2;

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
        Message<Dish> result = addDishService.addDish("33"," 返回消息对象代码为2，原因为“菜品名字数过多”（结果）","10","Test");
        // 验证结果
        System.out.println("测试用例10输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest02() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("33","testdish","-100","Test");
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
        @Test
        public void testAddDish_EmptyDishId() {
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
            AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
            //调用被测试的方法
            Message<Dish> result = addDishService.addDish("","testdish","wjjwoei","Test");
            // 验证返回的消息对象状态码和错误原因是否符合预期
            System.out.println("测试用例03输出：");
            System.out.println(result);
        }
    @Test
    public void AddDishServiceTest04() {
        // 通过spring的方法获取对象，要获取其他对象将getBean的第一个字符串参数“AddDishService”改成其他要测试的类名
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //调用被测试的方法
        Message<Dish> result = addDishService.addDish("33","testdish","","Test");
        // 验证结果
        System.out.println("测试用例04输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest05() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("55","皮蛋瘦肉粥","18","Test");
        System.out.println("测试用例05输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest06() {
        // 通过spring的方法获取对象，要获取其他对象将getBean的第一个字符串参数“AddDishService”改成其他要测试的类名
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //调用被测试的方法
        Message<Dish> result = addDishService.addDish("33","","wjjwoei","Test");
        // 验证结果
        System.out.println("测试用例06输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest07() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("33","testdish","10","");
        System.out.println("测试用例07输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest08() {
        // 通过spring的方法获取对象，要获取其他对象将getBean的第一个字符串参数“AddDishService”改成其他要测试的类名
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //调用被测试的方法
        Message<Dish> result = addDishService.addDish("33","testdish","18","Testttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        // 验证结果
        System.out.println("测试用例08输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest09() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("33","testdisssssssssssssssssssssssssssssssssssssssssssssssssssssssssss","22","Test");
        System.out.println("测试用例09输出：");
        System.out.println(result);
    }
    @Test
    public void AddDishServiceTest10() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishServiceImpl addDishService = applicationContext.getBean("AddDishService", AddDishServiceImpl .class);
        //不同的测试用例使用不同的参数
        Message<Dish> result = addDishService.addDish("33","testdisssssssssssssssssssssssssssssssssssssssssssssssssssssssssss","22","Test");
        System.out.println("测试用例10输出：");
        System.out.println(result);
    }

}

