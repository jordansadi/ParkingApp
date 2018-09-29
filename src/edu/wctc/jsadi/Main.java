package edu.wctc.jsadi;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean runMenu = true, keepGoing;
        int userInput;
        Scanner k = new Scanner(System.in);
        ArrayList<CheckIn> tickets = new ArrayList<>();
        FileInput inFile = new FileInput("parkingTickets.txt");
        String lineIn;
        String[] lines;

        while ((lineIn = inFile.fileReadLine()) != null) {
            CheckIn newUser = new CheckIn();
            lines = lineIn.split(",");
            newUser.amountDue = Double.parseDouble(lines[0]);
            newUser.checkIn = LocalTime.of(Integer.parseInt(lines[1].substring(0, 2)), 0);
            try {
                newUser.checkOut = LocalTime.of(Integer.parseInt(lines[2].substring(0, 2)), 0);
            } catch (Exception e) {
                newUser.checkOut = LocalTime.of(23, 0);
            }
            newUser.hoursParked = Integer.parseInt(lines[3]);
            newUser.vehicleID = Integer.parseInt(lines[4]);
            tickets.add(newUser);
        }

        while (runMenu) {
            CheckIn newUser = new CheckIn();

            if (tickets.size() > 0)
                newUser.vehicleID = tickets.get(tickets.size() - 1).vehicleID + 1;

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

                for (CheckIn c : tickets)
                    CheckOut.total += c.amountDue;

                CheckOut.summary();
                FileOutput outFile = new FileOutput("parkingTickets.txt");
                for (CheckIn c : tickets) {
                    outFile.fileWrite(c.amountDue + "," + c.checkIn + "," + c.checkOut + ","
                            + c.hoursParked + "," + c.vehicleID);
                }
                inFile.fileClose();
                outFile.fileClose();
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
                tickets.add(newUser);
            }
        }
    }
}