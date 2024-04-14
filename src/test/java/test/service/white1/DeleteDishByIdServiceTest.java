package test.service.white1;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.impl.DeleteDishByIdServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByIdServiceTest {
    @Test
    public void DeleteDishByIdServiceTest01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdServiceImpl deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService",
                DeleteDishByIdServiceImpl.class);
        Message<Dish> dishMessage=deleteDishByIdService.deleteDishById("22");
        System.out.println("测试用例1：");
        System.out.println(dishMessage);
    }
    @Test
    public void DeleteDishByIdServiceTest02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByIdServiceImpl deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService",
                DeleteDishByIdServiceImpl.class);
        Message<Dish> dishMessage=deleteDishByIdService.deleteDishById("21");
        System.out.println("测试用例2：");
        System.out.println(dishMessage);
    }
}
