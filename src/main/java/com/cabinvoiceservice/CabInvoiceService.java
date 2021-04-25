package com.cabinvoiceservice;

/*@Description- Cab Invoice Generator Problem.
* Welcome to Cab Invoice Services.
* Calculate the total fare for the journey.
* And calculating minimum fare also.
* Add multiple rides and calculate a total fare.
* Calculate Total number of rides.
* Total fare.
* Average Fare per ride.*/

public class CabInvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    private static final double PREMIUM_MINIMUN_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_MINIMUN_FARE = 20;

    public static void main(String[] args) {
        System.out.println("Welcome to Cab Invoice Service");
    }

    /*@Description- Calculate the total fare for the journey.
     * And calculating minimum fare also.*/
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /*Calculating total fare for the multiple rides for all.
    * Calculate Total number of rides.
    * Total fare.
    * Average Fare per ride.
    *  given a user id the invoice service gets the list of rides and the return the invoice.*/
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculatePremiumFare(double distance, int time) {
        double PremiumtotalFare =  distance * PREMIUM_MINIMUN_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME ;
        if(PremiumtotalFare < PREMIUM_MINIMUN_FARE ) {
            return  PREMIUM_MINIMUN_FARE;
        }
        return PremiumtotalFare;
    }
}
