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
    public boolean addOrder(int uid, int did, int count){
        boolean flag=true;
        String sql="insert into orders (u_id,d_id,o_count) values(?,?,?)";

       try{
           jdbcTemplate.update(sql, uid, did, count);
       }
       catch (DuplicateKeyException e){
           flag = false;
       }

        return  flag;
    }
    @Override
    public List getOrderByUid(int uid, int isshop){
        String sql="select *from orders where u_id=? and o_state=?";
        List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), uid, isshop);
        return orders;
    }
   public  List getOrderByUid(int uid){
        String sql="select *from orders where u_id=?";
       List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class), uid);
       return orders;
   }
    public boolean UpdateOrderStateByUid(int uid){
        boolean flag=true;
        String sql="update orders set o_state=1 where u_id=?";
        int i = jdbcTemplate.update(sql, uid);
        if (i==0)
            flag=false;
        return flag;
    }
}
