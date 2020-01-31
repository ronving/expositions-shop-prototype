package com.ronving.controller.servlets;

import com.ronving.dao.SQLAccountDAO;
import com.ronving.dao.SQLOrderDAO;
import com.ronving.model.Account;
import com.ronving.model.Hall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "OrderServlet",
        urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SQLAccountDAO accountDAO = new SQLAccountDAO();
        SQLOrderDAO orderDAO = new SQLOrderDAO();

        Account account = (Account) session.getAttribute("account");
        int ticketPrice = ((Hall) session.getAttribute("hall")).getTicketPrice();

        if (session.getAttribute("result") != null) {
            session.removeAttribute("result");
        }
        if (req.getParameter("submit") != null) {
            boolean success = accountDAO.updateAccount(account, -ticketPrice);
            if (success) {
                account.setBalance(account.getBalance() - ticketPrice);
                session.setAttribute("account", account);
                session.setAttribute("result", "success");
            } else {
                session.setAttribute("result", "fail");
            }
        }

        req.getRequestDispatcher("/WEB-INF/view/order.jsp").forward(req, resp);
    }
}
