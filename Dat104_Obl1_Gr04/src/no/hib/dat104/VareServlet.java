package no.hib.dat104;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class VareServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    DBKom dbk;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggUtil.isInnlogget(request)) {
        int i = 0;
        Varer v1 = null;
        String vare = request.getParameter("vare");
        if (vare != null && vare != "") {
            vare = vare.replaceAll("<", "&lt");
            vare = vare.replaceAll(">", "&gt");
            vare = vare.replaceAll("\"", "&quot");
            vare = vare.replaceAll("&", "&amp");
            if (!dbk.finnesVare(vare)) {
                v1 = new Varer(vare);
                dbk.leggTilVare(v1);
            }
        }
        String slett = request.getParameter("slett");
        if (slett != null && dbk.finnesVare(slett))
            dbk.slettVare(slett);
    }
        response.sendRedirect("Handle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggUtil.isInnlogget(request)) {
            HttpSession session =request.getSession(false);
            List<Varer> vali = dbk.hliste();
            session.setAttribute("vareliste", vali);
            request.getRequestDispatcher("WEB-INF/handle.jsp").forward(request, response);

        }else
            response.sendRedirect("/lab41/Login");
    }
}
