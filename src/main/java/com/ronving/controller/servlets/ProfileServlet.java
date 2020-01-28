package com.ronving.controller.servlets;

import com.ronving.model.roles.ROLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "ProfileServlet",
        urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        ROLE role = (ROLE) session.getAttribute("role");
        if (role.equals(ROLE.ADMIN)) {
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
        } else  {
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        }
    }
}
