package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNotSame;

public class TddTaxiTest {

    @Test
    public void getPriceStringByLineTest() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        assertEquals("�շ�6Ԫ\n",tddTaxi.getPriceStringByLine("1����,�ȴ�0����\n"));
        assertEquals("�շ�7Ԫ\n",tddTaxi.getPriceStringByLine("3����,�ȴ�0����\n"));
        assertEquals("�շ�13Ԫ\n",tddTaxi.getPriceStringByLine("10����,�ȴ�0����\n"));
        assertEquals("�շ�7Ԫ\n",tddTaxi.getPriceStringByLine("2����,�ȴ�3����\n"));

    }
    @Test
    public void getPriceString() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        assertEquals("�շ�6Ԫ\n�շ�7Ԫ\n�շ�13Ԫ\n�շ�7Ԫ\n"
                ,tddTaxi.getReceipt());
        assertNotSame("�շ�7Ԫ\n�շ�7Ԫ\n�շ�13Ԫ\n�շ�7Ԫ\n"
                ,tddTaxi.getReceipt());
    }
}