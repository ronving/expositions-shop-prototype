package com.ronving.controller.filters;

import com.ronving.dao.SQLAccountDAO;
import com.ronving.model.Account;
import com.ronving.model.roles.ROLE;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        final HttpSession session = req.getSession();

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked") final AtomicReference<SQLAccountDAO> dao = (AtomicReference<SQLAccountDAO>) req.getServletContext().getAttribute("dao");

        //Set locale for session
        if (req.getParameter("lang") != null) {
            session.setAttribute("lang", req.getParameter("lang"));
        }

        //If user logged out
        if (!nonNull(session)) {
            res.sendRedirect("/calendar/logout");
        }

        //Logged user.
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final ROLE role = (ROLE) session.getAttribute("role");
            res.sendRedirect("/calendar/profile");

        } else if (dao.get().accountIsExist(login, password)) {

            Account account = dao.get().getAccountByLoginPassword(login, password);
            final ROLE role = dao.get().getRoleByLogin(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("account", account);
            res.sendRedirect("/calendar/profile");

        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {
    }

}
