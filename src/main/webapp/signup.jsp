
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>SignUp</title>
</head>

<body>
    <div class="background">
        <div class="t-background">
            <div class="blood">
                <h1>Blood Donation</h1>
            </div>
            <div class="sign">
                <h2>SignUp</h2>
            </div>
            <form id="form" action="signup" method="post" name="form">
                <div class="input-box ">
                    <input type="text " placeholder="First Name" name="fname" id="fname" class=" input" >
                    <div class="error-try"><small>${error.fname}</small></div>
                </div>
                <div class="input-box ">
                    <input type="text " placeholder="Last Name" name="lname" id="lname" class="input ">
                    <div class=" error-try "><small>${error.lname}</small></div>
                </div>
                <div class="input-box ">
                    <input type="text " placeholder="Username" name="uname" id="uname" class="input"  onkeyup="lower(this.id)" >
                    <div class="error-try"><small>${error.username}</small></div>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Password" name="pass" id="pass" class="input">
                    <div class="error-try"><small>${error.pass}</small></div>
                </div>
                <div class="input-box">
                    <input type="password" placeholder="Confirm Password" name="cpass" id="cpass" class="input ">
                    <div class="error-try"><small>${error.cpass}</small></div>
                </div>
                <div class="input-box">
                    <input type="text " placeholder="Address" name="address" id="add" class="input ">
                    <div class="error-try"><small>${error.add}</small></div>
                </div>
                <div class="input-box">
                    <input type="text " placeholder="Phone Number" name="phone" id="phone" class="input ">
                    <div class="error-try"><small>${error.ph}</small></div>
                </div>
                <div class="input-box">

                    <select class="input" id="blood" name="blood">
                        <option value="">Select Blood Group</option>
                        <option value="A+">A+</option>
                        <option value="A-">A-</option>
                        <option value="B+">B+</option>
                        <option value="B-">B-</option>
                        <option value="AB+">AB+</option>
                        <option value="AB-">AB-</option>
                        <option value="O+">O+</option>
                        <option value="O-">O-</option>
                        <option value="unknown">Unknown</option>
                    </select>
                    <div class="error-try"><small>${error.bg}</small></div>
                </div>

                <div class="input-box " >
                    <!-- <input type="radio"  name="radio1" value="Admin" class="input radio" ><small class="small">Admin</small> -->
                    <input type="radio" name="radio1" value="Donor" id="radio"  class="input radio" ><span
                        class="small">Donor</span>
                    <input type="radio" name="radio1" value="Patient"  class="input radio"><span
                        class="small">Patient</span>
                       

                    <div class="error-try radio-err "><small >${error.radio}</small></div>
                </div>
                <div class="input-box ">
                    <input type="submit" class="input btn1" value="SignUp">


                </div>

                <p>Have an Account, <a href="./login.html">Login</a> Now!</p>
            </form>
        </div>
    </div> 
    <script src="./signup.js"></script>
</body>

</html>