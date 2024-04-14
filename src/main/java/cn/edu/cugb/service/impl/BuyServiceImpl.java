package cn.edu.cugb.service.impl;

import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BuyServiceImpl implements BuyService {

    @Autowired
    @Qualifier("orderDao")
    OrderDao orderDao;



    @Override
    public boolean buyOrder(String uname) {  // 付账，将订单完成
      return   orderDao.UpdateOrderStateByUname(uname);
    }

}
