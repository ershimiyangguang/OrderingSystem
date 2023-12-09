package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IsLoginServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private PrintWriter writer;

    @InjectMocks
    private IsLoginServlet isLoginServlet;
    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Servlet1Test() throws Exception {
        // 设置HttpServletRequest对象的参数值
        when(request.getParameter("uname")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("1234");

        // 创建一个 User 对象并设置到 HttpSession 中
        User user1 = new User("test","1234");
        when(session.getAttribute("User")).thenReturn(user1);

        // 设置模拟的 request.getSession 返回值
        when(request.getSession()).thenReturn(session);

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 调用被测试的方法
        isLoginServlet.doGet(request, response);

        // 验证ServletResponse对象的getWriter方法是否被调用
        verify(writer).println("{\"code\":\"0\",\"uname\":\"test\"}");
    }

}
