package edu.wctc.jsadi;

import java.time.LocalTime;

/**
 * This class creates the ticket for each customer and tracks all relevant information.
 * It also runs the initial menu for the parking garage.
 * Created by jsadi on 9/29/2018
 * @author Jordan Sadi
 * @version 2018 0929 .1
 */
public class CheckIn {
    LocalTime checkIn, checkOut;
    int hoursParked;
    int vehicleID = 100;
    double amountDue = 5.00;

    /**
     * This is the constructor for the CheckIn class.
     * Each CheckIn is initialized with a random time, which could easily be replaced with the current time.
     * Each CheckIn causes the vehicleID (which is based on the last vehicleID read from the file) to increment).
     */
    public CheckIn(){
        checkIn = LocalTime.of(7 + (int)(Math.random() * ((12 - 7) + 1)), 0);
        vehicleID++;
    }

    /**
     * This method prints the main menu for the parking garage, then waits for user input.
     */
    public void menu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/In");
        System.out.println("3 - Close Garage");
        System.out.print("=>_");
    }
}
