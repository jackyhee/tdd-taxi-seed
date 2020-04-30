package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxiPriceTest {

    @Test
    public void getPrice() {
        TaxiPrice taxiPrice = new TaxiPrice();
        assertEquals(6,TaxiPrice.getPrice(1,0));
        assertEquals(7,TaxiPrice.getPrice(3,0));
        assertEquals(13,TaxiPrice.getPrice(10,0));
        assertEquals(7,TaxiPrice.getPrice(2,3));

    }
}