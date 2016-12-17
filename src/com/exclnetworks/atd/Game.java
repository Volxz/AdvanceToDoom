package com.exclnetworks.atd;

import java.util.Scanner;

/**
 * Created by ethan on 2016-12-16.
 */
public class Game {
    static int xLoc;
    static int yLoc;
    static int roomID;


    public static void main(String[] args) {
        Accounting.loginPrompt();
    }


    Game(int uuid, String username, String pseudo) {

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
            case "move"
        }

    }

    static void moveRoom(int x, int y) {
        xLoc += x;
        yLoc += y;
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
}
