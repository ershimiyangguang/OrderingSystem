package cn.edu.cugb.dao;

import cn.edu.cugb.bean.User;

public interface UserDao {

    User getUserByName(String uname);

    boolean addUser(User user);

}
