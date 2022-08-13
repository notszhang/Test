package cn.ibestpay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
    public static void main(String[] args) {
        //多个空格合并成一个空格
        String strResult = "";
        String str = "Senators   are        still in        the nation’s        Capitol.";
        //String str = "Senators are still ";
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(str);
        strResult = matcher.replaceAll(" ");
        System.out.println(strResult);




        //返回true或false
        String str1 = "abc";
        boolean status = str1.contains("a");
        if (status) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

        String str2 = "Margin Swap";
        if (str2.contains("Margin")){
            System.err.println("包含");
        }else{
            System.err.println("不包含");
        }
    }
}
