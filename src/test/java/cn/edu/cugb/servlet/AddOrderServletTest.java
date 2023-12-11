package cn.edu.cugb.servlet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddOrderServletTest {

    @InjectMocks
    private AddOrderServlet addOrderServlet;
    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Servlet1Test() throws Exception {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // 设置HttpServletRequest对象的参数值
        when(request.getParameter("uname")).thenReturn("test");
        when(request.getParameter("did")).thenReturn("3");
        when(request.getParameter("count")).thenReturn("5");

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 调用被测试的方法
        addOrderServlet.doGet(request, response);

        // 验证输出是否包含预期的参数值
        String output = stringWriter.toString().trim(); // 假设这是Servlet的输出结果
        String actual = "{\"code\":\"0\"}";

        Assert.assertEquals(output,actual);
    }

    @Test
    public void Servlet2Test() throws Exception {

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // 设置HttpServletRequest对象的参数值
        when(request.getParameter("uname")).thenReturn("test");
        when(request.getParameter("did")).thenReturn("3");
        when(request.getParameter("count")).thenReturn("5");

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 调用被测试的方法
        addOrderServlet.doGet(request, response);

        // 验证输出是否包含预期的参数值
        String output = stringWriter.toString().trim(); // 假设这是Servlet的输出结果
        String actual = "{\"code\":\"1\"}";

        Assert.assertEquals(output,actual);
    }

}
