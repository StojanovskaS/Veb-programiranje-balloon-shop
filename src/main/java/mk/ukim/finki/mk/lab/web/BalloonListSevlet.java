package mk.ukim.finki.mk.lab.web;

import mk.ukim.finki.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="BalloonListSevlet",urlPatterns = "")
public class BalloonListSevlet extends HttpServlet {
    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonListSevlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req,resp, req.getServletContext());
        webContext.setVariable("lista",balloonService.listAll());
        springTemplateEngine.process("listBalloons.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ballooncolor=(String) req.getParameter("color");
        req.getSession().setAttribute("ballooncolor",ballooncolor);
        resp.sendRedirect("/selectBalloon");
    }
}
