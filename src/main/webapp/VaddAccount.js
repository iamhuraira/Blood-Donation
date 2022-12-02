const form = document.getElementById('form');
const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const uname = document.getElementById('uname');
const pass = document.getElementById('pass');
const cpass = document.getElementById('cpass');
const add = document.getElementById('add');
const phone = document.getElementById('phone');
const blood = document.getElementById('blood');
const radio= document.getElementById('radio');



form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    validate();
    if (count==9) {
        event.currentTarget.submit();
    }

})
    // Data Validation Coplete Function
function validate() {
    const fnvalue = fname.value.trim();
    const lnvalue = lname.value.trim();
    const unvalue = uname.value.trim();
    const passvalue = pass.value.trim();
    const cpassvalue = cpass.value.trim();
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
       if (unvalue == "" ) {
        setErrorMsg(uname, 'Field Can Not Be Blank');
    }
    else if ( unvalue.indexOf(' ') >= 0 ) {
        setErrorMsg(uname, 'Remove Space In User Name!');
    }
    // else if (  loadDoc(uname) == false){
    //     setErrorMsg(uname, 'true!');
    // }
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
        setErrorMsg(pass, 'Between 6 to 15 Character');
    }
    else{
           
           success(pass)
           count=count+1;
       }
   
       // Conferm Password Validation
    if (cpassvalue=="" ) {
        setErrorMsg(cpass, 'Field Can Not Be Blank');
    }
    else if (passvalue!=cpassvalue) {
        setErrorMsg(cpass, 'Confirm Password Not Match');
    }  
    else if ( cpassvalue.length<6 || cpassvalue.length>15 ) {
        setErrorMsg(cpass, 'Between 8 to 15 Character');
    }
    else{
           
           success(cpass)
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
    if (!document.form.radio1[0].checked && !document.form.radio1[1].checked&& !document.form.radio1[2].checked )
       {
        setErrorMsg(radio, 'Please Select The option:');
         
       }
       else{
           
        success(radio);
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








