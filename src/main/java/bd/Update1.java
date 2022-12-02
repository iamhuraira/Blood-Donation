package bd;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.regex.Pattern;


public class Update1 extends HttpServlet {

  // Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    response.setContentType("text/html");

    String fname=request.getParameter("fname");
    String lname=request.getParameter("lname");
    String uname=request.getParameter("uname");
    String pass=request.getParameter("pass");
    String address=request.getParameter("address");
    String phone=request.getParameter("phone");
    String blood=request.getParameter("blood");

   
	String uname2 = uname.toLowerCase();

	personDAO mDao = new personDAO();

	HashMap<String, String> error = new HashMap<String, String>();

	int count = 0;

	// Validate First Name
	if (fname == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> First Name is Blank
		// : </h4> ");
		error.put("fname", "First Name is Blank :");
	} else if (fname.length() > 30) {
		// out.println("<h4 style='color: red; margin-left: 100px;'> First Name is Large
		// : </h4> ");
		error.put("fname", "First Name is Large :");

	} else {
		count = count + 1;

	}

	// Validate Last Name

	if (lname == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Last Name is Blank
		// : </h4> ");
		error.put("lname", "Last Name is Blank :");

	} else if (lname.length() > 30) {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Last Name is Large
		// : </h4> ");
		error.put("lname", "Last Name is Large :");

	} else {

		count = count + 1;

	}


	// Validate Password

	if (pass == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Password is Blank :
		// </h4> ");
		error.put("pass", " Password is Blank :");
	} else if (pass.length() < 6 || pass.length() > 15) {
		// out.println("<h4 style='color: red; margin-left: 100px;'>Password Between 8
		// to 15 Character: </h4> ");
		error.put("pass", "Password Between 8 to 15 Character  :");
	} else {

		count = count + 1;
	}

	

	if (address == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Address is Blank :
		// </h4> ");
		error.put("add", "Address is to Blank :");
	} else if (address.length() > 100) {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Address is to
		// Large! : </h4> ");
		error.put("add", "Address is to Large! :");

	} else {

		count = count + 1;
	}

	if (phone == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Phone Number is
		// Blank : </h4> ");
		error.put("ph", "Phone Number is Blank :");
	} else if (!Pattern.matches("[0-9]{4}[-]{1}[0-9]{7}", phone)) {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Example:
		// 0300-1234567! : </h4> ");
		error.put("ph", "Example: 0300-1234567!  :");

	} else {

		count = count + 1;
	}

	if (blood == "") {
		// out.println("<h4 style='color: red; margin-left: 100px;'> Please Select The
		// Blood Group: </h4> ");
		error.put("bg", "Please Select The Blood Group :");

	}

	else {

		count = count + 1;
	}

	if (count == 6) {

		// personInfo p1 = new personInfo(fname, lname, uname2, pass, cpass, address,
		// phone, blood, role);
//		 out.println("<h4 style='color: red;  margin-left: 100px;'> "+p1.toString()+":  </h4> ");
//		 

		Boolean p = mDao.UpdateinDB(fname, lname, uname2, pass, address, phone, blood);

		if (p == true) {
			HttpSession session = request.getSession(false);
	        String Role = (String) session.getAttribute("role");
	        if (Role.equals("Admin")) {
	          response.sendRedirect("adminHome.jsp");
	        }

	        
	        else if (Role.equals("Patient") || Role.equals("Donor") ){
	          response.sendRedirect("DonorHome.jsp");
	        }
		 else {
			response.sendRedirect("signup.jsp");
		}
	}

	}
	else {
//		out.println("<br>");
//		out.println("<br>");
//		RequestDispatcher rd = request.getRequestDispatcher("/signup.html");
//		rd.include(request, response);

		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher("update1.jsp");
		rd.forward(request, response);

	}

}
}





