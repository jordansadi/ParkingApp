package edu.wctc.jsadi;

import java.time.LocalTime;

public class Ticket {
    LocalTime checkIn, checkOut;
    int hoursParked;
    static int vehicleID = 100;
    double amountDue = 5.00;

    public Ticket() {
        checkIn = LocalTime.of(7 + (int)(Math.random() * ((12 - 7) + 1)), 0);
        vehicleID++;
    }
}
