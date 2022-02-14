package cn.ibestpay;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import cn.ibestpay.Days360;

public class Test {
    public static void main(String[] args) {


        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = df.parse("2021-12-31");
            Date d2 = df.parse("2022-12-31");
            Date d3 = df.parse("2022-01-12");
            Date d4 = df.parse("2021-11-02");
            System.out.println("已过日期：          "+Days360.days360(d1,d3));
            System.out.println("剩余日期：          "+Days360.days360(d3, d2));
            System.out.println(Days360.days360(d1, d2));

            System.out.println("测试的日期" + Days360.testDay(d2));
            System.out.println("测试的日期" + Days360.testDay(d3));

        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }


/*
        int a = 5;
        int b = 6;
        System.out.println(a+b);

        String aa = "0.96000000%".replace("%", "");
        BigDecimal per = new BigDecimal(aa);
        System.out.println(per);

        System.out.println(per.divide(BigDecimal.valueOf(360),8,BigDecimal.ROUND_HALF_UP));

        //String code = "IC 2112";
       String code = "833 HK";
       //String code = "2850 SH";
        //String code = "HHIF 2201";
        //String code = "IMAO us";


        String ciccCode = "";
        String[] str2 = code.split(" ", 2);
        String priceCode = str2[0].trim();

        if ("IC".compareTo(priceCode.toUpperCase()) == 0
                || "IH".compareTo(priceCode.toUpperCase()) == 0
                || "IF".compareTo(priceCode.toUpperCase()) == 0) {
            ciccCode = str2[0].trim() + str2[1].trim() + ".HK";
        } else if ("HHIF".compareTo(priceCode.toUpperCase()) == 0) {
            ciccCode = str2[0].trim() + str2[1].trim() + ".CFE";
        } else {
            int len = priceCode.length();
            switch (str2[1].trim().toUpperCase()) {
                case "HK":
                    priceCode = str2[0];
                    for (int i = 4; i > len; i--) {
                        priceCode = "0" + priceCode;
                    }
                    ciccCode = priceCode + ".HK";
                    break;
                case "US":
                    ciccCode = str2[0] + ".O";
                    break;
                default:
                    for (int i = 6; i > len; i--) {
                        priceCode = "0" + priceCode;
                    }
                    ciccCode = priceCode + "." + str2[1].trim();
                    break;
            }
        }

        System.out.println("code1");
        System.out.println(ciccCode);
*/


    }

    public void getNav(Date date){

        Date aa = date;
        System.out.println(aa);
    }
}

