<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
	<%if(request.getSession(false)==null){
				request.getRequestDispatcher("index.jsp").forward(request,response);
		
				
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
    <title>Update</title>
    <style>
        *{
    padding: 0%;
    margin: 0%;
    
}
body{
    margin-top: 200px;
   
}

.background{
    text-align: center;
    width: 50%;
    height: 30%;
    margin: auto;
    box-shadow: 3px 3px 30px 8px #000000;
    padding: 30px 0;
    border-radius: 20px;
    padding-bottom: 60px;
    
}

.blood{
    
    line-height: 50px;
    font-size: 30px;
    color: #FF0000;
    margin-bottom: 20px;
}
h4{
    color: black;
    font-family: 'Operator Mono';
}
.input-box{
    margin-bottom: 8px;
    height: 60px;

}
.input-box .input{
    width: 300px;
    height: 40px;
    border-style: none;
    background: #FFFFFF;
    box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.8);
    border-radius: 8px;
    font-size: 20px;
    padding-left: 18px ;
}
.input-box  .small{
    font-size: 25px;
    
}
/* Error  Pringting  by adding class err */

.input-box.err .input{
    border: 2px solid red;
 }
 
 .input-box.err  .error-try{
 
     width: 280px;
    padding-bottom: 1px;
     margin-left: 336px;
     box-shadow:  0px 1px 1px 0px  #000000;
     border-radius: 0px 0px 5px 5px;
     
     
     
 }

 .input-box.err  .error-try small{
 
     color: #FF0000;
     font-size: 12px;
     font-family: 'Operator Mono';
 
     
     
 }

 /* Success class by adding success */

 .input-box.success .input{
    border: 2px solid green;
 }
 .input-box.success  .error-try small{
 
    display: none;


    
    
}
.btn{
    margin-top: 20px;
    width: 150px;
    font-size: 25px;
    font-family: 'Operator Mono';
    background-color:transparent;
    color: red;
    font-weight: bolder;
    cursor: pointer;
    padding-right: 20px;
    border-radius: 10px;
    border: 2px solid red;
    margin-left: 20px;
    height: 40px;
    
}
 .btn:hover{
   
    width: 150px;
    background-color:red;
    color: floralwhite;
    cursor: pointer;
}
 .btn:active{ 
    width: 150px;
   
    color: white;
    font-weight: bolder;
    cursor: pointer;
    box-shadow: inset 1px 1px 5px 0px black;
    border: 0px solid red;
    
}



    </style>
</head>
<body>
     <section class="background">
        <div class="blood">
            <h1>Blood Donation Management System</h1>
            <h4>Deletion Of Account:</h4>
            <h4 style="color:red;">${error.Account}</h4>
            
        </div>
        <div class="list ">
            <form action="delete" method="post" id="form">
                <div class="input-box">
                    <input type="text " placeholder="Username" name="uname" id="uname" class="input"    onkeyup="lower(this.id)">
                    <div class="error-try"><small></small></div>
                </div>
            <input type="submit" class="btn" value="Delete">
            </form>
        </div>

        <script>
const form = document.getElementById('form');
const uname = document.getElementById('uname');




form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    validate();
    if (count==1) {
        event.currentTarget.submit();
    }

})
    // Data Validation Coplete Function
function validate() {
    
    const unvalue = uname.value.trim();
   
    
   
    count=0;
    

       if (unvalue == "" ) {
        setErrorMsg(uname, 'Field Can Not Be Blank');
    }
    else if ( unvalue.length>15  ) {
        setErrorMsg(uname, 'Username is to Large!');
    }
    else{
           
           success(uname)
           count=count+1;
           
       }




  

    
    
   


}//End Validate Function


 // Function For Convert mail upper Case to lower Case
function lower(x){
   var v= document.getElementById(x).value;
   document.getElementById(x).value = v.toLowerCase()
}//end Lower
// Function for Display Error 
function setErrorMsg(input, errormsgs) {
    var parent = input.parentElement;
    // console.log(parent);
    parent.className = " input-box  err";
    var small = parent.querySelector("small");
    small.innerText = errormsgs;
}// end Errormsg

//function For display Success msg 
function success(input){
        var parent = input.parentElement;
        parent.className = " input-box  success";
        
       
}//end success

        </script>
</body>
</html>
    