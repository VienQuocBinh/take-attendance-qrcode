/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.googleaccess;

/**
 *
 * @author LucasBV
 */
public class Constants {

    public static final String GOOGLE_CLIENT_ID = "668982921016-9r8d6v02irp98iqt7o0g3uf43n2q34fo.apps.googleusercontent.com";
    public static final String GOOGLE_CLIENT_SECRET = "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";
    public static final String GOOGLE_REDIRECT_URI = "http://localhost:8080/login-google";
    public static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
//    public static final String GOOGLE_LINK_GET_TOKEN = "https://oauth2.googleapis.com/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
