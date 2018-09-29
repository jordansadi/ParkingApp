package edu.wctc.jsadi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean runMenu = true, keepGoing;
        int userInput;
        Scanner k = new Scanner(System.in);

        while (runMenu) {
            CheckIn newUser = new CheckIn();
            keepGoing = true;
            userInput = 0;
            newUser.menu();
            try {
                userInput = k.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                k.next();
            }

            if (userInput == 3) {
                runMenu = false;
                CheckOut.summary();
            }

            else if (userInput == 1) {
                CheckOut userCheckout = new CheckOut(newUser);

                while(keepGoing) {
                    userCheckout.menu();
                    userInput = 0;
                    try {
                        userInput = k.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        k.next();
                    }

                    if (userInput == 2) {
                        userCheckout.lostTicket();
                        keepGoing = false;
                    }
                    else if  (userInput == 1) {
                        userCheckout.userCheckout();
                        keepGoing = false;
                    }
                }
                userCheckout.receipt();
            }
        }
    }
}