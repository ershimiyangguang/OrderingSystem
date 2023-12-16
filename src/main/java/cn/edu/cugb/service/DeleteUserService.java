package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

public interface DeleteUserService {
    Message<User> deleteUser(String uName);
}
