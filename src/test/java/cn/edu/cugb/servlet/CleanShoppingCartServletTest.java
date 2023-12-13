package cn.edu.cugb.servlet;

import cn.edu.cugb.bean.User;
import cn.edu.cugb.service.CleanShoppingCartService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.when;

public class CleanShoppingCartServletTest {

    @InjectMocks
    private CleanShoppingCartServlet cleanShoppingCartServlet;
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
        User user1 = new User("test", "1234");
        when(session.getAttribute("User")).thenReturn(user1);

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 设置模拟的 request.getSession 返回值
        when(request.getSession()).thenReturn(session);

        // 创建模拟的ServletContext和ClassPathXmlApplicationContext对象
        ServletContext servletContext = Mockito.mock(ServletContext.class);
        ClassPathXmlApplicationContext applicationContext = Mockito.mock(ClassPathXmlApplicationContext.class);

        // 将模拟的ServletContext设置为request的ServletContext
        when(request.getServletContext()).thenReturn(servletContext);

        // 将模拟的ClassPathXmlApplicationContext设置为ServletContext的属性
        when(servletContext.getAttribute("applicationContext")).thenReturn(applicationContext);

        // 创建模拟的CleanShoppingCartService对象
        CleanShoppingCartService cleanShoppingCartService = Mockito.mock(CleanShoppingCartService.class);

        // 设置模拟的ApplicationContext的getBean方法返回模拟的CleanShoppingCartService对象
        when(applicationContext.getBean("CleanShoppingCartService", CleanShoppingCartService.class)).thenReturn(cleanShoppingCartService);


        cleanShoppingCartServlet.doGet(request, response);

        // 验证输出是否包含预期的参数值
        String output = stringWriter.toString().trim(); // 假设这是Servlet的输出结果
        System.out.println(output);
    }
}
