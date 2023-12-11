package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
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

        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String upassword = request.getParameter("password");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        LoginService loginService = applicationContext.getBean("LoginService", LoginService.class);

        Message<User> loginUser = loginService.login(uname, upassword, key, value);

        if(loginUser.getCode()==0){
            request.getSession().setAttribute("User",loginUser.getObject());
            out.println("{\"code\":\"0\"}");
        }
        else{
            out.println("{\"code\":\""+loginUser.getCode()+"\",\"reason\":\""+loginUser.getReason()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}