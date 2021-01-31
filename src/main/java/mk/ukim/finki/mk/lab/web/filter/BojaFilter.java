//package mk.ukim.finki.mk.lab.web.filter;
//
//import org.springframework.context.annotation.Profile;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//@Profile("servlet")
//@WebFilter
//public class BojaFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request=(HttpServletRequest) servletRequest;
//        HttpServletResponse response=(HttpServletResponse) servletResponse;
//        String color= (String) request.getSession().getAttribute("ballooncolor");
//        String path=(String) request.getServletPath();
//        if(!path.contains("/balloons") && !"/login".equals(path) && !"/register".equals(path) && color==null){
//            response.sendRedirect("/balloons");
//        }else {
//            filterChain.doFilter(servletRequest,servletResponse);
//
//       }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
