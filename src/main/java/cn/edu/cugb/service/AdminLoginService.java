package cn.edu.cugb.service;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.bean.Message;

import java.io.IOException;

public interface AdminLoginService {
    Message<Admin> login(String aname,String apassword,String key,String value) throws IOException;
}
