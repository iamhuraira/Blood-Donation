package bd;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;



public class ClickDelete extends HttpServlet {
  
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
    if (Role.equals("Patient") || Role.equals("Donor") )  {
       
        String usernam = (String) session.getAttribute("uname");
        String passw = (String) session.getAttribute("pass");
        
        personDAO mDao = new personDAO();
        Boolean p = mDao.deleteuser(usernam,passw);
       

      if (p==true) {
    	  session.invalidate();
        response.sendRedirect("index.jsp");
      
    } 

  }
    
    
    


  }

}
}

