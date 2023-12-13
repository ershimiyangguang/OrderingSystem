package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Order;
import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.AddOrderService;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddOrderServiceImpl implements AddOrderService {

    @Autowired

    OrderDao orderDao;
    @Override
    public boolean addOrder(String uname, int did, int count) {

        Order NowOrder=new Order();

        //初始化现在增加的订单

        NowOrder.setOCount(count);

        NowOrder.setDId(did);

        NowOrder.setUName(uname);

        NowOrder.setOState(0); // 默认为未购买状态

        List<Order> orders=orderDao.getOrderByUname(uname);

        boolean IsExistSameDish=false;

        for(Order order :orders)
        {
            // 订单中已有这道菜
            if(order.getDId().equals(did))
            {
                // 订单中的菜品数累加上传来的Count
                order.setOCount(order.getOCount()+count);
                IsExistSameDish=true;
                break;
            }
        }
        //只有不存在相同菜品时才插入新订单
        if(!IsExistSameDish){
            orders.add(NowOrder);
        }

        // 清空订单

        orderDao.deleteOrderByUname(uname);

        // 重新写入订单

        try {
            for(Order order :orders)
            {
                orderDao.addOrder(order.getUName(),order.getDId(),order.getOCount());
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.print(e);
            return false;
        }


    }

}
