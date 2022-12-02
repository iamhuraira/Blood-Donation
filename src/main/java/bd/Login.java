package bd;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String role = request.getParameter("radio1");
        

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String uname2 = uname.toLowerCase();
        HashMap<String, String> error = new HashMap<String, String>();
        

        int count = 0;

        // Validate user Name
        if (uname2 == "") {
//            out.println("<h4 style='color: red; margin-left: 100px;'> User Name is Blank : </h4> ");
            error.put("username", "User Name is Blank :");
            

        } else if (uname2.contains(" ")) {
//            out.println("<h4 style='color: red; margin-left: 100px;'>Remove Space In Username  : </h4> ");
            error.put("username", "Remove Space In Username  :");
        }
        
        else if (uname2.length() > 20) {
//            out.println("<h4 style='color: red; margin-left: 100px;'> User Name is Large : </h4> ");
            error.put("username", "User Name is Large : ");
        } 
        else {

            count = count + 1;

        }

        // Validate Password



        if ( pass=="" ) {
//            out.println("<h4 style='color: red; margin-left: 100px;'> Password is Blank : </h4> ");
            error.put("password", "Password is Blank : ");
        }
        else if ( pass.length()<6 || pass.length()>15 ) {
//            out.println("<h4 style='color: red; margin-left: 100px;'>Password Between 8 to 15 Character: </h4> ");
            error.put("password", "Password Between 8 to 15 Character: ");
        }
        else{
               
               count=count+1;
           }
       



           if (role == null){
//            out.println("<h4 style='color: red; margin-left: 100px;'> please Select The Radio Button : </h4> ");
            error.put("role", "please Select The Radio Button : ");
           }
            else{
               
             
             count=count+1;
         }
        
       

        if (count == 3) {
          personDAO dao = new personDAO();
          personInfo p = dao.login(uname2, pass, role);
			/* out.println("<p> "+p.toString()+"</p>"); */
          
          if (p==null) {
        	  error.put("err", "UserName And Password Is Incorrect: ");
        	 // out.println("<h4 style='color: red; margin-left: 100px;'> UserName And Password Is Incorrect: </h4> "); 
//        	  RequestDispatcher rd = request.getRequestDispatcher("index.html");
//              rd.include(request, response);
        	  request.setAttribute("error", error);
              RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
              rd.forward(request, response);
		} else {
			String u = p.getUserName();
			String pas = p.getPassword();
			String r = p.getRole();
			
			
			 HttpSession session=request.getSession();  
             if (r.equals("Admin")) {
               session.setAttribute("role",r);  
               response.sendRedirect("adminHome.jsp");
             }
             else if (r.equals("Donor") || r.equals("Patient")) {
            	 System.out.print("Hello");
               session.setAttribute("role",r);  
               session.setAttribute("uname",u);  
               session.setAttribute("pass",pas);  
               response.sendRedirect("DonorHome.jsp");
             }
		}
            
        } else {
//            out.println("<br>");
//            out.println("<br>");
        	request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        

    }

}
