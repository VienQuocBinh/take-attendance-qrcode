/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fptuni.prj.prj301.controller;

import com.fptuni.prj.prj301.dbmanager.AttendanceManager;
import com.fptuni.prj.prj301.model.Attendance;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LucasBV
 */
public class CheckinController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String email = request.getParameter("email");
            String userName = request.getParameter("userName");
            String date = request.getParameter("date");
            String subjectCode = request.getParameter("subjectCode");
            String className = request.getParameter("className");
            int slotNumber = Integer.parseInt(request.getParameter("slotNumber"));

//            Attendance attendance = new Attendance(userName, email, subjectCode, className, slotNumber, date);
            AttendanceManager manager = new AttendanceManager();
            if (manager.checkin(date, subjectCode, className, slotNumber, userName, email)) {
                request.setAttribute("checkinStatus", "Student " + userName + " takes attendance for class " + className + " successfully");
            } else {
                request.setAttribute("checkinStatus", "Takes attendance unsuccessfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("checkinStatus", "Takes attendance unsuccessfully");

        } finally {
            request.getRequestDispatcher("result.jsp").forward(request, response);
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
