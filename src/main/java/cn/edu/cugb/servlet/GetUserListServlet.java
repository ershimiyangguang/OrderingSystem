package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.GetUserListService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetUserListServlet")
public class GetUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        GetUserListService getUserListService = applicationContext.getBean("GetUserListService", GetUserListService.class);

        int page = Integer.parseInt(request.getParameter("page"));
        if(getUserListService.getUserList(page).size()==0){
            out.println("[]");
        }
        else{
            List<User> userList =  getUserListService.getUserList(page);
            out.print("[");
            for(int i=0;i<userList.size();i++){
                User user = userList.get(i);
                out.print("{\"uname\":\""+user.getUName()+"\",\"upassword\":\""+user.getUPassword()+"\"}");
                if(i==userList.size()-1)
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