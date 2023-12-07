package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;

import java.util.List;

public interface DisplayDishListService {
    List<Dish> displayDishList(int page);
}
