package edu.wctc.jsadi;

import java.time.LocalTime;

/**
 * This class controls the CheckOut process for each customer of the parking garage.
 * It tracks the charges for each customer, as well as the total charges for each session.
 * It also runs the checkout menu, which allows users to pay for their ticket or a lost ticket.
 * Created by jsadi on 9/29/2018
 * @author Jordan Sadi
 * @version 2018 0929 .1
 */
public class CheckOut {
    private CheckIn userCheckin;
    private static double checkinTotal = 0, lostTicketTotal = 0;
    static double total = 0;
    private static int checkins = 0, lostTickets = 0;

    /**
     * This is the constructor for this class, which takes a CheckIn as an input parameter.
     * @param userCheckin CheckIn to tie the CheckOut to a specific customer.
     */
    public CheckOut(CheckIn userCheckin) {
        this.userCheckin = userCheckin;
    }

    /**
     * This method runs the checkout menu, which allows customers to pay for their ticket or for a lost ticket.
     */
    public void menu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>_");
    }

    /**
     * This method assesses the charges for a lost ticket.
     * It also increments the lostTickets variable, to track the total number of lost tickets for a given session.
     */
    public void lostTicket() {
        userCheckin.amountDue = 25.00;
        lostTicketTotal += userCheckin.amountDue;
        lostTickets++;
    }

    /**
     * This method creates a random checkout time, then assesses the charges based on how long the user parked.
     * It also increments the checkins variable, to track the total number of checkins for a given session.
     */
    public void userCheckout() {
        userCheckin.checkOut = LocalTime.of(13 + (int)(Math.random() * ((23 - 13) + 1)), 0);
        userCheckin.hoursParked = userCheckin.checkOut.getHour() - userCheckin.checkIn.getHour();

        if (userCheckin.hoursParked > 3 && userCheckin.hoursParked <= 13) {
            userCheckin.amountDue += (userCheckin.hoursParked - 3);
        }
        else if (userCheckin.hoursParked > 13) {
            userCheckin.amountDue = 15.00;
        }

        checkinTotal += userCheckin.amountDue;
        checkins++;
    }

    /**
     * This method prints the receipt for a user.
     * It prints the amount of time parked (along with the checkin and checkout times) or whether the ticket was lost.
     * It then prints the total amount due for that customer.
     */
    public void receipt() {
        String checkInPrint, checkOutPrint;

        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for a vehicle id " + userCheckin.vehicleID);

        if (userCheckin.amountDue == 25.00)
            System.out.println("\nLost Ticket");
        else {
            if (userCheckin.checkIn.getHour() < 12)
                checkInPrint = userCheckin.checkIn.getHour() + "am";
            else
                checkInPrint = userCheckin.checkIn.getHour() + "pm";

            checkOutPrint = (userCheckin.checkOut.getHour() - 12) + "pm";
            System.out.println("\n" + userCheckin.hoursParked + " hours parked " + checkInPrint + " - " + checkOutPrint);
        }

        System.out.printf("$%.2f\n", userCheckin.amountDue);
    }

    /**
     * This method prints a summary of all transactions for a given session, and the total lifetime charges for the garage.
     * The total amounts of checkins and lost tickets for the session are printed.
     * The total amount charged for checkins and for lost tickets is also printed.
     */
    public static void summary() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to Date\n");
        System.out.printf("$%.0f was collected from " + checkins + " Check Ins\n", checkinTotal);
        System.out.printf("$%.0f was collected from " + lostTickets + " Tost Tickets\n", lostTicketTotal);
        System.out.printf("\n$%.0f was collected overall", total);
    }
}
