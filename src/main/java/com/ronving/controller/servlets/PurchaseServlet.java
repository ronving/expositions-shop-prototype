package com.ronving.controller.servlets;

import com.ronving.dao.SQLAccountDAO;
import com.ronving.model.Account;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "PurchaseServlet",
        urlPatterns = "/donate")
public class PurchaseServlet extends HttpServlet {
    final static Logger LOGGER = Logger.getLogger(SQLAccountDAO.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/donate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("account");
        int credits =  Integer.parseInt(req.getParameter("credits"));
        SQLAccountDAO dao = new SQLAccountDAO();
        dao.updateAccount(account, credits);
        account.setBalance(account.getBalance()+credits);
        req.getSession().setAttribute("account", account);
        req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req,resp);
    }
}
