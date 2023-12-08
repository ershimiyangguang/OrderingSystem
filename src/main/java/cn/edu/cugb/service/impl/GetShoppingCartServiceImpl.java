package cn.edu.cugb.service.impl;
import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Order;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.GetShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetShoppingCartServiceImpl implements GetShoppingCartService {
    @Autowired
    @Qualifier("orderDao")
    OrderDao orderDao;

    @Autowired
    @Qualifier("dishDao")
    DishDao dishDao;
    @Override
    public Map<Dish, Integer> getShoppingCart(String uname) {


        Map<Dish,Integer> map=new HashMap<Dish,Integer>();

        List<Order> orders= orderDao.getOrderByUname(uname,0); // 0 代表未付款，也就是仍在购物车里的订单。

        for(Order order :orders)
        {
            Dish dish=dishDao.getDishById(order.getDId());

            map.put(dish,order.getOCount());
        }

        return  map;
    }
}
