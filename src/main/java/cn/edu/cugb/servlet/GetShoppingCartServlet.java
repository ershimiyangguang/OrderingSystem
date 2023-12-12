package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.GetShoppingCartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@WebServlet(urlPatterns = "/GetShoppingCartServlet")
public class GetShoppingCartServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("User");
        String uname = user.getUName();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        GetShoppingCartService getShoppingCartService = applicationContext.getBean("GetShoppingCartService", GetShoppingCartService.class);

        if(user==null||getShoppingCartService.getShoppingCart(uname)==null){
            out.println("[]");
        }
        else{
            Map<Dish,Integer> dishOrder = getShoppingCartService.getShoppingCart(uname);
            Iterator<Map.Entry<Dish,Integer>> iterator=dishOrder.entrySet().iterator();

            out.print("[");
            while(iterator.hasNext()){
                Map.Entry<Dish,Integer> entry = iterator.next();
                out.print("{\"dId\":\""+entry.getKey().getDId()+"\",\"dName\":\""+entry.getKey().getDName()+"\",\"dPrice\":\""+entry.getKey().getDPrice()+"\",\"dDescription\":\""+entry.getKey().getDDescription()+"\",\"dImage\":\""+entry.getKey().getDImage()+"\",\"count\":\""+entry.getValue()+"\"}");

                if(iterator.hasNext())
                    out.print(",");
            }
            out.print("]");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}