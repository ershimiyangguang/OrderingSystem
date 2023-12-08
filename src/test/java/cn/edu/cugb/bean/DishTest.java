package cn.edu.cugb.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DishTest {
    @Test
    public void dishTest() throws Exception {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
        String sql="select * from dish";
        List<Dish> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class));
        System.out.println(dishes);
    }
}
