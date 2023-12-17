package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserServiceImpl implements UpdateUserService {

    @Autowired

    UserDao userDao;


    @Override
    public Message<User> updateUser(String uName, String uPassword) {
        Message<User> message=new Message<User>();
        boolean IsUpdateSuccess=false;
        User user =new User();
        user.setUPassword(uPassword);
        user.setUName(uName);
        IsUpdateSuccess=userDao.updateUser(user);
        if(!IsUpdateSuccess)
        {
            message.setCode(1);
            message.setReason("被修改用户不存在");
        }
        else {
            message.setCode(0);
        }
        return message;
    }
}
