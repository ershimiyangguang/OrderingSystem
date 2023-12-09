package cn.edu.cugb.service.impl;

import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.AddOrderService;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AddOrderServiceImpl implements AddOrderService {

    @Autowired

    OrderDao orderDao;
    @Override
    public boolean addOrder(String uname, int did, int count) {

        return orderDao. addOrder(uname,did,count);
    }

}
