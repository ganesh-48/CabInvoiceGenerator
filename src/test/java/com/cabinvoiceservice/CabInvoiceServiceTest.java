package com.cabinvoiceservice;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
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
    public void givenMultipleRidesShouldReturnCabInvoiceSummary() {
        Ride[] rides = { new Ride(2.0, 5),
                         new Ride(0.1, 1)
        };
        InvoiceSummary summary = cabInvoiceService.calculateFare(rides);
        InvoiceSummary ecpectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(ecpectedInvoiceSummary, summary);
    }
}
