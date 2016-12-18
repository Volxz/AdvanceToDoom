package com.exclnetworks.atd;

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

public class Accounting {
    static void loginPrompt() {
        String username;
        String password;
        Boolean passLoopActive = true;
        Game.clearScreen();
        System.out.println("**************************************");
        System.out.println("Please enter your username. If you");
        System.out.println("are new pick a username and hit enter.");
        System.out.println("**************************************");
        username = Game.getInput();
        Game.clearScreen();
        if (SQLOperation.getUUID(username) < 1) {
            createAccount(username);
        } else {
            while (passLoopActive) {
                Game.clearScreen();
                System.out.println("**************************************");
                System.out.println("User exists in the DB! Great news.");
                System.out.println("Type your password to authenticate.");
                System.out.println("**************************************");
                password = Game.getInput();
                Game.clearScreen();
                if (password.equals(SQLOperation.getPass(SQLOperation.getUUID(username)))) {
                    System.out.println("**************************************");
                    System.out.println("Welcome: " + SQLOperation.getPseudo(SQLOperation.getUUID(username)) + "!");
                    System.out.println("Initiating toaster thrusters.");
                    System.out.println("**************************************");
                    passLoopActive = false;
                    Game.userID = SQLOperation.getUUID(username);
                    Game.Sleep(5);
                } else {
                    System.out.println("**************************************");
                    System.out.println("!!!INVALID PASSWORD ENTRY!!!");
                    System.out.println("Please re-enter your password correctly.");
                    System.out.println("**************************************");
                    Game.clearScreen();
                    Game.Sleep(3);
                }
            }
        }
    }

    static void createAccount(String username) {
        String password = "";
        String finalPass = "";
        String pseudo = "";
        Game.clearScreen();
        boolean pseudoLoop = true;
        while (password.length() < 5) {
            Game.clearScreen();
            System.out.println("**************************************");
            System.out.println("Welcome newcomer! Please type your");
            System.out.println("chosen password and hit enter");
            System.out.println("**************************************");
            password = Game.getInput();
            Game.clearScreen();
            if (password.length() < 5) {
                Game.clearScreen();
                System.out.println("*********************************************");
                System.out.println("I apologize but your password must be 5 chars");
                System.out.println("or more. Please re-enter a longer password.");
                System.out.println("*********************************************");
                password = Game.getInput();
                Game.clearScreen();
            }
        }
        while (true) {
            Game.clearScreen();
            System.out.println("*********************************************");
            System.out.println("Password is good. Please pick a name that we");
            System.out.println("can call you in game and on leader-boards.");
            System.out.println("*********************************************");
            pseudo = Game.getInput();
            if (pseudo.length() > 1) {
                break;
            } else {
                Game.clearScreen();
                System.out.println("*********************************************");
                System.out.println("I regret to inform you that your name MUST be at");
                System.out.println("least one char and at most 10 chars.");
                System.out.println("*********************************************");
                Game.Sleep(2);
            }
        }
        System.out.println("*********************************************");
        System.out.println("User creation successful. You will soon be");
        System.out.println("redirected to the login page.");
        System.out.println("*********************************************");
        Game.Sleep(5);
        Game.clearScreen();
        SQLOperation.addUser(username, password, pseudo);
        loginPrompt();
    }
}
