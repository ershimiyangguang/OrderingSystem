package cn.edu.cugb.dao;

import cn.edu.cugb.bean.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String uname);

    boolean addUser(User user);
    List<User> getUserList(int start, int length);
    int getUserNumber();
    boolean updateUser(User user);
    boolean deleteUser(String uName);
}
