package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class LoginServiceImpl implements LoginService {
    @Autowired
    @Qualifier("userDao")
    UserDao userDao;
    @Override
    public Message<User> login(String uid, String password,String key, String value) throws IOException {

        Message<User>message =new Message<User>();

        User user=userDao.getUserByName(uid);

        InputStream inputStream = this.getClass().getResourceAsStream("verification-code.properties");
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
         if(user.getUPassword()==password)
         {
             if(value==TrueValue)
             {
                 message.setCode(4);
                 message.setReason("验证码不正确");
             }
             else {

                 message.setCode(0);
             }
         }
         else
         {
             message.setReason("密码不正确");
             message.setCode(2);
         }
        }

        return  message;


    }
}
