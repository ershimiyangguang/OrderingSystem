package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.dao.UserDao;
import cn.edu.cugb.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.util.ObjectUtils.isEmpty;

public class RegisterServiceImpl implements RegisterService {
    @Autowired
    @Qualifier("userDao")
    UserDao userDao;
    @Override
    public Message<User> register(String uname, String password1, String password2, String key, String value) throws IOException {


        Message<User> message=new Message<User>();

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

        if (isEmpty(uname) || isEmpty(password1) || isEmpty(password2) || isEmpty(value)) {
            // 如果有任何参数为空，返回错误消息
           message.setReason("所有信息必须填写");
           return message;
        }

        if(!isValid(uname))
        {
            message.setCode(1);
            message.setReason("账号只能由数字、英文构成");
            return message;
        }

        if(!isValid(password1))
        {
            message.setCode(2);
            message.setReason("密码只能由数字、英文构成");
            return message;
        }

        if(!password1.equals(password2))
        {

            message.setCode(3);
            message.setReason("两次密码不一致");
            return  message;
        }

        if(userDao.getUserByName(uname)!=null)
        {
            message.setCode(1);
            message.setReason("用户已存在");
            return message;
        }

        if(!TrueValue.equals(value))
        {
            message.setCode(5);
            message.setReason("验证码不正确");
            return message;
        }




        User user=new User();

        user.setUName(uname);

        user.setUPassword(password1);



        userDao.addUser(user);

        message.setCode(0);
        return message;
    }

    public boolean isValid(String password) {
        // 定义正则表达式，表示只包含数字和英文字母
        String regex = "^[a-zA-Z0-9]+$";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建匹配器
        Matcher matcher = pattern.matcher(password);

        // 进行匹配并返回结果
        return matcher.matches();
    }


}
