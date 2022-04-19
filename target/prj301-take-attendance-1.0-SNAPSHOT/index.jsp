<%-- 
    Document   : index
    Created on : Feb 19, 2022, 8:51:39 PM
    Author     : Acer
--%>

<%@page import="com.fptuni.prj.prj301.qrcode.ReadQrCode"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QR Code</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id"
              content="668982921016-9r8d6v02irp98iqt7o0g3uf43n2q34fo.apps.googleusercontent.com">

        <script src="js/index.js" type="text/javascript"></script>
        <script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>

    </head>
    <body onload="onLoad();">
        <h1>Create QR Code</h1>

        <form action="QRCodeController">

            <table border="0">
                <tbody>
                    <tr>
                        <td>Date</td>
                        <td><input type="date" name="date"></td>
                    </tr>
                    <tr>
                        <td>Subject Code</td>
                        <td>
                            <select name="subject-code">
                                <option value="CSD201">CSD201</option>
                                <option value="PRJ301">PRJ301</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Class</td>
                        <td>
                            <select name="class">
                                <option value="SE1602">SE1602</option>
                                <option value="SE1615">SE1615</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>Slot Number</td>
                        <td>
                            <select name="slot-number">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="action" value="Generate"></td>
                    </tr>
                </tbody>
            </table>
        </form>



        <h3>Content: ${requestScope.content}</h3>
        <img src="${pageContext.request.contextPath}/qrcode/${requestScope.qrPath}" alt="qrcode"/>



        <h1>Account info</h1>

        <p>${sessionScope.id}</p>
        <p>${sessionScope.userName}</p>
        <p>${sessionScope.email}</p>



        <!--<a href="login.jsp" onclick="signOut();">Sign out</a>-->
        <button  type="button" onclick="signOut();">Sign out</button>


    </body>
</html>
