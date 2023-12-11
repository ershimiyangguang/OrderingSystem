package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.RegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String upassword1 = request.getParameter("upassword1");
        String upassword2 = request.getParameter("upassword2");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        RegisterService registerService = applicationContext.getBean("RegisterService", RegisterService.class);

        Message<User> registerUser = registerService.register(uname, upassword1, upassword2, key, value);

        if(registerUser.getCode()==0){
            out.println("{\"code\":\"0\"}");
        }
        else{
            out.println("{\"code\":\""+registerUser.getCode()+"\",\"reason\":\""+registerUser.getReason()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}