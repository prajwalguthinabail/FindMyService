<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css" />
        <title></title>
        <script>

            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(showPosition);
                } else {
                    err.innerHTML = "Geolocation is not supported by this browser.";
                }
            }
            function showPosition(position) {
                lat = document.getElementById("lat");
                    long = document.getElementById("long");
                lat.value = position.coords.latitude;
                long.value = position.coords.longitude;
                
                 document.getElementById("sub").disabled = false;
                //console.log(lat);
                //console.log(long);

            }

            function checkValidation() {
                var txt = document.getElementById("businessName").value;

                if (!/^[A-Za-z\s]+$/.test(txt)) {
                    document.getElementById("errorsHere").textContent = "Name must contain only alphabets.";
                    document.getElementById("sub").disabled = true;
                } else {
                    
                    err = document.getElementById("Error");
                    document.getElementById("errorsHere").textContent = "";
                    if (localStorage.getItem("phone")) {
                        //console.log(localStorage.getItem("phone"));
                        document.getElementById("phone").value = localStorage.getItem("phone");
                    }
                   
                    getLocation();
                    
                }
            }
        </script>

    </head>
    <body>
<!--        <h1>Register your business</h1>-->
        <form class="alignForm" name="register" action="register.ws" method="POST">
            <input class="textBox" type = "text" id = "businessName" name = "name" placeholder="Your Business Name" onblur="checkValidation()"/>
            <p class="fontErr" id = "errorsHere"></p>

            <input  type="hidden" id="lat" name="latitude" value=""/>
            <input  type="hidden" id="long" name="longitude" value=""/>
            <input type="hidden" id="phone" name="phone" value=""/>
            <p class="fontErr" id="Error"></p>

            <input class="buttonBox" type="submit" id = "sub" value="Register" disabled>
        </form>
    </body>
</html>