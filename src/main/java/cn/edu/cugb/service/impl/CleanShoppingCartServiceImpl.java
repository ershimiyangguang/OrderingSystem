package cn.edu.cugb.service.impl;

import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.CleanShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CleanShoppingCartServiceImpl implements CleanShoppingCartService {

    @Autowired
    @Qualifier("orderDao")
    OrderDao orderDao;
    @Override
    public boolean cleanShoppingCart(String uname) {

        return orderDao.deleteOrderByUname(uname);

    }


}
