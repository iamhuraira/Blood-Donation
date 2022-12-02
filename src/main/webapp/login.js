const form = document.getElementById('form');
const uname = document.getElementById('uname');
const pass = document.getElementById('pass');
const radio= document.getElementById('radio');



form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    validate();
    if (count==3) {
        event.currentTarget.submit();
    }

})
    // Data Validation Coplete Function
function validate() {
    
    const unvalue = uname.value.trim();
    const passvalue = pass.value.trim();
    
   
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
    
    // password validation
    if ( passvalue=="" ) {
        setErrorMsg(pass, 'Field Can Not Be Blank');
    }
    else if ( passvalue.length<6 || passvalue.length>15 ) {
        setErrorMsg(pass, 'Between 8 to 15 Character');
    }
    else{
           
           success(pass)
           count=count+1;
       }
   




    if (!document.form.radio1[0].checked && !document.form.radio1[1].checked && !document.form.radio1[2].checked )
       {
        setErrorMsg(radio, 'Please Select The option:');
         
       }
       else{
           
        success(radio);
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




