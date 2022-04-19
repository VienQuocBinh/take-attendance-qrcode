/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fptuni.prj.prj301.controller;

import com.fptuni.prj.prj301.qrcode.GenerateQrCode;
import com.fptuni.prj.prj301.qrcode.ReadQrCode;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LucasBV
 */
public class QRCodeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession(true);
            // Get class information for QR code
            String date = request.getParameter("date");
            String subjectCode = request.getParameter("subject-code");
            String className = request.getParameter("class");
            int slotNumber = Integer.parseInt(request.getParameter("slot-number"));
            String userName = (String) session.getAttribute("userName");
            String email = (String) session.getAttribute("email");

            // Generate Qr code
//            String data = date + "_" + subjectCode + "_" + className + "_" + slotNumber;
//            String path = "E:\\FPT\\SEM4_PRJ301\\prj301-take-attendance\\src\\main\\webapp\\qrcode\\"
//                    + date + subjectCode + className + slotNumber + ".png";
            String data = "http://localhost:8080/prj301-take-attendance/checkin?email=" + email
                    + "&userName=" + userName
                    + "&date=" + date
                    + "&subjectCode=" + subjectCode
                    + "&className=" + className
                    + "&slotNumber=" + slotNumber;
            String path = "E:\\FPT\\SEM4_PRJ301\\prj301-take-attendance\\src\\main\\webapp\\qrcode\\"
                    + date + subjectCode + className + slotNumber + ".png";

            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hashmap = new HashMap<>();
            hashmap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            GenerateQrCode.generateQRcode(data, path, charset, hashmap, 400, 400);

            // Get content from QR code
            String content = ReadQrCode.readQRcode(path, charset, hashmap);

            request.setAttribute("content", content);
            request.setAttribute("qrPath", date + subjectCode + className + slotNumber + ".png");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
