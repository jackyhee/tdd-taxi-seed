package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNotSame;

public class TddTaxiTest {

    @Test
    public void getPriceStringByLineTest() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        assertEquals("收费6元\n",tddTaxi.getPriceStringByLine("1公里,等待0分钟\n"));
        assertEquals("收费7元\n",tddTaxi.getPriceStringByLine("3公里,等待0分钟\n"));
        assertEquals("收费13元\n",tddTaxi.getPriceStringByLine("10公里,等待0分钟\n"));
        assertEquals("收费7元\n",tddTaxi.getPriceStringByLine("2公里,等待3分钟\n"));

    }
    @Test
    public void getPriceString() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        assertEquals("收费6元\n收费7元\n收费13元\n收费7元\n"
                ,tddTaxi.getReceipt());
        assertNotSame("收费7元\n收费7元\n收费13元\n收费7元\n"
                ,tddTaxi.getReceipt());
    }
}