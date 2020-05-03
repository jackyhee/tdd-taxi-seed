package com.jiker.keju;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNotSame;

public class TddTaxiTest {

    @Test
    public void getPriceStringByLineTest() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        assertEquals("\u6536\u8d39"+6+"\u5143\n",tddTaxi.getPriceStringByLine("1公里,等待0分钟\n"));
        assertEquals("\u6536\u8d39"+7+"\u5143\n",tddTaxi.getPriceStringByLine("3公里,等待0分钟\n"));
        assertEquals("\u6536\u8d39"+13+"\u5143\n",tddTaxi.getPriceStringByLine("10公里,等待0分钟\n"));
        assertEquals("\u6536\u8d39"+7+"\u5143\n",tddTaxi.getPriceStringByLine("2公里,等待3分钟\n"));

    }
    @Test
    public void getPriceString() {
        TddTaxi tddTaxi = new TddTaxi("testData.txt");
        try {
            assertEquals("\u6536\u8d396\u5143\n\u6536\u8d397\u5143\n\u6536\u8d3913\u5143\n\u6536\u8d397\u5143\n"
                    ,tddTaxi.getReceipt());
            assertNotSame(getUtf8String("收费7元\\n收费7元\\n收费13元\\n收费7元\\n")
                    ,tddTaxi.getReceipt());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String getUtf8String(String str) {
        try {
            return new String(str.getBytes(Charset.defaultCharset()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}