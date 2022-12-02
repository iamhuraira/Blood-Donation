<%@page import="bd.Persondata"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
	<%if(request.getSession(false)==null){
				request.getRequestDispatcher("index.jsp").forward(request,response);
		
				
}
	else {
        String Role = (String)request.getSession(false).getAttribute("role");
        if (!Role.equals("Donor") && !Role.equals("Patient")) {
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
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
    <link rel='stylesheet' href='./style.css'>
    <title>Update</title>
</head>
<%

Persondata p = (Persondata)request.getAttribute("person");
 /* String fname = p.getFirstName();
 String lname = p.getLastName();
 String uname = p.getUserName();
 String pass = p.getPassword();
 String add = p.getAddress();
 String ph = p.getPhone();
 String bg =  p.getBloodGroup();?*/

%>

<body>
    <div class='background'>
        <div class='t-background'>
            <div class='blood'>
                <h1>Blood Donation</h1>
            </div>
            <div class='sign'>
                <h2>Data Update Form</h2>
            </div>
            <form id='form' action='Update1' method='post' name='form'>
                <div class='input-box'>
                    <input type='text' value="<%= p.getFirstName()%>" name='fname' id='fname' class='input' >
                    <div class="error-try"><small>${error.fname}</small></div>
                </div>
                <div class='input-box'>
                    <input type='text' value='<%= p.getLastName() %>' name='lname' id='lname' class='input' >
                    <div class='error-try '><small>${error.lname}</small></div>
                </div>
                
                    
                    
                <div class='input-box'>
                    <input type='text' value='<%= p.getAddress() %>' name='address' id='add' class='input'>
                    <div class='error-try'><small>${error.add}</small></div>
                </div>
                <div class='input-box'>
                    <input type='text' value='<%= p.getPhone() %>' name='phone' id='phone' class='input'>
                    <div class='error-try'><small>${error.ph}</small></div>
                </div>
                <div class='input-box'>

                    <select class='input' id='blood' name='blood'>
                        <option value='<%= p.getBloodGroup() %>'><%= p.getBloodGroup() %></option>
                        <option value='A+'>A+</option>
                        <option value='A-'>A-</option>
                        <option value='B+'>B+</option>
                        <option value='B-'>B-</option>
                        <option value='AB+'>AB+</option>
                        <option value='AB-'>AB-</option>
                        <option value='O+'>O+</option>
                        <option value='O-'>O-</option>
                        <option value='unknown'>Unknown</option>
                    </select>
                    <div class='error-try'><small>${error.bg}</small></div>
                </div>

                <div class='input-box '>
                    <input type='submit' class='input btn1' value='Update'>
                </div>
                <input type='hidden' value='<%= p.getUserName() %>' name='uname'  >
                <input type='hidden' value='<%=p.getPassword() %>' name='pass' id='pass' class='input'>

               
            </form>
        </div>
    </div> 
    <script src='./updateform.js'></script>
</body>

</html>