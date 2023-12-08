package cn.edu.cugb.service.impl;
import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.DisplayDishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class DisplayDishListServiceImpl implements  DisplayDishListService {

    int DishNumberInOnePage;
    @Autowired
    @Qualifier("dishDao")
    DishDao dishDao;
    @Override
    public List<Dish> displayDishList(int page) { // 每页放多少餐品

        int start=(page-1)*DishNumberInOnePage;

        return  dishDao.getDishList(start,DishNumberInOnePage);
    }
}
