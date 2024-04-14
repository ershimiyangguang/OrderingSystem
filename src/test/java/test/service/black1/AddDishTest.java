package test.service.black1;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.AddDishService;
import cn.edu.cugb.service.RegisterService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AddDishTest {
    @Test
    public void AddDishTest01() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("","皮蛋瘦肉粥","5","美味可口！");
        System.out.println("测试用例01输出：");
        System.out.println(userMessage);
    }
    @Test
    public void AddDishTest02() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","","5","美味可口！");
        System.out.println("测试用例02输出：");
        System.out.println(userMessage);
    }
    @Test
    public void AddDishTest03() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版","5","美味可口！");
        System.out.println("测试用例03输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest04() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","九转大肠","","美味可口！");
        System.out.println("测试用例04输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest05() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","九转大肠","-5","美味可口！");
        System.out.println("测试用例05输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest06() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","九转大肠","5","");
        System.out.println("测试用例06输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest07() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","九转大肠","5","之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版九转大肠之仙气飘飘永葆青春版！");
        System.out.println("测试用例07输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest08() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("19","皮蛋瘦肉粥","5","美味可口！");
        System.out.println("测试用例08输出：");
        System.out.println(userMessage);
    }

    @Test
    public void AddDishTest09() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddDishService addDishService = applicationContext.getBean("AddDishService", AddDishService.class);

        Message userMessage = addDishService.addDish("20","九转大肠","5","美味可口！");
        System.out.println("测试用例09输出：");
        System.out.println(userMessage);
    }
}
