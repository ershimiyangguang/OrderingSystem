package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;

import java.util.Map;

public interface GetShoppingCartService {
    Map<Dish,Integer> getShoppingCart(String uid);
}
