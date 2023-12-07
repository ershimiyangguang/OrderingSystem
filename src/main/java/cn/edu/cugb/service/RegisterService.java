package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

public interface RegisterService {
    Message<User> Registered(String uid, String password1, String password2, String key, String value);
}
