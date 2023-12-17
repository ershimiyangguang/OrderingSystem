package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

public interface UpdateUserService {
    Message<User> updateUser(String uName, String uPassword);
}
