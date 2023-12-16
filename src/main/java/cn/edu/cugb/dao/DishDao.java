package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Dish;

import java.util.List;

public interface DishDao {
    int getDishNumber();

    //Dish getDishById(int id);

    List<Dish> getDishList(int start, int length);

    Dish getDishById(int dId);
    boolean addDish(Dish dish);
    Dish getDishByName(String dName);
    boolean updateDish(Dish dish);
    boolean deleteDishById(int dId);
    boolean deleteDishByName(String dName);
}
