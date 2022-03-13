package cn.ibestpay;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.ibestpay.Days360;

public class Test {
    public static void main(String[] args) {

//        String aa = "688261.SH";
//        String bb = "9995 44   55";
//        String cc = "TSLA.US.AA";
//        String dd = "  dfg vvv  ";
//
//        System.out.println(aa.split("\\.",2));
//       System.out.println(bb.split("\\.",5));
//        System.out.println(cc.split("\\.",2));
//
//        String str1[] = aa.split("\\.", 2);
//        String str2[] = bb.split(" ", 5);
//        String str3[] = cc.split("\\.", 2);
//
//        System.out.println(cc.substring(0,2));

        BigDecimal aa = BigDecimal.valueOf(50663640.24);
        BigDecimal bb = BigDecimal.valueOf(6.3629);
        BigDecimal cc = BigDecimal.valueOf(1);

        System.out.println(aa.abs().divide(bb).divide(cc));


    }
}

