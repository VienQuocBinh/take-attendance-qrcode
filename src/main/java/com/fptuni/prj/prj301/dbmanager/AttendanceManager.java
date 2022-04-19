/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.prj.prj301.dbmanager;

import com.fptuni.prj.prj301.dbutils.DBUtils;
import com.fptuni.prj.prj301.model.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LucasBV
 */
public class AttendanceManager {

    public boolean checkin(String date, String subjectCode, String className, int slotNumber, String userName, String email) throws SQLException {
        boolean status = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO student (id, email, username, className, subjectCode, slot, dates)\n"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sql);
                int id = getLastID() + 1;
                ps.setInt(1, id);
                ps.setString(2, email);
                ps.setString(3, userName);
                ps.setString(4, className);
                ps.setString(5, subjectCode);
                ps.setInt(6, slotNumber);
                ps.setString(7, date);
                status = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
        }
        return status;
    }

    public List<Attendance> getListAttendance() throws SQLException {
        ArrayList<Attendance> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT email, username, className, subjectCode, slot, dates \n"
                        + "FROM student";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString("email");
                    String username = rs.getString("username");
                    String className = rs.getString("className");
                    String subjectCode = rs.getString("subjectCode");
                    int slot = rs.getInt("slot");
                    String dates = rs.getString("email");
                    Attendance attendance = new Attendance(username, email, subjectCode, className, slot, dates);
                    list.add(attendance);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return list;
    }

    public int getLastID() throws SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT MAX(id) FROM student";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            ps.close();
            rs.close();
        }
        return id;
    }

}
