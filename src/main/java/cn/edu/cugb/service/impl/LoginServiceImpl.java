package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.LoginService;

public class LoginServiceImpl implements LoginService {
    UserDao userDao;
    @Override
    public Message<User> login(String uid, String password) {
        return null;
    }
}
