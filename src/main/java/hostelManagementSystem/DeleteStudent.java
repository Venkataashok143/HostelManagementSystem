package hostelManagementSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
                boolean isDeleted = HostelOwnerServices.DeleteStudent(request);

                if (isDeleted) {
                    response.getWriter().print("✅ Student Deletion Successful!");
                } else {
                    response.getWriter().print("❌ Error: Student could not be deleted!");
                    response.sendRedirect("DeleteStudent.html");
                }
            } else {
                response.sendRedirect("OwnerLogin.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("❌ Error Occurred: " + e.getMessage());
            response.sendRedirect("OwnerLogin.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}