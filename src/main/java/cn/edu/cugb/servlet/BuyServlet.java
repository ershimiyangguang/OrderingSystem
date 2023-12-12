package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.BuyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("User");
        String uname = user.getUName();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        BuyService buyService = applicationContext.getBean("BuyService", BuyService.class);

        if(buyService.buyOrder(uname)){
            out.println("{\"code\":\"0\"}");
            response.sendRedirect("order.html");
        }
        else{
            out.println("{\"code\":\"1\"}");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}