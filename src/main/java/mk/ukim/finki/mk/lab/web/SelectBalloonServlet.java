package mk.ukim.finki.mk.lab.web;

import mk.ukim.finki.mk.lab.model.Balloon;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectBalloonServlet",urlPatterns = "/selectBalloon1")
public class SelectBalloonServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;


    public SelectBalloonServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req,resp, req.getServletContext());
        springTemplateEngine.process("selectBalloonSize.html",webContext,resp.getWriter());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balloonsize=(String) req.getParameter("size");
        String color=(String) req.getSession().getAttribute("ballooncolor");
        Balloon balloon=new Balloon(color,balloonsize);
        req.getSession().setAttribute("balon",balloon);

        resp.sendRedirect("/BalloonOrder");
    }
}
