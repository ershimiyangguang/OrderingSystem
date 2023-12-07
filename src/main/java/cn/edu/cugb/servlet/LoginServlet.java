package cn.edu.cugb.servlet;

import cn.edu.cugb.service.LoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Servlet1")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {

    }
    /*登录
    * 参数: uid=账号, password=密码
    * 登录成功跳转到main页面
    * 登录失败返回message的code与reason*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}