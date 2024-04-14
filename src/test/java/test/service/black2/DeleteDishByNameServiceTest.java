package test.service.black2;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.DeleteDishByNameServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByNameServiceTest {

    @Test
    public void testDeleteDishByName_ExistingName() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteDishByNameServiceImpl deleteDishByNameService = applicationContext.getBean("DeleteDishByNameService", DeleteDishByNameServiceImpl.class);

        // 模拟存在的菜品名称
        String existingDishName = "炸酱面";

        // 调用被测试的方法
        Message result = deleteDishByNameService.deleteDishByName(existingDishName);

        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void testDeleteDishByName_NonExistingName() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteDishByNameServiceImpl deleteDishByNameService = applicationContext.getBean("DeleteDishByNameService", DeleteDishByNameServiceImpl.class);

        // 模拟不存在的菜品名称
        String nonExistingDishName = "NonExistingDish";

        // 调用被测试的方法
        Message result = deleteDishByNameService.deleteDishByName(nonExistingDishName);

        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}