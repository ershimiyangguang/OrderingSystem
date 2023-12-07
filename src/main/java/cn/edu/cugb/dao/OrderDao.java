package cn.edu.cugb.dao;

import java.util.List;

public interface OrderDao {
    boolean addOrder(int uid, int did, int count);

    List getOrderByUid(int uid, int isshop);
}
