package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.enumerations.Role;
import mk.ukim.finki.mk.lab.model.exeptions.InvalidUsercCredentialException;
import mk.ukim.finki.mk.lab.model.exeptions.PasswordsdoNootMatchException;
import mk.ukim.finki.mk.lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.InvalidClassException;
@Controller
@RequestMapping("/register")
public class UserRegister {
    public final UserService authenticationService;

    public UserRegister(UserService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required =false)String error, Model model){
        if (error!= null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);

        }
        model.addAttribute("bodyContent","register");
        return "master-template";
    }
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String email,
                           @RequestParam Role role){
        try{
            this.authenticationService.register(username,password,repeatedPassword,email,role);
            return "redirect:/login";

        }catch (InvalidUsercCredentialException | PasswordsdoNootMatchException exception){
            return "redirect:/register?error="+exception.getMessage();
        }

    }
}
