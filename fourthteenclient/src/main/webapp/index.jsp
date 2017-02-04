<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>This is bankapp client</h1>
    <span id="ajaxButton1" style="cursor: pointer; text-decoration: underline">
      Get All depsoits
    </span>
    <input type="text" id="deposit-id">
    <span id="ajaxButton2" style="cursor: pointer; text-decoration: underline">
      Get All depsoits
    </span>
    <script>
        (function(){
            var httpRequest;
            document.getElementById("ajaxButton1").onclick = function () {
                makeRequest("http://localhost:8081/fixedDeposits");
            };

            document.getElementById("ajaxButton2").onclick = function () {
                var id = document.getElementById("deposit-id").value;
                makeRequest("http://localhost:8081/fixedDeposits/" + id);
            };

            function makeRequest(url) {
                httpRequest = new XMLHttpRequest();
                if(!httpRequest) {
                    console.log("Cannot create an XMLHTTP instance");
                    return false;
                }
                httpRequest.onreadystatechange = alertContents;
                httpRequest.open("GET", url);
                httpRequest.setRequestHeader("Accept", "application/json")
                httpRequest.send();
            }

            function alertContents() {
                var response = "";
                if(httpRequest.readyState == XMLHttpRequest.DONE) {
                    if(httpRequest.status == 200) {
                        response = JSON.parse(httpRequest.responseText);
                        console.log(response);
                    } else {
                        console.log("There was a problem.");
                    }
                }
            }
        })();
    </script>
</body>
</html>
