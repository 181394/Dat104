package no.hib.dat104.controller;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Deltaker;
import no.hib.dat104.model.ValideringsUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PaameldingServlet extends HttpServlet {
    @EJB
    DBKom dbk;
    @EJB
    ValideringsUtil valid;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ValideringsUtil valid = new ValideringsUtil(request);

        session.setAttribute("berr", "");
        String mob = request.getParameter("mob");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String kjoen = request.getParameter("kjoen");

        Boolean betalt = false;

        String ferr = "<font color=\"red\">Kan ikke være tomt.</font>";
        String lerr = "<font color=\"red\">Kan ikke være tomt.</font>";
        String merr = "<font color=\"red\">Bruk 8 siffer.</font>";
        String berr = "<font color=\"red\">Tlf allerede i bruk.</font>";

//        if (mob != null && mob.length() == 8 && fname != null && fname.length() > 0 && lname != null && lname.length() > 0) {
        if (valid.erAlleGyldig()){
        if (!dbk.finnesDeltaker(mob)) {
                session.setAttribute("ok", "OK");
                Deltaker d = new Deltaker(mob, fname, lname, kjoen, false);
                dbk.meldPaa(d);
            }else
                session.setAttribute("berr", berr);
        }
        else{
//            if (mob == null || mob.length() != 8) {
            if (valid.erMobUgyldig()){
                session.setAttribute("merr", merr);
                mob = "";
            } else
                session.setAttribute("merr", "");
//            if (fname == null || fname.length() == 0) {
            if (valid.erFnameUgyldig()){
                session.setAttribute("ferr", ferr);
                fname = "";
            } else
                session.setAttribute("ferr", "");
//            if (lname == null || lname.length() == 0) {
                if (valid.erLnameUgyldig()){
                session.setAttribute("lerr", lerr);
                lerr = "";
            }else
                session.setAttribute("lerr", "");
        }

        session.setAttribute("mob", mob);
        session.setAttribute("fname", fname);
        session.setAttribute("lname", lname);
        session.setAttribute("kjoen", kjoen);
        response.sendRedirect("Paamelding");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("ok") != null) {
            request.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(request, response);
        } else {
            if (session.getAttribute("merr") == null)
                session.setAttribute("merr", "");
            if (session.getAttribute("ferr") == null)
                session.setAttribute("ferr", "");
            if (session.getAttribute("lerr") == null)
                session.setAttribute("lerr", "");
            if (session.getAttribute("berr") == null)
                session.setAttribute("berr", "");
            request.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(request, response);
        }
    }
}
