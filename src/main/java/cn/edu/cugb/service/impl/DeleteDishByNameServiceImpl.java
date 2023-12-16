package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.DeleteDishByNameService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteDishByNameServiceImpl implements DeleteDishByNameService {
    @Autowired

    DishDao dishDao;

    @Override
    public Message deleteDishByName(String dName) {
        Message message=new Message();
        boolean flag=dishDao.deleteDishByName(dName);
        if(!flag)
        {
            message.setCode(1);
            message.setReason("菜品名不存在");
            return  message;
        }
        message.setCode(0);
        return  message;
    }
}
