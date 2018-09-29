<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript">
            $(document).ready(function () {

                document.getElementById("addButton").addEventListener('click', function () {
                    this.disabled = true;
                    var selectElement = document.createElement("select");
                    selectElement.setAttribute("class", "selectS");
                    selectElement.setAttribute("name", "serviceName");
                    selectElement.options[0] = new Option("Select ...", "select", true, false);
                    selectElement.options[0].disabled = true;

                    selectElement.options[1] = new Option("Service A", "A", false, false);
                    selectElement.options[2] = new Option("Service B", "B", false, false);
                    selectElement.options[3] = new Option("Service C", "C", false, false);
                    selectElement.options[4] = new Option("Service D", "D", false, false);
                    selectElement.options[5] = new Option("Service E", "E", false, false);

                    var formElement = document.getElementById("add");
                    formElement.appendChild(document.createElement("br"));
                    formElement.appendChild(selectElement);
                    formElement.appendChild(document.createElement("br"));

                    selectElement.onchange = function () {
                        var selectedService = this.options[this.selectedIndex].firstChild.nodeValue;

                    };


                    var text = document.createElement("textarea");
                    text.setAttribute("class", "textArea");
                    text.setAttribute("name", "description");
                    text.setAttribute("placeholder", "Describe your service...");
                    formElement.appendChild(text);
                    formElement.appendChild(document.createElement("br"));


                    var regButton = document.createElement("input");
                    regButton.setAttribute("type", "submit");
                    regButton.setAttribute("class", "buttonBox");
                    regButton.setAttribute("value", "Register");
                    formElement.appendChild(regButton);
                });


                document.getElementById("removeButton").addEventListener('click', function () {
                    this.disabled = true;
                    var selectElement = document.createElement("select");
                    selectElement.options[0] = new Option("Select ...", "select", true, false);
                    selectElement.options[0].disabled = true;
                    selectElement.setAttribute("class", "selectS");
                    selectElement.setAttribute("name", "serviceName");

                    selectElement.options[1] = new Option("Service A", "A", false, false);
                    selectElement.options[2] = new Option("Service B", "B", false, false);
                    selectElement.options[3] = new Option("Service C", "C", false, false);
                    selectElement.options[4] = new Option("Service D", "D", false, false);
                    selectElement.options[5] = new Option("Service E", "E", false, false);

                    var formElement = document.getElementById("remove");
                    formElement.appendChild(document.createElement("br"));
                    formElement.appendChild(selectElement);
                    formElement.appendChild(document.createElement("br"));


                    selectElement.onchange = function () {
                        var selectedService = this.options[this.selectedIndex].firstChild.nodeValue;

                    };

                    var remButton = document.createElement("input");
                    remButton.setAttribute("type", "submit");
                    remButton.setAttribute("class", "buttonBox");
                    remButton.setAttribute("value", "Remove");
                    formElement.appendChild(remButton);

                });

                function getLocation() {
                    if (navigator.geolocation) {
                        navigator.geolocation.getCurrentPosition(showPosition);
                    } else {
                        err.innerHTML = "Geolocation is not supported by this browser.";
                    }
                }


                function showPosition(position) {
                    lat.value = position.coords.latitude;
                    long.value = position.coords.longitude;
                    console.log(lat);
                    console.log(long);
                }

                var form1 = $("#avail");
                document.getElementById("mycheckbox").addEventListener('change', function () {
                    if (localStorage.getItem("phone")) {
                        //console.log(localStorage.getItem("phone"));
                        document.getElementById("phone1").value = localStorage.getItem("phone");
                    }
                    $.ajax({
                        type: form1.attr('method'),
                        url: form1.attr('action'),
                        data: form1.serialize(),
                        success: function (data) {
                            response = $.parseJSON(data);
                            $("#result").empty().append(response);
                        }
                    });
                    return false;
                });

                var form2 = $("#add");
                form2.submit(function () {
                    if (localStorage.getItem("phone")) {
                        //console.log(localStorage.getItem("phone"));
                        document.getElementById("phone2").value = localStorage.getItem("phone");
                    }
                    $.ajax({
                        type: form2.attr('method'),
                        url: form2.attr('action'),
                        data: form2.serialize(),
                        success: function (data) {
                            response = $.parseJSON(data);
                            $("#result").empty().append(response);
                        }
                    });
                    return false;
                });

                var form3 = $("#remove");
                form3.submit(function () {
                    if (localStorage.getItem("phone")) {
                        //console.log(localStorage.getItem("phone"));
                        document.getElementById("phone3").value = localStorage.getItem("phone");
                    }
                    $.ajax({
                        type: form3.attr('method'),
                        url: form3.attr('action'),
                        data: form3.serialize(),
                        success: function (data) {
                            response = $.parseJSON(data);
                            $("#result").empty().append(response);
                        }
                    });
                    return false;
                });

                var form4 = $("#update");
                form4.submit(function () {
                    lat = document.getElementById("lat");
                    long = document.getElementById("long");
                    err = document.getElementById("Error");
                    getLocation();
                    if (localStorage.getItem("phone")) {
                        //console.log(localStorage.getItem("phone"));
                        document.getElementById("phone4").value = localStorage.getItem("phone");
                    }
                    $.ajax({
                        type: form4.attr('method'),
                        url: form4.attr('action'),
                        data: form4.serialize(),
                        success: function (data) {
                            response = $.parseJSON(data);
                            $("#result").empty().append(response);
                        }
                    });
                    return false;
                });
            });



        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Provider Page</title>
    </head>
    <body>
<br/>
        <!--        <h5>set availability</h5>-->
        <div id="goOnline" class = "container">
            <form class="alignForm" name="avail" id="avail" action="avail.ws" method="POST">
                <label >Availability</label>
                <label class="switch" for="mycheckbox">

                    <input type="checkbox" id="mycheckbox" name="availi" value="true" checked="checked"/>
                    <div class="slider round"></div>
                </label>
                <input type="hidden" id="phone1" name="phone" value=""/>
            </form>

        </div>
<br/>

        <!--        <h5>add service</h5>-->
        <div id="addService">

            <form class="alignForm" name="add" id="add" action="add.ws" method="POST">
                <input class="buttonH" type="button" id="addButton" value="(+) Add service"/>
                <input type="hidden" id="phone2" name="phone" value=""/>
            </form>

        </div>
        <br/>
        <!--        <h5>remove service</h5>-->
        <div id="removeService">
            <form class="alignForm" name="remove" id="remove" action="remove.ws" method="POST">
                <input class="buttonH" type="button" id="removeButton" value="(-) Remove service" />
                <input type="hidden" id="phone3" name="phone" value=""/>
            </form>
        </div>
        <br/>
        <!--        <h5>update location</h5>-->
        <div id="updateLocation">
            <form class="alignForm" name="update" id="update" action="update.ws" method="POST">
                <input  type="hidden" id="lat" name="latitude" value=""/>
                <input  type="hidden" id="long" name="longitude" value=""/>    
                <input class="buttonH" type="submit" value="Update location" name="submit" id="updateButton" />
                <input type="hidden" id="phone4" name="phone" value=""/>
                <p id="Error"></p>
            </form>
        </div>
        <br/>
        <div class="divText" id="result"></div>
    </body>
</html>
