package test.service.white1;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.DeleteDishByNameService;
import cn.edu.cugb.service.impl.DeleteDishByNameServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteDishByNameServiceTest {
    @Test
    public void DeleteDishByNameServiceTest01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByNameServiceImpl deleteDishByNameService=applicationContext.getBean("DeleteDishByNameService",
                DeleteDishByNameServiceImpl.class);
        Message<Dish> message=deleteDishByNameService.deleteDishByName("红烧肉");
        System.out.println("测试用例01：");
        System.out.println(message);
    }
    @Test
    public void DeleteDishByNameServiceTest02(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DeleteDishByNameServiceImpl deleteDishByNameService=applicationContext.getBean("DeleteDishByNameService",
                DeleteDishByNameServiceImpl.class);
        Message<Dish> message=deleteDishByNameService.deleteDishByName("九转大肠");
        System.out.println("测试用例02：");
        System.out.println(message);
    }
}
