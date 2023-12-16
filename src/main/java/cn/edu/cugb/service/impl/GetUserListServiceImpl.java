package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.GetUserListService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetUserListServiceImpl implements GetUserListService {

    @Autowired

    UserDao userDao;

    int UsersNumberInOnePage=10;

    @Override
    public List<User> getUserList(int page) {

        int start=(page-1)*UsersNumberInOnePage;

        return userDao.getUserList(start,UsersNumberInOnePage);
    }
}
