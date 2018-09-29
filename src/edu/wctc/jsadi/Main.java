package edu.wctc.jsadi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepGoing = true;
        int userInput = 0;
        Scanner k = new Scanner(System.in);
        CheckIn newUser = new CheckIn();

        while (keepGoing) {
            newUser.menu();
            try {
                userInput = k.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
                k.next();
            }


            if (userInput == 3)
                keepGoing = false;
            else if (userInput == 1) {
                Ticket userTicket = new Ticket();
                CheckOut userCheckout = new CheckOut(userTicket);

                keepGoing = true;
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