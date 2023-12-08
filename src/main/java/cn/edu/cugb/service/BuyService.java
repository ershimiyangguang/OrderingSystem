package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;

import java.util.Map;

public interface BuyService {
    Map<Dish,Integer> buyOrder(String uid);
}
