package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.Balloon;
import mk.ukim.finki.mk.lab.model.Order;
import mk.ukim.finki.mk.lab.model.ShoppingCart;

import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundException;
import mk.ukim.finki.mk.lab.service.OrderService;
import mk.ukim.finki.mk.lab.service.UserOrdersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Controller
@RequestMapping("/BalloonOrder")
public class BalloonOrderController {
    private final UserOrdersService userOrdersService;
    private final OrderService orderService;

    public BalloonOrderController(UserOrdersService userOrdersService, OrderService orderService) {
        this.userOrdersService = userOrdersService;
        this.orderService = orderService;
    }
    @GetMapping
    public String getDeliveryPage(@RequestParam(required = false) String error,HttpServletRequest req, Model model) throws ServletException, IOException {
//        WebContext webContext=new WebContext(req,resp, req.getServletContext());
//        springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("bodyContent","deliveryInfo");
        return "master-template";

    }

    @PostMapping
    public String saveOrder(HttpServletRequest req, @RequestParam String clientName,@RequestParam String clientAddress) throws ServletException, IOException {
        req.getSession().setAttribute("clientName",clientName);
        req.getSession().setAttribute("clientAddress",clientAddress);
        return "redirect:/ConfirmationInfo";

    }
}
