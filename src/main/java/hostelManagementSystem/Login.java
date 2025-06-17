package hostelManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		if(HostelOwnerServices.checkingValidOwner(request))
		{
			HttpSession session =request.getSession();
			session.setAttribute("username",request.getParameter("Username"));
			session.setAttribute("Password",request.getParameter("Password"));
			response.sendRedirect("HostelHome.html");
		}else {
			response.sendRedirect("OwnerLogin.html");
		}
	}



}
