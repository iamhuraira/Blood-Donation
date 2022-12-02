package bd;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;



public class delete extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
	HttpSession session=request.getSession(false); 
  if(session==null){
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
  }
  else{

    String Role=(String)session.getAttribute("role"); 
    if (Role.equals("Admin")) {
        String uname=request.getParameter("uname");
       
        personDAO mDao = new personDAO();

		HashMap<String, String> error = new HashMap<String, String>();
		Boolean p = mDao.delete(uname);
		error.put("delete", "Account Has Been Deleted!");
		error.put("Account", "Account Not Found!");

		if (p == true) {
			
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
			
		}

    }
    else{
        response.sendRedirect("login.html");
    }

  }
    
    
    


  }

}

