package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.utils.AlipayTool;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AlipayServlet")
public class AlipayServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("User");
        String uname = user.getUName();
        int price = Integer.parseInt(request.getParameter("price"));
        String pay = AlipayTool.pay(uname+"的购物车", (double) price);
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().write(pay);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}