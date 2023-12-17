package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.DisplayOneDishService;
import cn.edu.cugb.service.GetUserByNameService;
import cn.edu.cugb.service.GetUserNumberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/GetUserByNameServlet")
public class GetUserByNameServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        GetUserByNameService getUserByNameService = applicationContext.getBean("GetUserByNameService", GetUserByNameService.class);

        String uName = request.getParameter("uname");

        if(getUserByNameService.getUserByName(uName)==null){
            out.println("{\"uname\":\"-1\"}");

        }
        else{
            User user = getUserByNameService.getUserByName(uName);

            out.println("{\"uname\":\""+user.getUName()+"\",\"upassword\":\""+user.getUPassword()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}