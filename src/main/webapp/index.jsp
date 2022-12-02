<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Login</title>
</head>

<body class="login">
    <div class="background lg">
        <div class="t-background">
            <div class="blood">
                <h1>Blood Donation</h1>
            </div>
            <div class="sign lg">
                <h2>Login</h2>
                <h4 class="errorlg">${error.err}</h4>
            </div>
            <form id="form" action="Login" method="post" name="form">
            
           
                
                
                <div class="input-box ">
                    <input type="text " placeholder="Username" name="uname" id="uname" class="input"    onkeyup="lower(this.id)">
                    <div class="error-try"><small>${error.username}</small></div>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="pass" id="pass" class="input">
                    <div class="error-try"><small>${error.password}</small></div>
                </div>
               
               

                <div class="input-box ">
                    <input type="radio"  name="radio1" value="Admin"  id="radio" class="input radio" ><span class="small">Admin</span>
                    <input type="radio" name="radio1" value="Donor" class="input radio"><span
                        class="small">Donor</span>
                    <input type="radio" name="radio1" value="Patient" class="input radio"><span
                        class="small">Patient</span>
                       

                    <div class="error-try radio-err "><small>${error.role}</small></div>
                </div>
                <div class="input-box ">
                    <input type="submit" class="input btn1" value="Login">


                </div>

                <p>Do not have account, <a href="./signup.jsp">SignUp</a> Now! </p>
            </form>
        </div>
    </div>

    <script src="./login.js"></script> 
</body>

</html>