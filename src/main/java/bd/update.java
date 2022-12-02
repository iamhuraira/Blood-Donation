package bd;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class update
 */
public class update extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        response.setContentType("text/HTML");
        HttpSession session = request.getSession(false);
        if (session == null) {
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
        } else {
            String Role = (String) session.getAttribute("role");
            if (Role.equals("Admin")) {
                String uname = request.getParameter("uname");
                personDAO pDao = new personDAO();
                Persondata persondata = pDao.update(uname);
                
               
                
                request.setAttribute("person", persondata);
    			RequestDispatcher rd = request.getRequestDispatcher("update1.jsp");
    			rd.forward(request, response);
            }
            else{
                response.sendRedirect("index.jsp");
            }
        }
        
	}
}
                                                                