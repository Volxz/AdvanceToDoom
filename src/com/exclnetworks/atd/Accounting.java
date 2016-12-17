package com.exclnetworks.atd;

/**
 * Created by ethan on 2016-12-16.
 */
public class Accounting {
    static void loginPrompt() {
        String username;
        String password;
        clearScreen();
        System.out.println("**************************************");
        System.out.println("Please enter your username. If you");
        System.out.println("are new pick a username and hit enter.");
        System.out.println("**************************************");
        username = Game.getInput();
        if (SQLOperation.getUUID(username) < 1) {
            createAccount(username);
        } else {
            clearScreen();
            System.out.println("**************************************");
            System.out.println("User exists in the DB! Great news.");
            System.out.println("Type your password to authenticate.");
            System.out.println("**************************************");
            password = Game.getInput();
            if(password == SQLOperation.getPass(SQLOperation.getUUID(username))){
                System.out.println("**************************************");
                System.out.println("User authenticated with database.");
                System.out.println("Initiating toaster thrusters.");
                System.out.println("**************************************");
                Game.Sleep(5);
                new Game(SQLOperation.getUUID(username),username, SQLOperation.getPseudo(SQLOperation.getUUID(username)));
            }
        }
    }

    static void createAccount(String username) {
        String password = null;
        String finalPass = null;
        String pseudo = null;
        clearScreen();
        while (password.length() < 5) {
            clearScreen();
            System.out.println("**************************************");
            System.out.println("Welcome newcomer! Please type your");
            System.out.println("chosen password and hit enter");
            System.out.println("**************************************");
            password = Game.getInput();
            if (password.length() < 5) {
                clearScreen();
                System.out.println("*********************************************");
                System.out.println("I apologize but your password must be 5 chars");
                System.out.println("or more. Please re-enter a longer password.");
                System.out.println("*********************************************");
            } else {
                while (pseudo.length() < 1)
                    clearScreen();
                System.out.println("*********************************************");
                System.out.println("Password is good. Please pick a name that we");
                System.out.println("can call you in game and on leader-boards.");
                System.out.println("*********************************************");
                pseudo = Game.getInput();
                if(pseudo.length() < 1){
                    clearScreen();
                    System.out.println("*********************************************");
                    System.out.println("I regret to inform you that your password");
                    System.out.println("MUST be at lease one char. Please re-enter it.");
                    System.out.println("*********************************************");
                }

            }
        }
        clearScreen();
        SQLOperation.addUser(username, password, pseudo);
        loginPrompt();
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
