package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired

    UserDao userDao;
    @Override
    public Message<User> login(String uid, String password,String key, String value) throws IOException {

        Message<User>message =new Message<User>();

        User user=userDao.getUserByName(uid);
        InputStream inputStream=null;
        try {
            inputStream = this.getClass().getResourceAsStream("/properties/verification-code.properties");

        }catch (Exception e)
        {
            System.out.print(e);
        }

        Properties properties = new Properties();
        properties.load(inputStream);

        String TrueValue=properties.getProperty(key); // 验证码的值

        if(user==null)
        {
            message.setReason("用户不存在");
            message.setCode(1);
        }
        else
        {
         if(user.getUPassword().equals(password))
         {
             if(value.equals(TrueValue))
             {
                 message.setCode(0);
                 message.setObject(user);
             }
             else {
                 System.out.print(value+" "+TrueValue);
                 message.setCode(4);
                 message.setReason("验证码不正确");

             }
         }
         else
         {
             System.out.print("输入密码"+password+" "+"正确密码"+user.getUPassword());
             message.setReason("密码不正确");
             message.setCode(2);
         }
        }

        return  message;


    }
}
