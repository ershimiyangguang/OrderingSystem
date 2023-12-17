package cn.edu.cugb.service;

import cn.edu.cugb.bean.User;

import java.util.List;

public interface GetUserListService {
    List<User> getUserList(int page);
}
