package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.Admin;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDaoImpl implements cn.edu.cugb.dao.AdminDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Admin getAdminByName(String aName){
        Admin admin=null;
        String sql="select *from admin where a_name=?";
        try{
            admin=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Admin.class),aName);
        }catch(EmptyResultDataAccessException e){
            admin=null;
        }
       return admin;
    }

}
