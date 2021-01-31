package mk.ukim.finki.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ConfirmationInfoServlet",urlPatterns = "/ConfirmationInfo1")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext=new WebContext(req,resp, req.getServletContext());
        webContext.setVariable("adrr",req.getRemoteAddr());
        webContext.setVariable("userA",req.getHeader("User-Agent"));
        springTemplateEngine.process("confirmationInfo.html",webContext,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("/balloons/orders");
    }

}
