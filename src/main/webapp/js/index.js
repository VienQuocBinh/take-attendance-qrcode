/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
/* global gapi */

function onSignIn(googleUser) {
    // Useful data for your client-side scripts:
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId());
    console.log('Name: ' + profile.getName());
    console.log('Given Name: ' + profile.getGivenName());
    console.log('Family Name: ' + profile.getFamilyName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail());
    console.log('id_token: ' + googleUser.getAuthResponse().id_token);

    //do not post above info to the server because that is not safe.
    //just send the id_token

    var redirectUrl = 'login-google';
    //using jquery to post data dynamically

    var form = $('<form action="' + redirectUrl + '" method="post">' +
            '<input type="text" name="id_token" value="' +
            googleUser.getAuthResponse().id_token + '" />' +
            '</form>');
    $('body').append(form);
    form.submit();
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        alert("You have ben signed out successfully");
        window.location = "http://localhost:8080/prj301-take-attendance/login.jsp";
    });


}

function onLoad() {
    gapi.load('auth2', function () {
        gapi.auth2.init();
    });
}


function getCurrentDate() {
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10)
        month = "0" + month;
    if (day < 10)
        day = "0" + day;

    var today = year + "-" + month + "-" + day;
    document.getElementById("theDate").value = today;
//    window.addEventListener('load', getCurrentDate);
}

