package cn.edu.cugb.servlet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class DisplayOneDishServletTest {


    @InjectMocks
    private DisplayOneDishServlet displayOneDishServlet;

    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetParameter() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // 设置模拟请求参数
        Mockito.when(request.getParameter("index")).thenReturn("1");
        Mockito.when(response.getWriter()).thenReturn(writer);

        displayOneDishServlet.doGet(request, response);

        // 验证输出是否包含预期的参数值
        String output = stringWriter.toString().trim(); // 假设这是Servlet的输出结果
        String actual = "{\"dId\":\"1\",\"dName\":\"皮蛋瘦肉粥\",\"dDescription\":\"美味可口!\",\"dImage\":\"images/17.jpg\"}";

        Assert.assertEquals(output,actual);
    }

}
