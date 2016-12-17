package com.exclnetworks.atd;

import java.sql.*;
import javax.swing.*;

public class MySQLConnect {
    Connection conn = null;

    public static Connection ConnectDb(){
        String mysqlUrl = "jdbc:mysql://:3306/javatestdb";
        String user = "root";
        String passwd = "";
        try{https://github.com/Volxz/AdvanceToDoomhttps://github.com/Volxz/AdvanceToDoom
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(mysqlUrl,user, passwd);
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
    }
}