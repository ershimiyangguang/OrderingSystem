package cn.edu.cugb.service;

import cn.edu.cugb.bean.Message;

public interface UpdateDishService {
    Message updateDish(String did, String dName, String dPrice, String dDesc);
}
