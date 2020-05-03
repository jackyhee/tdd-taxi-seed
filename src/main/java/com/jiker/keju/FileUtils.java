package com.jiker.keju;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileUtils {

    public  String[] readFileByLine(String filePath) {
        try {
            return readFileByLine(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private  String[] readFileByLine(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        ArrayList<String> arrayList = new ArrayList<>();
        String str = null;
        while ((str = randomAccessFile.readLine()) != null) {
            arrayList.add(new String(str.getBytes("ISO-8859-1"), "utf-8"));
        }
        randomAccessFile.close();
        return arrayList.toArray(new String[0]);
    }

//    public static String getUtf8String(String str) {
//        try {
//            return new String(str.getBytes(), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
}
