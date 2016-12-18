package com.exclnetworks.atd;

import com.mysql.jdbc.exceptions.MySQLQueryInterruptedException;

import java.util.Arrays;
import java.util.Scanner;

/**
 *88888888888                          88     888b      88                                                                    88
 *88                                   88     8888b     88                ,d                                                  88
 *88                                   88     88 `8b    88                88                                                  88
 *88aaaaa      8b,     ,d8  ,adPPYba,  88     88  `8b   88   ,adPPYba,  MM88MMM  8b      db      d8   ,adPPYba,   8b,dPPYba,  88   ,d8   ,adPPYba,
 *88"""""       `Y8, ,8P'  a8"     ""  88     88   `8b  88  a8P_____88    88     `8b    d88b    d8'  a8"     "8a  88P'   "Y8  88 ,a8"    I8[    ""
 *88              )888(    8b          88     88    `8b 88  8PP"""""""    88      `8b  d8'`8b  d8'   8b       d8  88          8888[       `"Y8ba,
 *88            ,d8" "8b,  "8a,   ,aa  88     88     `8888  "8b,   ,aa    88,      `8bd8'  `8bd8'    "8a,   ,a8"  88          88`"Yba,   aa    ]8I
 *88888888888  8P'     `Y8  `"Ybbd8"'  88     88      `888   `"Ybbd8"'    "Y888      YP      YP       `"YbbdP"'   88          88   `Y8a  `"YbbdP"'
 */

public class Game {
    static int xLoc;
    static int yLoc;
    static int roomID;
    static int userID;
    static String pseudo;


    Game(int uuid, String username, String pseudo) {

    }

    public static void main(String[] args) {
        Accounting.loginPrompt();
        System.out.println("HERE");
        initInfo(userID);
        System.out.println("HERE now");
        System.out.println(xLoc);
        System.out.println(yLoc);
        System.out.println(roomID);
        System.out.println(userID);
        System.out.println(pseudo);

    }

    /**
     * Parse Player Command Function
     * So multi command is a possibility.
     */
    static void parse(String input) {
        /**Split String In To Key Points*/
        String[] splitCommand = input.split("\\s+");
        switch (splitCommand[1]) {
            case "n": moveRoom(0, 1); break;
            case "e": moveRoom(1, 0); break;
            case "s": moveRoom(0, -1); break;
            case "w": moveRoom(-1, 0); break;
        }

    }

    static void initInfo(int idNumber) {

        roomID = SQLOperation.getRoomID(xLoc, yLoc);
        pseudo = SQLOperation.getPseudo(userID);
        clearScreen();
    }

    static void diplayRoomInfo() {
        System.out.println();
    }

    static void moveRoom(int x, int y) {
        xLoc += x;
        yLoc += y;
        roomID = SQLOperation.getRoomID(x, y);
        diplayRoomInfo();
    }

    static String getInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    static void Sleep(int seconds) {
        seconds = seconds * 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void clearScreen() {
        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }

    static void getPlayerCoords() {

    }
}
