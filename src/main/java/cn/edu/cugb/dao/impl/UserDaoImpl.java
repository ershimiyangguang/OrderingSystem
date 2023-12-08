package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements cn.edu.cugb.dao.UserDao {
    JdbcTemplate jdbcTemplate;
  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserByName(String uname) {
        User user=null;
        String sql="select *from users where u_name=?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),uname);
        }
         catch(Exception e){
           // e.printStackTrace();
           // e.getMessage();
            return null;
        }
        return user;
    }
  
    @Override
    public boolean addUser(User user){
        boolean flag=true;
        String sql="insert into users(u_name,u_password) values(?,?)";
        try{
            jdbcTemplate.update(sql, user.getUName(), user.getUPassword());
        }catch(Exception e){
            flag=false;
        }
        return flag;
    }
}
