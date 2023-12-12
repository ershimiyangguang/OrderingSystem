package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDaoImpl implements cn.edu.cugb.dao.OrderDao {
     JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean addOrder(String uname, int did, int count){
        boolean flag=true;
        String sql="insert into orders (u_name,d_id,o_count,o_state) values(?,?,?,?)";

       try{
           jdbcTemplate.update(sql, uname, did, count,0);
       }
       catch (Exception e){
           //System.out.print(e);
           flag = false;
       }

        return  flag;
    }


   @Override
   public  List<Order> getOrderByUname(String uname){
        String sql="select *from orders where u_name=?";
       List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), uname);
       return orders;
   }
   @Override
   public List<Order> getOrderByUname(String uname, int isshop){
       String sql="select *from orders where u_name=? and o_state=?";
       List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), uname,isshop);
       return orders;
   }

    @Override
    public boolean UpdateOrderStateByUname(String uname){
        boolean flag=true;
        String sql="update orders set o_state=1 where u_name=?";
        int i = jdbcTemplate.update(sql, uname);
        if (i==0)
            flag=false;
        return flag;
    }
   public boolean deleteOrderByUname(String uname){
        boolean flag=true;
        String sql="delete from orders where u_name=? and o_state=0";
        try{
            int i = jdbcTemplate.update(sql, uname);
            //System.out.println(i);
        }
        catch(Exception e){
            flag=false;
        }
       return flag;
   }
}
