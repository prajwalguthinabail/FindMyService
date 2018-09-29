<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <style>
            #map {
                width: 50%;
                height: 200px;
                background-color: #f1f2f3;
                margin-left: 25%;
            }
        </style>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD0Hg-nPxktypJxNOL1dallqmNdKbG2_-o">
        </script>
        <script type="text/javascript">
            var serviceName = localStorage.serviceName;
            var distance = localStorage.distance;
            var map;
            var lat = localStorage.lat;
            var lon = localStorage.lon;

            $(document).ready(
                    //  getLocation();
                    $.ajax({
                        type: "POST",
                        url: "${pageContext.request.contextPath}/request.ws",
                        data: {serviceName: serviceName, distance: distance, longitude: lon, latitude: lat},
                        success: function (data) {
                            response = $.parseJSON(data);
                            for (var i = 0; i < response.length; i++) {

                                var res = document.createElement("P");
                                res.setAttribute("class", "fontRes");
                                res.setAttribute("id", "data");
                                res.setAttribute("data-name", response[i].name);
                                res.setAttribute("data-phone", response[i].phoneNo);
                                res.setAttribute("data-latitude", response[i].latitude);
                                res.setAttribute("data-longitude", response[i].longitude);
                                res.setAttribute("data-service", response[i].service);
                                res.setAttribute("data-description", response[i].description);
                                res.textContent = '+\t' + response[i].name;
                                $(res).on("click", function () {
                                    if (this.childNodes.length > 1) {
                                        this.removeChild(this.lastChild);
                                        this.textContent = '+\t' + this.getAttribute("data-name");
                                    } else {
                                        this.textContent = '-\t' + this.getAttribute("data-name");
                                        var new_div = document.createElement('div');
                                        new_div.setAttribute("border", "10px solid black");
                                        new_div.setAttribute("class", "plain_div");
                                        var p_phone = document.createElement("P");
                                        p_phone.textContent = 'Contact:\t' + this.getAttribute("data-phone");
                                        var p_desc = document.createElement("P");
                                        p_desc.textContent = 'Our Service:\t' + this.getAttribute("data-description");
                                        new_div.appendChild(p_phone);
                                        new_div.appendChild(p_desc);
                                        this.appendChild(new_div);

                                        var map_div = document.createElement('div');
                                        map_div.setAttribute("id", "map");
                                        new_div.appendChild(map_div);
//                                        show();

                                           getLocation();

//                                        showOnMap(43.143023, -77.526637, 1, "Provider");

                                        //console.log(this.getAttribute("data-latitude"));
//                                        showOnMap(this.getAttribute("data-latitude"), this.getAttribute("data-longitude"), 1, "Provider");
                                    }
                                });
                                $('#results').append(res);

                            }

                        }
                    }));



            function showOnMap(latMark, lonMark, flag, label) {
                console.log("lol", latMark, lonMark);

                var xyCoords = {lat: parseFloat(latMark), lng: parseFloat(lonMark)};

                if (flag == 1) {
                    var image = 'http://maps.google.com/mapfiles/ms/icons/blue-pushpin.png';
                }
                var marker = new google.maps.Marker({
                    position: xyCoords,
                    map: map,
                    icon: image,
                    label: label
                });
            }

            function getMap(position) {
                lat = position.coords.latitude;
                lon = position.coords.longitude;
//            }
//
//            function show() {
                var xyCoords = {lat: lat, lng: lon};
                map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 14,
                    center: xyCoords
                });
                showOnMap(lat, lon, 0, "Your location");
                var s = document.getElementById("data");

                //alert(lat);
                console.log(s.getAttribute("data-latitude"));
                showOnMap(s.getAttribute("data-latitude"), s.getAttribute("data-longitude"), 1, "Provider");

            }


            function getLocation() {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(getMap);
                } else {
                    document.getElementById("results").innerHTML = "Geolocation is not supported by this browser.";
                }
            }


        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="headingF">Services</h1>
        <div class="alignForm" id="results"></div>
    </body>
</html>
