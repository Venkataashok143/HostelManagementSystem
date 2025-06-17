package hostelManagementSystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodaysPayersServlet")
public class TodaysPayersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getSession(false)!= null && request.getSession().getAttribute("username")!= null)
	{
	ArrayList<HostelStudent> res=HostelOwnerServices.TodaysPayersList(request);
	if(res==null)
	{
		res=new ArrayList<>();
	}
		request.setAttribute("Studentslist",res);
		RequestDispatcher rd = request.getRequestDispatcher("TodaysPayersDisplay.jsp");
		rd.forward(request, response);
	}else {
		response.sendRedirect("http://localhost:2324/HostelManagementSystem/OwnerLogin.html");
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
