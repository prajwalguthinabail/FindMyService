<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript">
            
            var lat=0;
            var lon=0;
            
            function getLocation() {
                    if (navigator.geolocation) {
                        navigator.geolocation.getCurrentPosition(showPosition);
                    } else {
                        err.innerHTML = "Geolocation is not supported by this browser.";
                    }
                }


                function showPosition(position) {
                    lat = position.coords.latitude;
                    long = position.coords.longitude;
                    console.log(lat);
                    console.log(long);
                }


            function show_value(x)
            {
                document.getElementById("valueHere").textContent = "Search radius " + x+" meters";
            }

            $(document).ready(function () {
                var form = $("#sservice");

                form.submit(function () {
                    localStorage.serviceName = $('#opt').val();
                    localStorage.distance = $("#distance").val();
                    localStorage.lat = lat;
                    localStorage.lon = lon;
                    return true;
                });
            });

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        <h1>Hello Consumer!</h1>-->
        <!--        <h5>Search service</h5>-->
        <form class="alignForm" name="sservice" id="sservice" action="resultPage.jsp" method="POST">
            <select class="selectS" id = "opt" name = "serviceName" >
                <option value = "Z" selected = "selected" disabled>What service are you looking for?</option>
                <option value = "A">Service A</option>
                <option value = "B">Service B</option>
                <option value = "C">Service C</option>
                <option value = "D">Service D</option>
                <option value = "E">Service E</option>
            </select>
            <p class="divText" id = "searchRadius">Select service search distance</p>
            0<input class="divText" type="range" min="0" name="distance" max="5000" value="100" id="distance" step = "10"  onchange="show_value(this.value);" />
            5000 meters<br>
            <p class= "divText" id = "valueHere"></p>
            <input class ="buttonBox" type="submit" id = "sub" value="Submit" >
            <p id="Error"></p>


        </form>
    </body>
</html>
