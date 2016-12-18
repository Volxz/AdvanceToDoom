package com.exclnetworks.atd;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 88888888888                          88     888b      88                                                                    88
 * 88                                   88     8888b     88                ,d                                                  88
 * 88                                   88     88 `8b    88                88                                                  88
 * 88aaaaa      8b,     ,d8  ,adPPYba,  88     88  `8b   88   ,adPPYba,  MM88MMM  8b      db      d8   ,adPPYba,   8b,dPPYba,  88   ,d8   ,adPPYba,
 * 88"""""       `Y8, ,8P'  a8"     ""  88     88   `8b  88  a8P_____88    88     `8b    d88b    d8'  a8"     "8a  88P'   "Y8  88 ,a8"    I8[    ""
 * 88              )888(    8b          88     88    `8b 88  8PP"""""""    88      `8b  d8'`8b  d8'   8b       d8  88          8888[       `"Y8ba,
 * 88            ,d8" "8b,  "8a,   ,aa  88     88     `8888  "8b,   ,aa    88,      `8bd8'  `8bd8'    "8a,   ,a8"  88          88`"Yba,   aa    ]8I
 * 88888888888  8P'     `Y8  `"Ybbd8"'  88     88      `888   `"Ybbd8"'    "Y888      YP      YP       `"YbbdP"'   88          88   `Y8a  `"YbbdP"'
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

    /**
     * Find Users Room
     */
    static int getUserRoomID(int uuid) {
        int rReturn = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT room FROM users WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(uuid));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = Integer.parseInt(rs.getString("room"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rReturn;
    }

    /**
     * Get Room X From Room Unique Identifier
     */

    static int getRoomX(int id) {
        int rReturn = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT x FROM rooms WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(id));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = Integer.valueOf(rs.getString("x"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rReturn;
    }

    static int getRoomY(int id) {
        int rReturn = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "SELECT y FROM rooms WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(id));
            rs = pst.executeQuery();
            if (rs.next()) {
                rReturn = Integer.valueOf(rs.getString("y"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rReturn;
    }

    static void syncRoom(int rmID) {
        Connection conn = null;
        PreparedStatement pst = null;
        conn = MySQLConnect.ConnectDb();
        try {
            String sql = "UPDATE users SET room = ?" + " WHERE id = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, Integer.toString(rmID));
            pst.setString(2, Integer.toString(Game.userID));
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}


