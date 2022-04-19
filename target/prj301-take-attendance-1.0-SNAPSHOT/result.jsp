<%-- 
    Document   : result
    Created on : Feb 23, 2022, 10:45:12 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>${requestScope.checkinStatus}</h1>
        <a href="${pageContext.request.contextPath}/QRCodeController">Return to QR code page</a>
    </body>
</html>
