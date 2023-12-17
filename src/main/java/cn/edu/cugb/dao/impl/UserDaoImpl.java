package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
         catch(EmptyResultDataAccessException e){
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
    @Override
    public List<User> getUserList(int start, int length){
        String sql="select *from users limit ?,?";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), start, length);
        return users;
    }
    @Override
    public int getUserNumber(){
        String sql="select count(*) from users";
        Integer userNumber = jdbcTemplate.queryForObject(sql, int.class);
        return userNumber;
    }
    @Override
   public boolean updateUser(User user){
        boolean flag=false;
        String sql="update users set u_password=? where u_name=?";
       int i = jdbcTemplate.update(sql, user.getUPassword(), user.getUName());
       if(i>=1)
           flag=true;
       return flag;
   }
   @Override
   public boolean deleteUser(String uName){
       boolean flag=false;
        String sql="delete from users where u_Name=?";
        int i = jdbcTemplate.update(sql, uName);
       if(i>=1)
           flag=true;
       return flag;
   }
}
