package cn.ibestpay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeMap {
    public static void main(String[] args) {
        System.out.println("++++++++++++++");
        System.out.println(getCode("600123  SH", "CNH", "Equity","AA"));
//        System.out.println("++++++++++++++");
//        System.out.println(getCode("600123.SH", "CNY", "Equity"));
//        System.out.println("++++++++++++++");
//        System.out.println(getCode("0123 SH", "CNH", "Equity"));
//        System.out.println("++++++++++++++");
//        System.out.println(getCode("123 HK", "HKD", "Equity"));
//        System.out.println("++++++++++++++");
        System.out.println(getCode("13 HK", "CNH", "Equity","HKEx"));
        System.out.println("++++++++++++++");
        //System.out.println(getCode("TSLA US", "CNH", "Equity"));
        System.out.println("++++++++++++++");
        System.out.println(getCode("IC 2202 ", "CNH", "Futures","CFFE"));
        System.out.println("+++++++++++++++");
        //System.out.println(getCode("300123 SHB1", "CNH", "Block"));
        System.out.println("+++++++++++++++");

        //System.out.println(getCode("CSI498 AIR-MS", "CNH", "AirBag"));
        System.out.println("+++++++++++++++");


    }


    public static String getCode(String secCode, String ccy, String secType, String orderChannel) {

        String code = secCode;

        String code1 = "";
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(secCode.trim());
        code1 = matcher.replaceAll(" ");
        //以上，把secCode中的空格处理掉

        System.out.println(code1.substring(0, 2).toUpperCase());

        if ("Futures".compareTo(secType) == 0) {//期货
            if ("CFFE".compareTo(orderChannel) == 0) {//中金期货
                code = code1.replace(" ", "").replace(".", "").trim();
                code = code.toUpperCase() + ".CFE";
                return code;
            }
            if ("HKEx".compareTo(orderChannel) == 0) {//港股期货
                code = code1.replace(" ", "").replace(".", "").trim();
                code = code.toUpperCase() + ".HK";
                return code;
            }
        }


        String[] temp = {"a"};
        if (code1.contains(" ")) {
            temp = code1.split(" ");
        } else if (code1.contains(".")) {
            temp = code1.split("\\.");
        }

        if ("Block".compareTo(secType) == 0) {//大宗
            return temp[0] + "." + temp[temp.length - 1];
        }
        if (temp[temp.length - 1].contains("HK")) {//港股
            code = temp[0].trim();
            for (int i = 4; i > temp[0].length(); i--) {
                code = "0" + code;
            }
            return code + ".HK";
        }
        if (temp[temp.length - 1].contains("US")) {//美股
            code = temp[0].trim();
            return code + ".US";
        }

        if (temp[temp.length - 1].contains("SS")
                || temp[temp.length - 1].contains("SH")
                || temp[temp.length - 1].contains("SZ")
                || temp[temp.length - 1].contains("SS")) {//A股
            code = temp[0].trim();
            for (int i = 6; i > temp[0].length(); i--) {
                code = "0" + code;
            }

            String suffix = "";
            if ("6".compareTo(code.substring(0, 1)) == 0 && "CNY".compareTo(ccy) == 0) {
                suffix = "SH";
            }
            if ("6".compareTo(code.substring(0, 1)) == 0 && "CNH".compareTo(ccy) == 0) {
                suffix = "SSC";
            }
            if ("6".compareTo(code.substring(0, 1)) != 0 && "CNY".compareTo(ccy) == 0) {
                suffix = "SZ";
            }
            if ("6".compareTo(code.substring(0, 1)) != 0 && "CNH".compareTo(ccy) == 0) {
                suffix = "SZC";
            }

            return code + "." + suffix;
        }

        return code1.replace(" ", ".");
    }
}
