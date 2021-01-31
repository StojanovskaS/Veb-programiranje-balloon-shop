package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.model.exeptions.InvalidUsercCredentialException;
import mk.ukim.finki.mk.lab.model.exeptions.UserNotFoundException;
import mk.ukim.finki.mk.lab.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class UserLoginController {
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent","login");
        return  "master-template";
    }
    @PostMapping
    public String najava(HttpServletRequest request, Model model){
        User user = null;
        try{
            user = (User) this.userService.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/balloons";
        }
        catch (InvalidUsercCredentialException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            model.addAttribute("bodyContent","login");
            return  "master-template";

        }

    }
}
