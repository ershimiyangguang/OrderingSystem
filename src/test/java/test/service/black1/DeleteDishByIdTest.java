package test.service.black1;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.DeleteDishByIdService;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByIdTest {

    @Test
    public void DeleteDishByIdTest01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdService deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdService.class);

        Message message = deleteDishByIdService.deleteDishById("20");
        System.out.println("测试用例01输出：");
        System.out.println(message);
    }

    @Test
    public void DeleteDishByIdTest02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdService deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdService.class);

        Message message = deleteDishByIdService.deleteDishById("0");
        System.out.println("测试用例02输出：");
        System.out.println(message);
    }

    @Test
    public void DeleteDishByIdTest03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdService deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdService.class);

        Message message = deleteDishByIdService.deleteDishById("1");
        System.out.println("测试用例03输出：");
        System.out.println(message);
    }

    @Test
    public void DeleteDishByIdTest04(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdService deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdService.class);

        Message message = deleteDishByIdService.deleteDishById("18");
        System.out.println("测试用例04输出：");
        System.out.println(message);
    }

}
