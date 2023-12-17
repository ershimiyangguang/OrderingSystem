package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IsAdminLoginServlet")
public class IsAdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        Admin admin = (Admin) request.getSession().getAttribute("Admin");

        if(admin!=null){
            out.println("{\"code\":\"0\",\"aname\":\""+admin.getAName()+"\"}");
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