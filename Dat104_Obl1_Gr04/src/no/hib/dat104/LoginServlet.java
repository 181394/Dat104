package no.hib.dat104;

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
    @EJB
    Boolean bool = true;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passord = getServletContext().getInitParameter("password");
        int tid = Integer.parseInt(getServletContext().getInitParameter("timeout"));
        if (passord.equals(request.getParameter("pass"))) {
            HttpSession session = request.getSession(true);
            session.setAttribute("innloggetBruker", request.getParameter("pass"));
            session.setMaxInactiveInterval(tid);
            session.setAttribute("dbk", dbk);
        }else
            bool = false;
        response.sendRedirect("Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("innloggetBruker") != null)
            response.sendRedirect("/lab41/Handle");
        else if (!bool)
            request.getRequestDispatcher("WEB-INF/index2.jsp").forward(request,response);
        else
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
    }
}
