package cn.edu.cugb.service.impl;
import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.DisplayOneDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DisplayOneDishServiceImpl implements  DisplayOneDishService {
    @Autowired
    @Qualifier("dishDao")
    DishDao dishDao;
    @Override
    public Dish displayOne(int index) {
        return dishDao.getDishById(index);
    }
}
