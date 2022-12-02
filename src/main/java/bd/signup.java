package bd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Pattern;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String blood = request.getParameter("blood");
		String role = request.getParameter("radio1");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
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

		Boolean b = mDao.username(uname2);
		// Validate user Name
		if (uname2 == "") {
			// out.println("<h4 style='color: red; margin-left: 100px;'> User Name is Blank
			// : </h4> ");
			error.put("username", "User Name is Blank :");

		} else if (uname2.contains(" ")) {
			// out.println("<h4 style='color: red; margin-left: 100px;'>Remove Space In
			// Username : </h4> ");
			error.put("username", "Remove Space In Username :");

		} else if (b == true) {
			// out.println("<h4 style='color: red; margin-left: 100px;'>username ( " +
			// uname2
			// + " ) Already Exist, So Choose Another : </h4> ");
			error.put("username", "username Already Exist,Choose Another ");

		}

		else if (uname2.length() > 20) {
			// out.println("<h4 style='color: red; margin-left: 100px;'> User Name is Large
			// : </h4> ");
			error.put("username", "User Name is Large :");

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

		// Conferm Password Validation
		if (cpass == "") {
			// out.println("<h4 style='color: red; margin-left: 100px;'> Conferm Password is
			// Blank : </h4> ");
			error.put("cpass", "Conferm Password is Blank :");
		} else if (!pass.equals(cpass)) {
			// out.println(
			// "<h4 style='color: red; margin-left: 100px;'>Password and Conferm Password
			// can't be Matched : </h4> ");
			error.put("cpass", "Conferm Password can't be Matched :");
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

		if (role == null) {
			// out.println("<h4 style='color: red; margin-left: 100px;'> please Select The
			// Radio Button : </h4> ");
			error.put("radio", "Please Select The Radio Button :");

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

		if (count == 9) {

			// personInfo p1 = new personInfo(fname, lname, uname2, pass, cpass, address,
			// phone, blood, role);
//			 out.println("<h4 style='color: red;  margin-left: 100px;'> "+p1.toString()+":  </h4> ");
//			 

			Boolean p = mDao.signup(fname, lname, uname2, pass, cpass, address, phone, blood, role);

			if (p == true) {
				response.sendRedirect("index.jsp");
			} else {
				response.sendRedirect("signup.jsp");
			}

		} else {
//			out.println("<br>");
//			out.println("<br>");
//			RequestDispatcher rd = request.getRequestDispatcher("/signup.html");
//			rd.include(request, response);

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);

		}

	}

}
