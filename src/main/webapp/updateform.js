const form = document.getElementById('form');
const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const pass = document.getElementById('pass');
const add = document.getElementById('add');
const phone = document.getElementById('phone');
const blood = document.getElementById('blood');



form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    validate();
    if (count==6) {
        event.currentTarget.submit();
    }

})
    // Data Validation Coplete Function
function validate() {
    const fnvalue = fname.value.trim();
    const lnvalue = lname.value.trim();
    const passvalue = pass.value.trim();
    const addvalue = add.value.trim();
    const phonevalue = phone.value.trim();
    const bloodvalue = blood.value;
   
    count=0;
    

    

    


        //Name Validation 
    if (fnvalue == "" ) {
        setErrorMsg(fname, 'Field Can Not Be Blank');
    }
    else if ( fnvalue.length>50  ) {
        setErrorMsg(fname, 'First Name is to Large!');
    }
    else{
           
           success(fname)
           count=count+1;
           
       }
       // lname validation
       if (lnvalue == "" ) {
        setErrorMsg(lname, 'Field Can Not Be Blank');
    }
    else if ( lnvalue.length>50  ) {
        setErrorMsg(lname, 'Last Name is to Large!');
    }
    else{
           
           success(lname)
           count=count+1;
           
       }
      
    // password validation
    if ( passvalue=="" ) {
        setErrorMsg(pass, 'Field Can Not Be Blank');
    }
    else if ( passvalue.length<6 || passvalue.length>15 ) {
        setErrorMsg(pass, 'Between 6 to 15 Character');
    }
    else{
           
           success(pass)
           count=count+1;
       }




       if ( addvalue=="" ) {
        setErrorMsg(add, 'Field Can Not Be Blank!');
    }
    else if ( addvalue.length>50  ) {
        setErrorMsg(add, 'Address is to Large!');
    }
    else{
           
           success(add)
           count=count+1;
       }
        //Phone Number Validation

    let pattern = /[0-9]{4}[-]{1}[0-9]{7}/g;
    if ( phonevalue=="") {
        setErrorMsg(phone, 'Field Can Not Be Blank');
    }
     else if (!phonevalue.match(pattern)) {
        setErrorMsg(phone, 'Example: 0300-1234567');
     }
    else{
           
           success(phone)
           count=count+1;
       }
 

    if ( bloodvalue=="") {
        setErrorMsg(blood, 'Please Select The Blood Group;');
    }
    
    else{
           
           success(blood);
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
    console.log( 'text');
    var parent = input.parentElement;
    // console.log(parent);
    parent.className = " input-box  err";
    var small = parent.querySelector("small");
    small.innerText = errormsgs;
}// end Errormsg

//function For display Success msg 
function success(input){
        let parent = input.parentElement;
        parent.className = " input-box  success";
        
       
}//end success








