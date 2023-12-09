package cn.edu.cugb.servlet;

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

public class RegisterServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private PrintWriter writer;

    @InjectMocks
    private RegisterServlet registerServlet;
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
        when(request.getParameter("uid")).thenReturn("test");
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getParameter("password")).thenReturn("1234");
        when(request.getParameter("key")).thenReturn("0");
        when(request.getParameter("value")).thenReturn("0313");

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        when(request.getSession()).thenReturn(session);

        // 调用被测试的方法
        registerServlet.doGet(request, response);

        // 验证ServletResponse对象的getWriter方法是否被调用
        verify(response.getWriter()).println("{\"code\":\"0\"}");
    }

//    public void Servlet2Test() throws Exception {
//        // 设置HttpServletRequest对象的参数值
//        when(request.getParameter("uid")).thenReturn("test2");
//        when(request.getParameter("password")).thenReturn("1234");
//        when(request.getParameter("key")).thenReturn("0");
//        when(request.getParameter("value")).thenReturn("0313");
//
//        // 调用被测试的方法
//        loginServlet.doGet(request, response);
//
//        // 验证ServletResponse对象的getWriter方法是否被调用
//        verify(response.getWriter()).println("{\"code\":\"0\"}");
//    }

}
