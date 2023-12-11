package cn.edu.cugb.servlet;


import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.AddOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        AddOrderService addOrderService = applicationContext.getBean("AddOrderService", AddOrderService.class);

        User user = (User) request.getSession().getAttribute("User");
        String uname = user.getUName();
        int did = Integer.parseInt(request.getParameter("did"));
        int count = Integer.parseInt(request.getParameter("count"));

        if(addOrderService.addOrder(uname,did,count)){
            out.println("{\"code\":\"0\"}");
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