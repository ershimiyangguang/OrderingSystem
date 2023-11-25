package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;

public interface LoginService {
    /*登录
    * 参数: 用户id, 用户密码
    * 判断输入信息是否有误*/
    Message login(String uid, String password);
}
