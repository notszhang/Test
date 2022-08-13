package cn.ibestpay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestException {

    public static void main(String[] args) {

//        List aa = new ArrayList<Serializable>();
//        aa.add(1472041203091472386L);
//        aa.add(1463807469731610626L);
//        System.out.println(aa);
//        System.out.println(aa.get(0));
//        System.out.println(aa.get(1));

        String cc = "1516327560326070274,1516327560418344961,1516327560439316482,1516327560468676610,";
        System.out.println(cc.split(",").toString());

        List dd = Arrays.asList(cc.split(","));
        System.err.println(dd);
        String[] aa = cc.split(",");
        System.out.println(aa[0]);
        System.out.println(aa[1]);
        System.out.println(aa.length);
    }

    public static void e1() {

        int[] arr = new int[5];
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println("cuowu");
            throw new RuntimeException("cuowu" + e.getMessage());
        }
    }
}
