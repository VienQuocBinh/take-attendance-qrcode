/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.fptuni.prj.prj301.model;

/**
 *
 * @author LucasBV
 */
public class Attendance {
    private String username;
    private String email;
    private String subjectCode;
    private String className;
    private int slotNumeber;
    private String date;

    public Attendance() {
    }

    public Attendance(String username, String email, String subjectCode, String className, int slotNumeber, String date) {
        this.username = username;
        this.email = email;
        this.subjectCode = subjectCode;
        this.className = className;
        this.slotNumeber = slotNumeber;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSlotNumeber() {
        return slotNumeber;
    }

    public void setSlotNumeber(int slotNumeber) {
        this.slotNumeber = slotNumeber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}


