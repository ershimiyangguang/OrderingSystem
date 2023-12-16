package cn.edu.cugb.service.impl;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.dao.AdminDao;
import cn.edu.cugb.dao.OrderDao;
import cn.edu.cugb.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    @Qualifier("adminDao")
    AdminDao adminDao;
    @Override
    public Message<Admin> login(String aname, String apassword, String key, String value) throws IOException {

        Message<Admin>message =new Message<Admin>();

        Admin admin=adminDao.getAdminByName(aname);

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


        // 先对验证码进行验证

        if(value.equals(TrueValue))
        {
            if(admin==null)
            {
                message.setReason("用户不存在");
                message.setCode(1);
            }
            else
            {
                if(admin.getAPassword() .equals(apassword))
                {
                    message.setCode(0);
                    message.setObject(admin);
                }
                else
                {
                    System.out.print("输入密码"+apassword+" "+"正确密码"+admin.getAPassword());
                    message.setReason("密码不正确");
                    message.setCode(2);
                }
            }
        }
        else {
            System.out.print(value+" "+TrueValue);
            message.setCode(4);
            message.setReason("验证码不正确");


        }





        return  message;


    }
}
