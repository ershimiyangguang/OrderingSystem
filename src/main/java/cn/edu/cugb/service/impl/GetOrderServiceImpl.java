package cn.edu.cugb.service.impl;
import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Order;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrderServiceImpl implements GetOrderService {
    @Autowired
    @Qualifier("orderDao")
    OrderDao orderDao;

    @Autowired
    @Qualifier("dishDao")
    DishDao dishDao;
    @Override
    public Map<Dish, Integer> GetOrder(String uname) {

        Map<Dish,Integer> map=new HashMap<Dish,Integer>();

      List<Order> orders= orderDao.getOrderByUname(uname,1);

      for(Order order :orders)
      {
          Dish dish=dishDao.getDishById(order.getDId());

          map.put(dish,order.getOCount());
      }

      return  map;

    }
}
