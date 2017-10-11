package no.hib.dat104.LoginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = request.getRequestURL().toString();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>logget inn</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Login Result</h1>\r\n" +
				"<p>Logged in from: <span style = \"color:red;\">" + url +"</span></p>"+
				"<p>Username: <span style = \"color:red;\">" + username +"</span></p>"+
				"<p>Password: <span style = \"color:red;\">" + password +"</span></p>"+
				"</body>\r\n" + 
				"</html>");
	}

}
