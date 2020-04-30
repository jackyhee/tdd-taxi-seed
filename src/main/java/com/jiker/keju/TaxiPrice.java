package com.jiker.keju;

import java.io.File;

public class TaxiPrice {
    private static final int PRICE_LEVEL_0 = 6;// �𲽼�
    private static final int DIST_LEVEL_0 = 2;// �����
    private static final int DIST_LEVEL_1 = 8;// �����
    private static final float PRICE_PER_KM = 0.8f;// ����2�����С��8��������ĵ���
    private static final float PRICE_EXTR_PER_KM = PRICE_PER_KM * 0.5f;// ����8�����ĵ���
    private static final float PRICE_PER_MIN = 0.25f;// ÿ���ӵȴ��ĵ���

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
