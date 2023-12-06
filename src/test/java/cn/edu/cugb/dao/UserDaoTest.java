package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Order;
import cn.edu.cugb.bean.User;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoTest {
    @Before
    public void SetUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void DaoTest() throws Exception {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
        String sql="select *from dish";
        List<Dish> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class));
        System.out.println(dishes);

    }
    @Test
    public void UserTest(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
        String sql="select *from users";
        List<User> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(dishes);
    }
   @Test
    public void OrderTest(){
       ApplicationContext applicationContext= new ClassPathXmlApplicationContext("xml/spring.xml");
       JdbcTemplate jdbcTemplate = applicationContext.getBean("JdbcTemplate", JdbcTemplate.class);
       String sql="select *from orders";
       List<Order> dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
       System.out.println(dishes);
   }
}