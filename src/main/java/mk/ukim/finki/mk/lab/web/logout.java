package mk.ukim.finki.mk.lab.web;

import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="logoo",urlPatterns = "/logout1")
public class logout extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public logout(SpringTemplateEngine springTemplateEngine) {

        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/login");
    }
}
