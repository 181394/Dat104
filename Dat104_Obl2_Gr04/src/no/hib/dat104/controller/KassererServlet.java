package no.hib.dat104.controller;

import no.hib.dat104.model.DBKom;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class KassererServlet extends HttpServlet {
    @EJB
    DBKom dbk;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String passord = getServletContext().getInitParameter("pass");
        String perr;
        if (request.getParameter("pass").equals(passord)) {
            perr = "";
            session.setAttribute("dliste", dbk.dliste());
            session.setAttribute("innlogget", "true");
            session.setMaxInactiveInterval(60);
        } else
            perr = "<font color=\"red\">Feil passord</font>";
        session.setAttribute("perr", perr);
        response.sendRedirect("Kasserer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session != null && session.getAttribute("innlogget") != null)
            request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
        else{
            if (session.getAttribute("perr") == null)
            session.setAttribute("perr", "");
            request.getRequestDispatcher("WEB-INF/kassererlogin.jsp").forward(request, response);
        }
    }
}
