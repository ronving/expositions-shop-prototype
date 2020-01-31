package com.ronving.controller.servlets;

import com.ronving.dao.SQLAccountDAO;
import com.ronving.model.Account;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "DonateServlet",
        urlPatterns = "/donate")
public class DonateServlet extends HttpServlet {
    final static Logger LOGGER = Logger.getLogger(SQLAccountDAO.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (req.getSession().getAttribute("result") != null) {
            req.getSession().removeAttribute("result");
        }
        req.getRequestDispatcher("/WEB-INF/view/donate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();

        SQLAccountDAO dao = new SQLAccountDAO();
        Account account = (Account) session.getAttribute("account");
        int credits = Integer.parseInt(req.getParameter("credits"));

        if (credits <= 0) {
            session.setAttribute("result", "fail");
            req.getRequestDispatcher("/WEB-INF/view/donate.jsp").forward(req, resp);
        } else {

            dao.updateAccount(account, credits);

            account.setBalance(account.getBalance() + credits);
            session.setAttribute("account", account);
            session.setAttribute("result", "success");


            req.getRequestDispatcher("/WEB-INF/view/donate.jsp").forward(req, resp);
        }
        //resp.sendRedirect("calendar/profile");
    }
}
