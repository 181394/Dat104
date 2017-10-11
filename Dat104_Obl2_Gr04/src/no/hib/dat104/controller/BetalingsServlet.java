package no.hib.dat104.controller;

import no.hib.dat104.model.DBKom;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BetalingsServlet extends HttpServlet {
    @EJB
    DBKom dbk;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("innlogget") != null) {
            String mob = request.getParameter("mob");
            dbk.betal(mob);
            session.setAttribute("dliste", dbk.dliste());
        }
        response.sendRedirect("Betaling");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("innlogget") != null)
            request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
        else
            response.sendRedirect("Logout");
    }
}
