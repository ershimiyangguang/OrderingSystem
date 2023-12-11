package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.service.DisplayOneDishService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DisplayOneDishServlet")
public class DisplayOneDishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DisplayOneDishService displayOneDishService = applicationContext.getBean("DisplayOneDishService", DisplayOneDishService.class);

        int index = Integer.parseInt(request.getParameter("index"));

        if(displayOneDishService.displayOne(index)==null){
            out.println("{\"dId\":\"-1\"}");

        }
        else{
            Dish dish = displayOneDishService.displayOne(index);
            out.println("{\"dId\":\""+dish.getDId()+"\",\"dName\":\""+dish.getDName()+"\",\"dDescription\":\""+dish.getDDescription()+"\",\"dImage\":\""+dish.getDImage()+"\"}");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}