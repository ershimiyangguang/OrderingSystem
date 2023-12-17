package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Admin;
import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.AdminLoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        AdminLoginService adminLoginService = applicationContext.getBean("AdminLoginService", AdminLoginService.class);

        String uname = request.getParameter("aname");
        String upassword = request.getParameter("apassword");
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Message<Admin> loginAdmin = adminLoginService.login(uname, upassword, key, value);

        if(loginAdmin.getCode()==0){
            request.getSession().setAttribute("Admin",loginAdmin.getObject());
            out.println("{\"code\":\"0\"}");

        }
        else{
            out.println("{\"code\":\""+loginAdmin.getCode()+"\",\"reason\":\""+loginAdmin.getReason()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}