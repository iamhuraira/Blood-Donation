<%@page import="bd.personInfo"%>
<%@page import="bd.personDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
	<%if(request.getSession(false)==null){
				request.getRequestDispatcher("index.jsp").forward(request,response);
		
				
}
	else {
        String Role = (String)request.getSession(false).getAttribute("role");
        if (!Role.equals("Admin") && !Role.equals("Donor") && !Role.equals("Patient")) {
        	response.sendRedirect("index.jsp");
        	
        }
	}
%>

    <!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <link rel='stylesheet' href='./list.css'>
    <title>List</title>
</head>
<body>

    <section class='background'>
        <div class='blood'>
            <h1>Blood Donation Management System</h1>
            <h4>List Of Related Accounts</h4>
        </div>
        <div class='list'>
            <span class='name a'>Name</span>
            <span class='name b'>Address</span>
            <span class='name c'>Blood Group</span>
            <span class='name d'>Phone#</span>
            <span class='name e'>Role</span>
        </div>
        
    
     <jsp:useBean id="pDA" class="bd.personDAO" scope="page" />

     <%  
     ArrayList per = pDA.Adminview("Patient");
     %>

     <% 
     personInfo person = null;
     for(int i=0; i<per.size(); i++) { 
    	 person = (personInfo)per.get(i); 
    	 String name = person.getFirstName() + " "+person.getLastName();
     %>
        <div class='list a1'>
            <span class='name a'><%= name%></span>
            <span class='name b'><%= person.getAddress() %></span>
            <span class='name c'><%= person.getBloodGroup() %></span>
            <span class='name d'><%= person.getPhoneNumber() %></span>
            <span class='name e' ><%= person.getRole() %></span>
        </div>
        <% 
} // end for 
%> 
        
        
    </section>
</body>
</html>
</body>
</html>