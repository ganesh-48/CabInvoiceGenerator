package com.cabinvoiceservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceServiceTest {
    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceService.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        CabInvoiceService cabInvoiceService = new CabInvoiceService();
        double distance = 0.2;
        int time = 1;
        double fare = cabInvoiceService.calculateFare(distance,time);
        Assertions.assertEquals(5, fare, 0.0);
    }
}
