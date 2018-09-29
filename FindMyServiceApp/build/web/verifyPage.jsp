<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>Provider Home</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script>
            function checkValidation() {
                var txt = document.getElementById("phoneNumber").value;
                if (!isNumeric(txt) || (txt.length != 10)) {
                    document.getElementById("errorsHere").textContent = "Enter a valid phone number (10 digits)";
                    document.getElementById("sub").disabled = true;

                } else {
                    document.getElementById("errorsHere").textContent = "";
                    localStorage.setItem("phone", txt);
                    document.getElementById("sub").disabled = false;
                }
            }

            function isNumeric(n) {
                return !isNaN(parseFloat(n)) && isFinite(n);
            }


        </script>
    </head>
    <body>
<!--        <h1>Verify your registration</h1>-->
        <form class="alignForm" name="verify" action="verify.ws" method="GET">
            <input class = "textBox" type = "text" id = "phoneNumber" name = "phone" placeholder="Enter Phone Number" onblur="checkValidation()"/>
            <p class="fontErr" id = "errorsHere"></p>
            <input class="buttonBox" type="submit" id = "sub" value="Go" disabled>


        </form>
    </body>
</html>
