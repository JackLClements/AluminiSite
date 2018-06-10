/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function validateForm()
                {
                    var x=document.forms["registration"]["email"].value;
                    var atpos=x.indexOf("@");
                    var dotpos=x.lastIndexOf(".");
                    var pass1=document.forms["registration"]["password"].value;
                    var pass2=document.forms["registration"]["password2"].value;
                    var dob=document.forms["registration"]["DOB"].value;
                    var atdob=dob.indexOf("/");
                    var dotdob=dob.lastIndexOf("/");
                    var username=document.forms["registration"]["username"].value;
                    var firstName=document.forms["registration"]["firstName"].value;
                    var lastName=document.forms["registration"]["lastName"].value;
                    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
                    {
                        alert("Not a valid e-mail address");
                        return false;
                    }
                    else if (pass1 != pass2)
                    {
                        alert("Passwords must match");
                        return false;
                    }
                    //else if (atdob<1 || dotdob<atdob+4 || dotdob+4>=dob.length)
                    //{
                      //  alert("Date of birth must be in format 'DD/MM/YY'");
                      //  return false;
                    //}
                    else if (username==null || username=="" || firstName==null || firstName=="" || lastName==null || lastName==""){
                        alert("All fields must contain values");
                        return false;
                    }

                }
                
                
