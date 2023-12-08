package cn.edu.cugb.service.impl;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.DishNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DishNumberServiceImpl implements DishNumberService {
    @Autowired
    @Qualifier("dishDao")
    DishDao dishDao;
    @Override
    public int dishNumberService() {

        return dishDao.getDishNumber();

    }
}
