package edu.wctc.jsadi;

import java.time.LocalTime;

public class CheckOut {
    private CheckIn userCheckin;
    private static double checkinTotal = 0, lostTicketTotal = 0, total = 0;
    private static int checkins = 0, lostTickets = 0;

    public CheckOut(CheckIn userCheckin) {
        this.userCheckin = userCheckin;
    }

    public void menu() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>_");
    }

    public void lostTicket() {
        userCheckin.amountDue = 25.00;
        lostTicketTotal += userCheckin.amountDue;
        lostTickets++;
    }

    public void userCheckout() {
        userCheckin.checkOut = LocalTime.of(13 + (int)(Math.random() * ((23 - 13) + 1)), 0);
        userCheckin.hoursParked = userCheckin.checkOut.getHour() - userCheckin.checkIn.getHour();

        if (userCheckin.hoursParked > 3 && userCheckin.hoursParked < 11) {
            userCheckin.amountDue += (userCheckin.hoursParked - 3);
        }
        else if (userCheckin.hoursParked > 11) {
            userCheckin.amountDue = 15.00;
        }

        checkinTotal += userCheckin.amountDue;
        checkins++;
    }

    public void receipt() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle ID " + CheckIn.vehicleID);
        if (userCheckin.amountDue == 25.00)
            System.out.println("\nLost Ticket");
        else
            System.out.println("\n" + userCheckin.hoursParked + " hours parked " + userCheckin.checkIn + " - " + userCheckin.checkOut);
        System.out.printf("$%.2f\n", userCheckin.amountDue);
    }

    public static void summary() {
        total = checkinTotal + lostTicketTotal;
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to Date\n");
        System.out.printf("$%.2f was collected from " + checkins + " check ins\n", checkinTotal);
        System.out.printf("$%.2f was collected from " + lostTickets + " lost tickets\n", lostTicketTotal);
        System.out.printf("\n$%.2f was collected overall", total);
    }
}
