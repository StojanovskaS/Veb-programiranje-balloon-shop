package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.Balloon;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller
@RequestMapping("/selectBalloon")
public class SelectBalloonController {

    @GetMapping
    public String GetSelectBalloonPage(Model model){
        model.addAttribute("bodyContent","selectBalloonSize");
        return "master-template";


    }

    @PostMapping
    public String TotheBalloonOrder(HttpServletRequest req, @RequestParam String size){
        String balloonsize=size;
        req.getSession().setAttribute("sizeb",balloonsize);
        String color=(String) req.getSession().getAttribute("ballooncolor");
        Balloon balloon=new Balloon(color,balloonsize);
        req.getSession().setAttribute("balon",balloon);
        return "redirect:/BalloonOrder";
    }
}
