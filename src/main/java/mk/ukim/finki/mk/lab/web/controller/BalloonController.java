package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.*;
//import mk.ukim.finki.mk.lab.model.Orders;
import mk.ukim.finki.mk.lab.service.BalloonService;
import mk.ukim.finki.mk.lab.service.ManufacturerService;
import mk.ukim.finki.mk.lab.service.OrderService;
import mk.ukim.finki.mk.lab.service.UserOrdersService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;

    public BalloonController(BalloonService balloonService,ManufacturerService manufacturerService,OrderService orderService) {
        this.balloonService = balloonService;
        this.manufacturerService=manufacturerService;
        this.orderService=orderService;
    }
    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error,@RequestParam(required = false)String nameSearch,@RequestParam(required = false)String descSearch,Model model){
        if (error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Balloon>najden=new ArrayList<>();

        if (nameSearch !=null || descSearch!=null){
            najden=balloonService.searchByNameOrDescription(nameSearch,descSearch);
        }
        List<Balloon>balloons=this.balloonService.listAll();
        model.addAttribute("lista",balloons);
        model.addAttribute("listB",najden);
        model.addAttribute("bodyContent","listBalloons");

        return  "master-template";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id,Model model){
        if (this.balloonService.findById(id).isPresent()){
            Balloon balloon=this.balloonService.findById(id).get();
            List<Manufacturer>manufacturers=this.manufacturerService.findAll();
            model.addAttribute("balloon",balloon);
            model.addAttribute("manufacturersList",manufacturers);
            model.addAttribute("bodyContent","add-balloon");
            return  "master-template";
        }
        return "redirect:/balloons?error=BalloonNotFound";


    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturersList=this.manufacturerService.findAll();
        model.addAttribute("manufacturersList",manufacturersList);
        model.addAttribute("bodyContent","add-balloon");
        return  "master-template";

    }


    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,@RequestParam String description,
                              @RequestParam Long idmanufacturer){
        this.balloonService.save(name,description,idmanufacturer);
        return "redirect:/balloons";

    }
    @PostMapping("/colourSelect")
    public String saveBalloon(HttpServletRequest req){
        String ballooncolor=(String) req.getParameter("color");
        req.getSession().setAttribute("ballooncolor",ballooncolor);
        return "redirect:/selectBalloon";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";

    }
    @GetMapping("/orders")
    public String getShopingPage(HttpServletRequest request,Model model){
//        User user= (User) request.getSession().getAttribute("user");
        String username=request.getRemoteUser();
//        ShoppingCart orderCard = this.orderService.getActiveUserOrder(username);
        model.addAttribute("orders",this.orderService.findAllOrders(username));
        model.addAttribute("bodyContent","userOrders");
        return  "master-template";
    }

}
