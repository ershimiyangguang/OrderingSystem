package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Message;
import cn.edu.cugb.service.DeleteDishByIdService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteDishByIdServlet")
public class DeleteDishByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        DeleteDishByIdService deleteDishByIdService = applicationContext.getBean("DeleteDishByIdService", DeleteDishByIdService.class);

        String did = request.getParameter("did");

        Message message = deleteDishByIdService.deleteDishById(did);

        if(message.getCode()==0){
            out.println("{\"code\":\"0\"}");
        }
        else{
            out.println("{\"code\":\""+message.getCode()+"\",\"reason\":\""+message.getReason()+"\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}