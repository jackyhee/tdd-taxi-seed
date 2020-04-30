package com.jiker.keju;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class FileUtilsTest {

    @Test
    public void readFileByLine() {
        FileUtils fileUtils = new FileUtils();
        String[] strings = fileUtils.readFileByLine("src/main/resources/testData.txt");
        assertNull(fileUtils.readFileByLine("test.aa"));
        assertEquals("1公里,等待0分钟",strings[0]);
        assertEquals("3公里,等待0分钟",strings[1]);
        assertEquals("10公里,等待0分钟",strings[2]);
        assertEquals("2公里,等待3分钟",strings[3]);
    }

}