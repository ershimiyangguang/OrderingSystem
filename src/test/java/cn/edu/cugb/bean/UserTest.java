package cn.edu.cugb.bean;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserTest {
    @Test
    public void userTest(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
        String sql="select * from users";
        List<User> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(dishes);
    }
}