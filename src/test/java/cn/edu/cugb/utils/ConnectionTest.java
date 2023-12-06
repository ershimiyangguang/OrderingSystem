package cn.edu.cugb.utils;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.alibaba.druid.pool.DruidDataSource;

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
        DruidDataSource dataSource = a.getBean("ProjectDataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource);
    }
}