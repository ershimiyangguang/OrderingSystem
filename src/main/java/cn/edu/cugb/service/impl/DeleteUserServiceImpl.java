package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteUserServiceImpl implements DeleteUserService {
    @Autowired

    UserDao userDao;
    @Override
    public Message<User> deleteUser(String uName) {
        Message<User> message=new Message<User>();
        boolean IsDelSuccess=false;
        IsDelSuccess= userDao.deleteUser(uName);
        if(!IsDelSuccess)
        {
         message.setCode(1);
         message.setReason("没有该用户");

        }
        else {
            message.setCode(0);
        }
        return message;
    }
}
