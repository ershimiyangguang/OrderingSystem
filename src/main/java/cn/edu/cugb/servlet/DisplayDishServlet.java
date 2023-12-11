package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Dish;
import cn.edu.cugb.service.DisplayDishListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DisplayDishServlet")
public class DisplayDishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/spring.xml");
        DisplayDishListService displayDishListService = applicationContext.getBean("DisplayDishListService", DisplayDishListService.class);

        int page = Integer.parseInt(requset.getParameter("page"));

        if(displayDishListService.displayDishList(page)==null){
            out.println("[]");
        }
        else{
           List<Dish> dishList =  displayDishListService.displayDishList(page);
           for(int i=0;i<dishList.size();i++){
               Dish dish = dishList.get(i);
               if(i==0)
                   out.print("[");
               out.print("{\"dId\":\""+dish.getDId()+"\",\"dName\":\""+dish.getDName()+"\",\"dDescription\":\""+dish.getDDescription()+"\",\"dImage\":\""+dish.getDImage()+"\"}");
               if(i==dishList.size()-1)
                   out.print("]");
               else
                   out.print(",");
           }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}