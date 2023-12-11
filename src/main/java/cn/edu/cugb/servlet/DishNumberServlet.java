package cn.edu.cugb.servlet;

import cn.edu.cugb.service.DishNumberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DishNumberServlet")
public class DishNumberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DishNumberService dishNumberService = applicationContext.getBean("DishNumberService",DishNumberService.class);

        int num = dishNumberService.dishNumberService();

        out.println("{\"number\":\""+num+"\"}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}