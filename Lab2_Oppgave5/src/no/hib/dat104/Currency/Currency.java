package no.hib.dat104.Currency;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Currency
 */
@WebServlet("/Currency")
public class Currency extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Double value = (double) Integer.parseInt(request.getParameter("value"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		ExchangeRate conv = ExchangeRateService.getRate(from, to);
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + value + " " + from + "</p>");
		out.println("<p>Equals " + value * conv.rate + " " + to + "</p>");
		out.println("<button onclick = 'location.href = \"/Lab25\"'>Konverter igjen</button>");
		out.println("</body>");
		out.println("</html>");
	}
}

