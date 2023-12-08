package cn.edu.cugb.service;

import cn.edu.cugb.bean.Dish;

import java.util.Map;

public interface GetOrderService {
    Map<Dish,Integer> GetOrder(String uid);
}
