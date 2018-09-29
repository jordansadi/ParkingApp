package edu.wctc.jsadi;

import java.time.LocalTime;

public class CheckOut {
    private CheckIn userCheckin;
    private static double checkinTotal = 0, lostTicketTotal = 0;
    static double total = 0;
    private static int checkins = 0, lostTickets = 0;
    private String checkInPrint, checkOutPrint;

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

        if (userCheckin.hoursParked > 3 && userCheckin.hoursParked <= 13) {
            userCheckin.amountDue += (userCheckin.hoursParked - 3);
        }
        else if (userCheckin.hoursParked > 13) {
            userCheckin.amountDue = 15.00;
        }

        checkinTotal += userCheckin.amountDue;
        checkins++;
    }

    public void receipt() {
        System.out.println("Best Value Parking Garage");
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

    public static void summary() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to Date\n");
        System.out.printf("$%.0f was collected from " + checkins + " Check Ins\n", checkinTotal);
        System.out.printf("$%.0f was collected from " + lostTickets + " Tost Tickets\n", lostTicketTotal);
        System.out.printf("\n$%.0f was collected overall", total);
    }
}
