package cn.edu.cugb.service.impl;

import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.AddOrderService;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AddOrderServiceImpl implements AddOrderService {

    @Autowired
    @Qualifier("orderDao")
    OrderDao orderDao;
    @Override
    public boolean addOrder(String uname, int did, int count) {

        return addOrder(uname,did,count);
    }

}
