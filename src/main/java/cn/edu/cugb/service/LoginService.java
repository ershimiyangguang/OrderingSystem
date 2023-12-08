package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;

import java.io.IOException;

public interface LoginService {
    /*登录
    * 参数: 用户id, 用户密码
    * 判断输入信息是否有误*/
    Message<User> login(String uname, String password,String key, String value) throws IOException;



}
