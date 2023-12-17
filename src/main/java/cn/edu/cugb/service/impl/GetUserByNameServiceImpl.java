package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.GetUserByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GetUserByNameServiceImpl implements GetUserByNameService {
    @Autowired
    @Qualifier("userDao")
    UserDao userDao;

    @Override
    public User getUserByName(String uName) {
        return userDao.getUserByName(uName);
    }
}
