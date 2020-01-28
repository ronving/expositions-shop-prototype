package com.ronving.controller.servlets;

import com.ronving.dao.SQLHallDAO;
import com.ronving.model.Hall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "ExpositionServlet",
        urlPatterns = "/exposition")
public class ExpositionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        SQLHallDAO dao = new SQLHallDAO();

        int page = 1;
        int recordsPerPage = 4;
        int numOfPages =  (int) Math.ceil(dao.countRecords() * 1.0 / recordsPerPage);

        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }

        List<Hall> halls = dao.findAll((page-1)*recordsPerPage, recordsPerPage);

        session.setAttribute("halls", halls);
        session.setAttribute("pages", numOfPages);
        session.setAttribute("currentPage", page);
        req.getRequestDispatcher("/WEB-INF/view/halls.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
