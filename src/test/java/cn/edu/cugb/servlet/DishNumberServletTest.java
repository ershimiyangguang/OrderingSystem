package cn.edu.cugb.servlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DishNumberServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private PrintWriter writer;

    private ByteArrayOutputStream outputStream;

    @InjectMocks
    private DishNumberServlet dishNumberServlet;
    @Before
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Servlet1Test() throws Exception {

        outputStream = new ByteArrayOutputStream();
        writer = new PrintWriter(outputStream,true);

        // 设置模拟的writer对象到response中
        when(response.getWriter()).thenReturn(writer);

        // 调用被测试的方法
        dishNumberServlet.doGet(request, response);

        String output = outputStream.toString().trim();
        String actual = "{\"number\":\"18\"}";

        assertEquals(output, actual);
    }

}
