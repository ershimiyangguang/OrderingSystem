package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IsLoginServlet")
public class IsLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            out.println("{\"code\":\"0\",\"uname\":\""+user.getUName()+"\"}");
        }
        else{
            out.println("{\"code\":\"1\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}