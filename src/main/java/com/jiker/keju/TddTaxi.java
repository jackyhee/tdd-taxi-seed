package com.jiker.keju;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TddTaxi {

    private static final String FILE_PATH = "src/main/resources/";
    String fileName;

    public TddTaxi(String fileName) {
        this.fileName = FILE_PATH + fileName;
    }

    public String getReceipt() {
        String[] content = new FileUtils().readFileByLine(fileName);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.length; i++) {
            sb.append(getPriceStringByLine(content[i]));
        }
        return sb.toString();
    }

    public String getPriceStringByLine(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll(" ").trim().replaceAll("\\s{1,}", " ");
        String[] numStr = result.split(" ");
        int price = TaxiPrice.getPrice(Integer.valueOf(numStr[0]), Integer.valueOf(numStr[1]));
        return new StringBuffer("สีทั").append(price).append("ิช").append("\n").toString();
    }

}
