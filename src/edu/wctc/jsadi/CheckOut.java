package edu.wctc.jsadi;

import java.time.LocalTime;

public class CheckOut {
    Ticket userTicket;

    public CheckOut(Ticket userTicket) {
        this.userTicket = userTicket;
    }

    public void menu() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
        System.out.print("=>_");
    }

    public void lostTicket() {
        userTicket.amountDue = 25.00;
    }

    public void userCheckout() {
        userTicket.checkOut = LocalTime.of(13 + (int)(Math.random() * ((23 - 13) + 1)), 0);
        userTicket.hoursParked = userTicket.checkOut.getHour() - userTicket.checkIn.getHour();

        if (userTicket.hoursParked > 3 && userTicket.hoursParked < 11) {
            userTicket.amountDue += (userTicket.hoursParked - 3);
        }
        else if (userTicket.hoursParked > 11) {
            userTicket.amountDue = 15.00;
        }
    }

    public void receipt() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle ID " + Ticket.vehicleID);
        if (userTicket.amountDue == 25.00)
            System.out.println("\nLost Ticket");
        else
            System.out.println("\n" + userTicket.hoursParked + " hours parked " + userTicket.checkIn + " - " + userTicket.checkOut);
        System.out.printf("$%.2f", userTicket.amountDue);
    }
}
