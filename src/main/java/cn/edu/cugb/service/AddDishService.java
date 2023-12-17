package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;

public interface AddDishService {
    Message<Dish> addDish(String did, String dName, String dPrice, String dDesc);
}
