package cn.edu.cugb.bean;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderTest {
    @Test
    public void orderTest(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
        String sql="select * from orders";
        List<Order> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
        System.out.println(dishes);
    }
}