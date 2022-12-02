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
        </div>
        <div class="btns">
       
        <section class="btn">
                
                    <!-- <button class="button" onclick="window.location.href='./SearchBloodGroup.html'" > Search Donors </button> --> 
               <a href="./search.jsp"><button class="button" > Search Donors </button> </a> 
        </section>
        <section class="btn">
            <form action="patientview.jsp" >
                <input type="submit" class="button" value="View Patients">    
            </form>
        </section>
    </div>
    <div class="btns">
        <section class="btn">
                <form action="ClickUpdate" method="post">
                    <input type="submit" class="button" value="Update Account">    
                </form>
        </section>
        <section class="btn">
                <form action="ClickDelete" method="post">
                    <input type="submit" class="button" value="Delete Account">    
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