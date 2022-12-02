<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>
	<%if(request.getSession(false)==null){
				request.getRequestDispatcher("index.jsp").forward(request,response);
		return;
				
}
	else {
        String Role = (String)request.getSession(false).getAttribute("role");
        if (!Role.equals("Admin")) {
        	response.sendRedirect("index.jsp");
        	
        } 
	}
%>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style1.css">
    <title>Home</title>
</head>
<body>


    <section class="background">
        <div class="blood">
            <h1>Blood Donation Management System</h1>
            <h4 style="color:green;">${error.delete}</h4>
        </div>
        <div class="btns">
        <section class="btn">
              <!--   <button class="button" onclick="window.location.href='./addAccount.jsp'" > Add Account </button> -->
                <a href="./addAccount.jsp"><button class="button" > Add Account </button> </a>
        </section>
        <section class="btn">
                
                   <!--  <button class="button" onclick="window.location.href='./delete.jsp'" > Delete Account </button> -->
                    <a href="./delete.jsp"><button class="button" > lete Account </button> </a>  
               
        </section>
        <section class="btn">
           <!--  <button class="button" onclick="window.location.href='./update.jsp'" > Update Account </button> --> 
             <a href="./update.jsp"><button class="button" > Update Account </button> </a> 
        </section>
    </div>
    <div class="btns">
        <section class="btn">
                <form action="adminview.jsp">
                    <input type="submit" class="button" value="View Admins">    
                </form>
        </section>
        <section class="btn">
                <form action="donorview.jsp" method="get">
                    <input type="submit" class="button" value="View Donors">    
                </form>
        </section>
        <section class="btn">
                <form action="patientview.jsp" method="get">
                    <input type="submit" class="button" value="View Patients">    
                </form>
        </section>
    </div>
    <div class="btns b1">
        <section class="btn ">
                <form action="Logout" method="post">
                    <input type="submit" class="button" value="Logout">    
                </form>
        </section>
    </div>
    </section>
</body>

</html>


