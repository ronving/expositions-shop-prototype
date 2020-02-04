package com.ronving.controller.servlets;

import com.ronving.dao.impl.SQLDAOFactory;
import com.ronving.dao.impl.SQLExpositionDAO;
import com.ronving.dao.impl.SQLHallDAO;
import com.ronving.model.Exposition;
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
        name = "HallServlet",
        urlPatterns = "/hall")
public class HallServlet extends HttpServlet {
    private static SQLDAOFactory factory = new SQLDAOFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SQLHallDAO dao = factory.getHallDAO();
        Hall hall = null;

        if (req.getParameter("id") != null) {
            hall = dao.findHallById(Integer.parseInt(req.getParameter("id")));
            session.setAttribute("hall", hall);
        }


        req.getRequestDispatcher("/WEB-INF/view/details.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SQLHallDAO hallDAO = factory.getHallDAO();
        SQLExpositionDAO expositionDAO= factory.getExpositionDAO();
        List<Exposition> expositions = null;
        Hall hall = null;

        if (req.getParameter("id") != null) {
            hall = hallDAO.findHallById(Integer.parseInt(req.getParameter("id")));
            expositions = expositionDAO.findExpositionsByHall(hall.getId());
            session.setAttribute("hall", hall);
            session.setAttribute("expositions", expositions);
        }


        req.getRequestDispatcher("/WEB-INF/view/details.jsp").forward(req, resp);
    }

}
