package cn.edu.cugb.dao.impl;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate;
    @Override
    public User getUserByName(String uid) {
        return null;
    }
}
