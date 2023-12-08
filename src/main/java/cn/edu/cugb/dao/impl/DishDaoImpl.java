package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.Dish;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DishDaoImpl implements cn.edu.cugb.dao.DishDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getDishNumber(){
        String sql="select count(*) from dish";
        Integer tools = jdbcTemplate.queryForObject(sql, int.class);
        return tools;
    }

    @Override
    public List<Dish> getDishList(int start, int length){
        String sql="select *from dish limit ?,?";
        List<Dish> dishes=null;
         dishes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Dish.class), start, length);
        return dishes;
    }

    @Override
    public Dish getDishById(int dId) {
        String sql="select *from dish where d_id=?";
        Dish dish=null;
        try{
             dish = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Dish.class), dId);
        }
        catch (EmptyResultDataAccessException e){

            return null;
        }
        return dish;
    }


}
