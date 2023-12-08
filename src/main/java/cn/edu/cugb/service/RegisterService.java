package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

import java.io.IOException;

public interface RegisterService {
    Message<User> register(String uname, String password1, String password2, String key, String value) throws IOException;
}
