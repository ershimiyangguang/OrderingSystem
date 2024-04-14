package test.service.black1;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.DeleteDishByNameService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByNameTest {

    @Test
    public void DeleteDishByNameTest01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByNameService deleteDishByNameService = applicationContext.getBean("DeleteDishByNameService", DeleteDishByNameService.class);

        Message message = deleteDishByNameService.deleteDishByName("九转大肠");
        System.out.println("测试用例01输出：");
        System.out.println(message);
    }

    @Test
    public void DeleteDishByNameTest02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByNameService deleteDishByNameService = applicationContext.getBean("DeleteDishByNameService", DeleteDishByNameService.class);

        Message message = deleteDishByNameService.deleteDishByName("青菜肉丝粥");
        System.out.println("测试用例02输出：");
        System.out.println(message);
    }
}
