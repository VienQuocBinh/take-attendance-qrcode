<%-- 
    Document   : login
    Created on : Feb 20, 2022, 7:55:48 PM
    Author     : Acer
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-scope" content="profile email">
        <meta name="google-signin-client_id"
              content="668982921016-9r8d6v02irp98iqt7o0g3uf43n2q34fo.apps.googleusercontent.com">

        <title>Login Google</title>
    </head>
    <body>
        <h1>Login</h1>
        <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
        <!--<a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/prj301-take-attendance/login-google&response_type=code&client_id=668982921016-9r8d6v02irp98iqt7o0g3uf43n2q34fo.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>-->
        <script src="js/index.js" type="text/javascript"></script>
    </body>
</html>
