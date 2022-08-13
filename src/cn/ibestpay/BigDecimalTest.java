package cn.ibestpay;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {


        String aa = "601636.SSC,SL,14.0870,6.33030000,LT,4";
        String[] param = aa.split(",");
        String ss = "20";
        BigDecimal bb = new BigDecimal(param[2]);

        BigDecimal dd = new BigDecimal(ss);
        BigDecimal cc = new BigDecimal(1);
        System.out.println("CC:  "+cc);
        System.out.println("CC toString" + cc.toString());
        System.out.println("CC  to  to" + new BigDecimal(cc.toString()));
    }
}
