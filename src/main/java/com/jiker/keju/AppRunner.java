package com.jiker.keju;

public class AppRunner {

    public static void main(String[] args) {
        /*TODO
          1. args[0]Ϊresources�µĲ��������ļ��������紫���args[0]ֵΪ"testData.txt"��ע�Ⲣ�������ļ�·����
          2. ��д�ĳ��򽫰�testDataFile��Ϊ�������ش��ļ�����ȡ�ļ��ڵĲ������ݣ�����ÿ���������ݼ�������
          3. �����мƷѽ��ƴ�Ӳ�ʹ��\n�ָȻ�󱣴浽receipt�����С�
         */
        String testDataFile = args[0];
        String receipt = new TddTaxi(testDataFile).getReceipt();
        System.out.println(receipt);
    }
}
