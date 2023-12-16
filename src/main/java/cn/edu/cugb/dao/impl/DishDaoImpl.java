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
    @Override
    public boolean addDish(Dish dish){

        String sql="insert into dish values(?,?,?,?,?)";
        try{
            jdbcTemplate.update(sql,dish.getDId(),dish.getDName(),dish.getDPrice(),dish.getDDescription(),dish.getDImage
                    ());
        }
       catch(Exception e){
            return false;
       }
        return true;
    }
    @Override
   public Dish getDishByName(String dName){
        Dish dish;
        String sql="select *from dish where d_name=?";
        try{
            dish=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Dish.class),dName);
        }
        catch(EmptyResultDataAccessException e ){
            dish=null;
        }
        return dish;
   }
   @Override
   public boolean updateDish(Dish dish){
        String sql="update dish set d_name=?,d_description=?,d_price=?,d_image=? where d_id=?";
       int i = jdbcTemplate.update(sql, dish.getDName(), dish.getDDescription(), dish.getDPrice(), dish.getDImage(),
               dish.getDId());
       if(i>=1)
           return true;
       else
           return false;
   }
   @Override
    public boolean deleteDishById(int dId){
        String sql="delete from dish where d_id=?";
        int i = jdbcTemplate.update(sql, dId);
        return true;
    }
    @Override
    public boolean deleteDishByName(String dName){
        String sql="delete from dish where d_name=?";
        int i = jdbcTemplate.update(sql, dName);
        return true;
    }



}
