package com.jiker.keju;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class FileUtilsTest {

    @Test
    public void readFileByLine() {
        final String line1 = "1公里,等待0分钟";
        final String line2 = "3公里,等待0分钟";
        final String line3 = "10公里,等待0分钟";
        final String line4 = "2公里,等待3分钟";


        FileUtils fileUtils = new FileUtils();
        String[] strings = fileUtils.readFileByLine("src/main/resources/testData.txt");
        assertEquals(getUtf8String(line1),strings[0]);
        assertEquals( getUtf8String("3公里,等待0分钟"),strings[1]);
        assertEquals(getUtf8String("10公里,等待0分钟"),strings[2]);
        assertEquals(getUtf8String("2公里,等待3分钟"),strings[3]);
        assertNull(fileUtils.readFileByLine("test.aa"));
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