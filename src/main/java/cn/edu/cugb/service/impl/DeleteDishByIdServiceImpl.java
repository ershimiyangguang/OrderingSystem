package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.DeleteDishByIdService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteDishByIdServiceImpl implements DeleteDishByIdService
{
    @Autowired

    DishDao dishDao;

    @Override
    public Message deleteDishById(String dId) {
        Message message=new Message();
        boolean IsDelDishSuccess= dishDao.deleteDishById(Integer.parseInt(dId));
        if(!IsDelDishSuccess)
        {
            message.setCode(1);
            message.setReason("菜品不存在");
            return  message;
        }
        message.setCode(0);
        return message;


    }
}
