package no.hib.dat104.controller;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Deltaker;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OversiktServlet extends HttpServlet {
    @EJB
    DBKom dbk;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (dbk.finnesDeltaker((String)session.getAttribute("mobil"))) {
            session.setAttribute("deltakere", dbk.dliste());
            request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
        }else
            response.sendRedirect("Login");
    }
}
