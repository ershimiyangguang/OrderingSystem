package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;

import java.util.List;

public interface DishDao {
    int getDishNumber();

    List<Dish> getDishList(int start, int length);

   Dish getDishById(int dId);

}
