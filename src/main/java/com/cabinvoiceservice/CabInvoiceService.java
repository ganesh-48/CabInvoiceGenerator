package com.cabinvoiceservice;

/*@Description- Cab Invoice Generator Problem.
* Welcome to Cab Invoice Services.
* Calculate the total fare for the journey.
* And calculating minimum fare also.
* Add multiple rides and calculate a total fare. */
public class CabInvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to Cab Invoice Service");
    }

    /*@Description- Calculate the total fare for the journey.
     * And calculating minimum fare also.*/
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /*Calculating total fare for the multiple rides for all.*/
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
