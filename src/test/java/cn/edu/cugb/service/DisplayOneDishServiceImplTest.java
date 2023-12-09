package cn.edu.cugb.service;

import cn.edu.cugb.service.impl.DisplayOneDishServiceImpl;
import cn.edu.cugb.service.impl.LoginServiceImpl;
import org.junit.Test;
import org.springframework.cglib.core.VisibilityPredicate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisplayOneDishServiceImplTest {
    @Test
    public void  DisplayOneDishServiceImplTest()
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("xml/spring.xml");
        DisplayOneDishServiceImpl displayOneDishService = applicationContext.getBean("DisplayOneDishService", DisplayOneDishServiceImpl .class);

        System.out.print( displayOneDishService.displayOne(1));
    }
}
