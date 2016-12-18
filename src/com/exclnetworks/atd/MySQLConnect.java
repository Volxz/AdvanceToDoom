package com.exclnetworks.atd;

import java.sql.*;
import javax.swing.*;


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


public class MySQLConnect {
    Connection conn = null;

    public static Connection ConnectDb(){
        String mysqlUrl = "";
        String user = "";
        String passwd = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(mysqlUrl,user, passwd);
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
    }
}