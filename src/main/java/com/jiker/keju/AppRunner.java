package com.jiker.keju;

import java.io.UnsupportedEncodingException;

public class AppRunner {

    public static void main(String[] args) {


        String testDataFile = args[0];
        String receipt = null;
        try {
            receipt = new TddTaxi(testDataFile).getReceipt();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(receipt);
    }
}
