package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.GetOrderService;
import cn.edu.cugb.service.GetShoppingCartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("User");
        String uname = user.getUName();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        GetOrderService getOrderService = applicationContext.getBean("GetOrderService", GetOrderService.class);

        if(getOrderService.GetOrder(uname)==null){
            out.println("[]");
        }
        else{
            Map<Dish,Integer> dishOrder = getOrderService.GetOrder(uname);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}