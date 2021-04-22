package com.cabinvoiceservice;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {
    CabInvoiceService cabInvoiceService = null;
    @Before
    public void setUp() throws Exception {
         cabInvoiceService = new CabInvoiceService();
    }
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceService.calculateFare(distance,time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1)
        };
        double fare = cabInvoiceService.calculateFare(rides);
        Assertions.assertEquals(30, fare, 0.0);
    }
}
