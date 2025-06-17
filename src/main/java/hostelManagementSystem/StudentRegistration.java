package hostelManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
		if(request.getSession(false) != null && request.getSession().getAttribute("username") != null)
		{
		if(HostelOwnerServices.RegisterNewUser(request))
		{
			response.setContentType("text/html");
			//out.print("<Style> h1{color:blue,background-color:green</style>");
			response.getWriter().print("<h1>Student Added Successfully</h1>");
		}else {
			response.getWriter().print("Cannot be added");
			response.sendRedirect("StudentRegistration.html");
		}
		}else{
			response.sendRedirect("OwnerLogin.html");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
