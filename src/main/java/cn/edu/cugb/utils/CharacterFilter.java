package cn.edu.cugb.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //解决POST请求乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码
        response.setContentType("text/html;charset=utf-8");
        //解决get乱码
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest,response);

    }

    @Override
    public void destroy() {

    }
    class CharacterRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public CharacterRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        //增强原来的方法，在里面修改编码方式
        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if(value == null){
                return null;
            }else{
                String method = request.getMethod();
                if("get".equalsIgnoreCase(method)){
                    try{
                        value = new String(value.getBytes("iso-8859-1"),"utf-8") ;
                    }catch(UnsupportedEncodingException e){
                        throw new RuntimeException(e);
                    }
                }
            }
            return value;
        }
    }
}


