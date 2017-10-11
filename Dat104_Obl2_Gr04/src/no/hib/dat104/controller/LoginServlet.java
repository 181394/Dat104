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


public class LoginServlet extends HttpServlet {
    @EJB
    DBKom dbk;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Deltaker deltaker = null;
        String merr;
        String mob = request.getParameter("mob");
        session.setAttribute("mobil", mob);
        if (mob.length() != 8)
            merr = "<font color=\"red\">Ugyldig input, må være 8 siffer</font>";
        else if (dbk.finnesDeltaker(mob)) {
            merr = "";
            deltaker = dbk.finnDeltaker(mob);
            session.setAttribute("fname", deltaker.getFname());
            session.setAttribute("lname", deltaker.getLname());
            session.setAttribute("kjoen", deltaker.getKjoen());
            session.setAttribute("betalt", deltaker.getBetalt());
        } else
            merr = "<font color=\"red\">Bruker er ikke påmeldt</font>";
        session.setAttribute("merrr", merr);
        response.sendRedirect("Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("innloggetBruker") != null || (session.getAttribute("mobil") != null && dbk.finnesDeltaker((String) session.getAttribute("mobil"))))
            response.sendRedirect("Oversikt");
        else {
            if (session.getAttribute("mobil") == null) {
                session.setAttribute("mobil", "");
                session.setAttribute("merrr", "");
            }
            request.getRequestDispatcher("WEB-INF/mobillogin.jsp").forward(request, response);
        }
    }
}
