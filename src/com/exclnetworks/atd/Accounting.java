package com.exclnetworks.atd;

import java.util.Arrays;

/**
 * Created by ethan on 2016-12-16.
 */
public class Accounting {
    static void loginPrompt() {
        String username;
        String password;
        Boolean passLoopActive = true;
        clearScreen();
        System.out.println("**************************************");
        System.out.println("Please enter your username. If you");
        System.out.println("are new pick a username and hit enter.");
        System.out.println("**************************************");
        username = Game.getInput();
        clearScreen();
        if (SQLOperation.getUUID(username) < 1) {
            createAccount(username);
        } else {
            while (passLoopActive) {
                clearScreen();
                System.out.println("**************************************");
                System.out.println("User exists in the DB! Great news.");
                System.out.println("Type your password to authenticate.");
                System.out.println("**************************************");
                password = Game.getInput();
                clearScreen();
                if (password.equals(SQLOperation.getPass(SQLOperation.getUUID(username)))) {
                    System.out.println("**************************************");
                    System.out.println("Welcome: " + SQLOperation.getPseudo(SQLOperation.getUUID(username)) + "!");
                    System.out.println("Initiating toaster thrusters.");
                    System.out.println("**************************************");
                    Game.Sleep(5);
                    passLoopActive = false;
                    new Game(SQLOperation.getUUID(username), username, SQLOperation.getPseudo(SQLOperation.getUUID(username)));
                } else {
                    System.out.println("**************************************");
                    System.out.println("!!!INVALID PASSWORD ENTRY!!!");
                    System.out.println("Please re-enter your password correctly.");
                    System.out.println("**************************************");
                    clearScreen();
                    Game.Sleep(3);
                }
            }
        }
    }

    static void createAccount(String username) {
        String password = "";
        String finalPass = "";
        String pseudo = "";
        clearScreen();
        boolean pseudoLoop = true;
        while (password.length() < 5) {
            clearScreen();
            System.out.println("**************************************");
            System.out.println("Welcome newcomer! Please type your");
            System.out.println("chosen password and hit enter");
            System.out.println("**************************************");
            password = Game.getInput();
            clearScreen();
            if (password.length() < 5) {
                clearScreen();
                System.out.println("*********************************************");
                System.out.println("I apologize but your password must be 5 chars");
                System.out.println("or more. Please re-enter a longer password.");
                System.out.println("*********************************************");
                password = Game.getInput();
                clearScreen();
            }
        }
        while (true) {
                clearScreen();
                System.out.println("*********************************************");
                System.out.println("Password is good. Please pick a name that we");
                System.out.println("can call you in game and on leader-boards.");
                System.out.println("*********************************************");
                pseudo = Game.getInput();
            if (pseudo.length() > 1) {
                break;
            } else {
                clearScreen();
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
        clearScreen();
        SQLOperation.addUser(username, password, pseudo);
        loginPrompt();
    }

    static void clearScreen() {
        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        System.out.print(String.valueOf(chars));
    }
}
