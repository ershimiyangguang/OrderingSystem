package test.service.black2;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.UpdateDishServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateDishServiceImplTest {
    @Test
    public void testUpdateDish_EmptyDishId() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateDishServiceImpl updateDishService = applicationContext.getBean("UpdateDishService", UpdateDishServiceImpl.class);

        // 调用被测试的方法，传入空的菜品编号
        Message<Dish> result = updateDishService.updateDish("", "New Dish", "10.5", "Updated description");

        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void testUpdateDish_InvalidPrice() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        UpdateDishServiceImpl updateDishService = applicationContext.getBean("UpdateDishService", UpdateDishServiceImpl.class);

        // 调用被测试的方法，传入不合法的价格参数
        Message<Dish> result = updateDishService.updateDish("1", "New Dish", "Not a number", "Updated description");

        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }

    // 可以继续添加其他测试用例来覆盖不同的情况
}
