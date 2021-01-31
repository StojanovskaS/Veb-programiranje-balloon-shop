//package mk.ukim.finki.mk.lab.web;
//
//import ch.qos.logback.classic.Logger;
//import mk.ukim.finki.mk.lab.model.Balloon;
//import mk.ukim.finki.mk.lab.model.Order;
////import mk.ukim.finki.mk.lab.model.Orders;
//import mk.ukim.finki.mk.lab.model.ShoppingCart;
//import mk.ukim.finki.mk.lab.service.OrderService;
//import mk.ukim.finki.mk.lab.service.UserOrdersService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import mk.ukim.finki.mk.lab.model.User;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name="BalloonOrderServlet",urlPatterns = "/BalloonOrder1")
//public class BalloonOrderServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final UserOrdersService userOrdersService;
//    private final OrderService orderService;
//
//    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine,UserOrdersService userOrdersService, OrderService orderService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.userOrdersService=userOrdersService;
//        this.orderService=orderService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        WebContext webContext=new WebContext(req,resp, req.getServletContext());
//        springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String clientName=(String) req.getParameter("clientName");
//        String clientAddress=(String) req.getParameter("clientAddress");
//        req.getSession().setAttribute("clientName",clientName);
//
//        req.getSession().setAttribute("clientAddress",clientAddress);
//        Balloon balon= (Balloon) req.getSession().getAttribute("balon");
//        User user1= (User) req.getSession().getAttribute("user");
//        Order order=new Order(balon.getName(),balon.getDescription(),user1);
//        req.getSession().setAttribute("order",order);
////        User user=(User) req.getSession().getAttribute("user");
//        Order nova=orderService.save(balon.getName(),balon.getDescription(),user);
//
//        ShoppingCart orderCard=this.userOrdersService.addProductToOrder(user,nova.getOrderId());
//
//
//        resp.sendRedirect("/ConfirmationInfo");
//    }
//}
