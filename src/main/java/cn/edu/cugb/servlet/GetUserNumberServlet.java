package cn.edu.cugb.servlet;

import cn.edu.cugb.service.GetUserNumberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetUserNumberServlet")
public class GetUserNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        GetUserNumberService getUserNumberService = applicationContext.getBean("GetUserNumberService",GetUserNumberService.class);

        int num = getUserNumberService.getUserNumber();

        out.println("{\"number\":\""+num+"\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}