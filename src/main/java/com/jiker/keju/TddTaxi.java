package com.jiker.keju;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TddTaxi {

    private static final String FILE_PATH = "src/main/resources/";
    String fileName;
    String SHOU_FEI = "\u6536\u8d39";
    final String YUAN = "\u5143";
    final String NEW_LINE = "\n";

    public TddTaxi(String fileName) {
        this.fileName = FILE_PATH + fileName;
    }

    public String getReceipt() throws UnsupportedEncodingException {
        String[] content = new FileUtils().readFileByLine(fileName);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.length; i++) {
            sb.append(getPriceStringByLine(content[i]));
        }
        return new String(sb.toString().getBytes("utf-8"), "utf-8");
    }

    public String getPriceStringByLine(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll(" ").trim().replaceAll("\\s{1,}", " ");
        String[] numStr = result.split(" ");
        int price = TaxiPrice.getPrice(Integer.valueOf(numStr[0]), Integer.valueOf(numStr[1]));
        return SHOU_FEI+price+YUAN+NEW_LINE;
    }

}
