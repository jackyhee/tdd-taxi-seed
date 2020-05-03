package com.jiker.keju;

import java.io.File;

public class TaxiPrice {
    private static final int PRICE_LEVEL_0 = 6;// 起步价
    private static final int DIST_LEVEL_0 = 2;// 起步里程
    private static final int DIST_LEVEL_1 = 8;// 起步里程
    private static final float PRICE_PER_KM = 0.8f;// 超过2公里后小于8公里（含）的单价
    private static final float PRICE_EXTR_PER_KM = PRICE_PER_KM * 0.5f;// 超过8公里后的单价
    private static final float PRICE_PER_MIN = 0.25f;// 每分钟等待的单价

    private static float priceFromDistance(int distance) {
        float ret = PRICE_LEVEL_0;
        if (distance > DIST_LEVEL_0) {
            ret += (distance - DIST_LEVEL_0) * PRICE_PER_KM + priceFromExtrDist(distance);
        }
        return ret;
    }

    private static float priceFromExtrDist(int dist) {
        float ret = 0;
        if (dist > DIST_LEVEL_1) {
            ret = (dist - DIST_LEVEL_1) * PRICE_EXTR_PER_KM;
        }
        return ret;
    }

    private static float priceFromWaitTime(int time) {
        return time * PRICE_PER_MIN;
    }

    public static int getPrice(int distance, int time) {
        return Math.round(priceFromDistance(distance) + priceFromWaitTime(time));
    }
}
