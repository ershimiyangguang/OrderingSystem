package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.GetUserListService;
import cn.edu.cugb.service.GetUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserNumberServiceImpl implements GetUserNumberService {
    @Autowired

    UserDao userDao;

    @Override
    public int getUserNumber() {
        return userDao.getUserNumber();
    }
}
