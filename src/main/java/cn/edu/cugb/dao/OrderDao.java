package cn.edu.cugb.dao;

import cn.edu.cugb.bean.Order;

import java.util.List;

public interface OrderDao {

    boolean addOrder(String uname, int did, int count);

    List<Order> getOrderByUname(String uname);

    List<Order> getOrderByUname(String uname, int isshop);

    boolean UpdateOrderStateByUname(String uname);

    boolean deleteOrderByUname(String uname);

}
