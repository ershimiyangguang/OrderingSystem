package cn.edu.cugb.dao;

import java.util.List;

public interface OrderDao {

    boolean addOrder(String uname, int did, int count);

    List getOrderByUname(String uname);

    List getOrderByUname(String uname, int isshop);

    boolean UpdateOrderStateByUname(String uname);
}
