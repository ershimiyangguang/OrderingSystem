package test.service.black2;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.DeleteDishByIdServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByIdServiceITest
{

    @Test
    public void testDeleteDishById_ExistingId() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteDishByIdServiceImpl deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdServiceImpl.class);

        // 模拟存在的菜品 ID
        String existingDishId = "1";

        // 调用被测试的方法
        Message result = deleteDishByIdService.deleteDishById(existingDishId);

        // 验证结果
        System.out.println("测试用例01输出：");
        System.out.println(result);
    }

    @Test
    public void testDeleteDishById_NonExistingId() {
        // 获取 Spring 上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");

        // 获取被测试的服务类实例
        DeleteDishByIdServiceImpl deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdServiceImpl.class);

        // 模拟不存在的菜品 ID
        String nonExistingDishId = "999";

        // 调用被测试的方法
        Message result = deleteDishByIdService.deleteDishById(nonExistingDishId);

        // 验证结果
        System.out.println("测试用例02输出：");
        System.out.println(result);
    }
}