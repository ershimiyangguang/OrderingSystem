package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.dao.DishDao;
import cn.edu.cugb.service.UpdateDishService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateDishServiceImpl implements UpdateDishService {
    @Autowired

    DishDao dishDao;

    int CodeNumberLimit=50; // 字符限定数
    @Override
    public Message updateDish(String did, String dName, String dPrice, String dDesc) {

        Message<Dish> message=new Message<Dish>();


        if(did.equals(""))
        {
            message.setCode(1);
            message.setReason("菜品号为空");
            return  message;
        }



        if(dName.equals(""))
        {
            message.setCode(1);
            message.setReason("菜品名为空");
            return  message;
        }

        if(dName.length()>CodeNumberLimit)
        {
            message.setCode(2);
            message.setReason("菜品名字数过多，请少于"+CodeNumberLimit+"字");
            return  message;
        }

        if(dPrice.equals("")) {
            message.setCode(3);
            message.setReason("菜品价格为空");
            return  message;
        }


        float Price=0;

        try {

            Price=Float.parseFloat(dPrice);

        } catch (NumberFormatException e) {
            // 如果转换失败，则抛出NumberFormatException，表示不是数字
            message.setCode(3);
            message.setReason("价格输入不合法,价格输入应该为数字");
            return message;
        }

        if (Price <= 0) {
            message.setCode(3);
            message.setReason("价格不合法，不可小于0");
            return message;
        }

        if(dDesc.equals("")) {
            message.setCode(4);
            message.setReason("菜品描述为空");
            return  message;
        }

        if(dDesc.length()>CodeNumberLimit)
        {
            message.setCode(4);
            message.setReason("菜品描述字数过多，请少于"+CodeNumberLimit+"字");
            return  message;
        }



        String DishImage="images/"+dName+".jpg";

        Dish dish=new Dish();
        dish.setDId(Integer.valueOf(did));
        dish.setDDescription(dDesc);
        dish.setDName(dName);
        dish.setDPrice(Integer.valueOf(dPrice));
        dish.setDImage(DishImage);

        boolean IsUpdateDishSuccess= dishDao.updateDish(dish);


        if(!IsUpdateDishSuccess)
        {
            message.setCode(1);
            message.setReason("菜品不存在");
            return message;
        }

        message.setCode(0);

        return message;


    }
}
