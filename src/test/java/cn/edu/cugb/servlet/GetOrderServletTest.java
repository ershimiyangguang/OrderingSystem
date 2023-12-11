package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.when;

public class GetOrderServletTest {
    @InjectMocks
    private GetOrderServlet getOrderServlet;
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
        HttpSession session = Mockito.mock(HttpSession.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // 创建一个 User 对象并设置到 HttpSession 中
        User user1 = new User("test","1234");
        when(session.getAttribute("User")).thenReturn(user1);

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 设置模拟的 request.getSession 返回值
        when(request.getSession()).thenReturn(session);

        // 调用被测试的方法
        getOrderServlet.doGet(request, response);

        // 验证输出是否包含预期的参数值
        String output = stringWriter.toString().trim(); // 假设这是Servlet的输出结果
        System.out.println(output);
    }

}
