package hostelManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class HostelOwnerServices {
	
	static Connection con;
	 static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HostelManagement", "root", "123456");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 ArrayList<HostelStudent>al = new ArrayList<>();
	 static ArrayList<HostelStudent>TodaysPayers= new ArrayList<>();
	 static boolean checkingValidOwner(HttpServletRequest request)
	{
		 String name = request.getParameter("Username");
		 String password = request.getParameter("Password");
		 try {
		 PreparedStatement ps = con.prepareStatement("select * from owners where username=? and password=?");
		 ps.setString(1,name);
		 ps.setString(2,password);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
			 return true;
		 }
		 ps.close();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return false;
	}
	 
	 static boolean RegisterNewUser(HttpServletRequest request) {
		 String name = request.getParameter("name");
		    String phone = request.getParameter("phone"); 
		    String email = request.getParameter("email");
		    int roomNo = Integer.parseInt(request.getParameter("room_no"));
		    String joiningDate = request.getParameter("joining_date");
		    String aadhar = request.getParameter("aadhar"); 
		    String address = request.getParameter("address");

		    HostelStudent student = new HostelStudent(name, phone, email, roomNo, joiningDate, aadhar, address);
		    return insertingNewUserIntoDataBase(student);
		}
	 	static boolean insertingNewUserIntoDataBase(HostelStudent student){
	 		try {
	 		PreparedStatement ps =con.prepareStatement("INSERT INTO students (name, phone, email, room_no, joining_date, aadhar, address) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getRoomNo());
            ps.setString(5, student.getJoiningDate());
            ps.setString(6, student.getAadharNo());
            ps.setString(7, student.getAddress());

            int result = ps.executeUpdate();
            if(result>=1)
            	return true;
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
		 
	 }
	 	static boolean DeleteStudent(HttpServletRequest request)
	 	{
	 		String aadhar=request.getParameter("aadhar");
	 		try {
	 		PreparedStatement ps = con.prepareStatement("delete from students where aadhar=?");
	 		ps.setString(1, aadhar);
	 		int r =ps.executeUpdate();
	 		if(r>=1)
	 		{
	 			return true;
	 		}
	 		ps.close();
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
			return false;
	 	}
	 	static ArrayList<HostelStudent> TodaysPayersList(HttpServletRequest request)
	 	{
	 		String date=request.getParameter("joining_date");
	 		try {
				PreparedStatement ps = con.prepareStatement("Select * from Students where joining_date=?");
				ps.setString(1, date);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					TodaysPayers.add(new HostelStudent(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)));
				}
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
					e.printStackTrace();
			}
	 		return TodaysPayers;
	 	}
}
