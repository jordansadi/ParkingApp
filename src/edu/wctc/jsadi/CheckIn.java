package edu.wctc.jsadi;

import java.time.LocalTime;

public class CheckIn {
    LocalTime checkIn, checkOut;
    int hoursParked;
    int vehicleID = 100;
    double amountDue = 5.00;

    public CheckIn(){
        checkIn = LocalTime.of(7 + (int)(Math.random() * ((12 - 7) + 1)), 0);
        vehicleID++;
    }

    public void menu() {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.print("=>_");
    }
}
