package cn.edu.cugb.util;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionTest {
    @Before
    public void SetUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ConnectionTest() throws Exception {
        ApplicationContext a = new ClassPathXmlApplicationContext("xml/spring.xml");
        ProjectDataSource projectDataSource = a.getBean("ProjectDataSource",ProjectDataSource.class);
        System.out.println(projectDataSource.getConnection());
    }
}