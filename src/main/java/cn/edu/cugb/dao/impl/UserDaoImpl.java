package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(Integer uid) {
        User user=null;
        String sql="select *from users where u_id=?";
        try {
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),uid);
        }
         catch(EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }
    public boolean addUser(User user){
        boolean flag=true;
        String sql="insert into users(u_id,u_name,u_password) values(?,?,?)";
        try{
            jdbcTemplate.update(sql, user.getUId(), user.getUName(), user.getUPassword());
        }catch(Exception e){
            flag=false;
        }
        return flag;
    }

}
