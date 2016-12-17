package com.exclnetworks.atd;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ethan on 2016-12-16.
 */
public class SQLOperation {
    /**
     * Resolve Coords To Room ID Number
     */
    static int getRoomID(int x, int y) {
        int rReturn = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT id FROM rooms WHERE x = ? AND y = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(x));
            pst.setString(2, Integer.toString(y));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = Integer.valueOf(rs.getString("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rReturn;
    }

    /**
     * Get ID From Username
     */
    static int getUUID(String username) {
        int rReturn = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT id FROM users WHERE username = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) rReturn = Integer.parseInt(rs.getString("id"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rReturn;
    }

    /**
     * Get Password From ID
     */
    static String getPass(int uid) {
        String rReturn = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT password FROM users WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(uid));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = rs.getString("password");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rReturn;
    }

    /**
     * Get Pseudo From ID
     */
    static String getPseudo(int uuid) {
        String rReturn = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT pseudo FROM users WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(uuid));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = rs.getString("pseudo");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rReturn;
    }

    /**
     * Add user to database
     */
    static void addUser(String username, String password, String pseudo) {
        Connection conn = null;
        PreparedStatement pst = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "INSERT INTO users (username, password, pseudo)" + " VALUES (?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, pseudo);
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

}


