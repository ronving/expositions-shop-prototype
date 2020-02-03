package com.ronving.controller.servlets;

import com.ronving.dao.impl.SQLDAOFactory;
import com.ronving.model.Account;
import com.ronving.model.Order;
import com.ronving.model.roles.ROLE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "ProfileServlet",
        urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    SQLDAOFactory factory = new SQLDAOFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        ROLE role = (ROLE) session.getAttribute("role");
        if (role.equals(ROLE.ADMIN)) {
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, resp);
        } else  {
            Account account =(Account) session.getAttribute("account");
            List<Order> orders = factory.getOrderDAO().getOrders(account);
            session.setAttribute("orders", orders);
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, resp);
        }
    }
}
