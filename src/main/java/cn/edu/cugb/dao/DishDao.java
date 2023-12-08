package cn.edu.cugb.dao;

import java.util.List;

public interface DishDao {
    int getDishNumber();

    List getDishList(int start, int length);
}
