package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.Order;
import mk.ukim.finki.mk.lab.service.OrderService;
import mk.ukim.finki.mk.lab.service.UserOrdersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {
    private final OrderService orderService;
    private final UserOrdersService userOrdersService;

    public ConfirmationInfoController(OrderService orderService, UserOrdersService userOrdersService) {
        this.orderService = orderService;
        this.userOrdersService = userOrdersService;
    }

    @GetMapping
    protected String getConfirmationPage(HttpServletRequest req, Model model) throws ServletException, IOException {
        model.addAttribute("adrr",req.getRemoteAddr());
        model.addAttribute("userA",req.getHeader("User-Agent"));
//        String clientName=(String) req.getParameter("clientName");
//        String clientAddress=(String) req.getParameter("clientAddress");
//        req.getSession().setAttribute("clientName",clientName);
//        req.getSession().setAttribute("clientAddress",clientAddress);
        String color=(String)req.getSession().getAttribute("ballooncolor");
        String size=(String)req.getSession().getAttribute("sizeb");
        String clientName=(String)req.getSession().getAttribute("clientName");
        String clientAddress=(String)req.getSession().getAttribute("clientAddress");
        model.addAttribute("clientName", clientName);
        model.addAttribute("clientAddress", clientAddress);
        model.addAttribute("ballooncolor", color);
        model.addAttribute("size", size);
        model.addAttribute("bodyContext", "confirmationInfo");
        model.addAttribute("bodyContent","confirmationInfo");

        return "master-template";

    }

   @PostMapping
    protected String goToPage (HttpServletRequest req,Model model) throws ServletException, IOException {
       String username=req.getRemoteUser();
       String color=(String)req.getSession().getAttribute("ballooncolor");
       String size=(String)req.getSession().getAttribute("sizeb");
       Order nova=orderService.save(color,size,username);
       req.getSession().setAttribute("order",nova);
       this.userOrdersService.addProductToOrder(username,nova.getOrderId());
       return  "redirect:/balloons/orders";


    }
}
