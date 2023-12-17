package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.UpdateUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        UpdateUserService updateUserService = applicationContext.getBean("UpdateUserService", UpdateUserService.class);

        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");

        Message userMessage = updateUserService.updateUser(uname, upassword);

        if(userMessage.getCode()==0){
            out.println("{\"code\":\"0\"}");
        }
        else{
            out.println("{\"code\":\""+userMessage.getCode()+"\",\"reason\":\""+userMessage.getReason()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}