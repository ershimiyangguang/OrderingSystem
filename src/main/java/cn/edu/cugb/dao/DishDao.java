package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;

import java.util.List;

public interface DishDao {
    int getDishNumber();

    Dish getDishById(int id);

    List<Dish> getDishList(int start, int length);
}
