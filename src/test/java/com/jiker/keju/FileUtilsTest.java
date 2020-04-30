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
        assertEquals("1����,�ȴ�0����",strings[0]);
        assertEquals("3����,�ȴ�0����",strings[1]);
        assertEquals("10����,�ȴ�0����",strings[2]);
        assertEquals("2����,�ȴ�3����",strings[3]);
    }

}