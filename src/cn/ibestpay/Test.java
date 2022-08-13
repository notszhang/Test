package cn.ibestpay;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import cn.ibestpay.Days360;

public class Test {
    public static void main(String[] args) throws ParseException {

        Map<String, String> map = new HashMap<String, String>();
        map.put("sss", "sssss");
        List<String> list = new ArrayList<String>(map.keySet());
        System.out.println(list);
        list.add("sss");
        System.out.println(list);
        Set<String>set=new HashSet<String>(list);
        System.out.println(set);


/*
        List<String> list = new ArrayList<>();
        list.add("000800.SZ");
        list.add("601234.SH");
        list.add("601234.SH");
        list.add("601234.SH");
        list.add("511990.SH");
        list.add("PDD");
        list.add("0980.HK");


        List<String> codes = new ArrayList<>();
        codes.add("PDD.US");
        codes.add("601234.SSC");
        codes.add("0980.HK");

        List<String> codes1 = new ArrayList<>();
        for (String item : codes ) {
            String aa = item.split("\\.")[0];
            String bb = item.split("\\.")[1];
            if ("HK".equals(bb)){//对于港股，就不要截取。
                aa = item;
            }
            codes1.add(aa);
        }



        List<String> list1 = new ArrayList<>();

        for (String item : list) {
            for (String codetemp : codes1){
                if (item.contains(codetemp)){
                    list1.add(item);
//                    list.remove(item);
                }
            }
        }
        System.out.println("----------**********---------");
        System.out.println(list1);
        System.out.println(list);

        System.out.println(list);
        System.out.println("一共有  "+list.size()+"  条！");
        HashSet h = new HashSet(list);
        list.clear();
        System.out.println("一共有  "+list.size()+"  条！");
        list.addAll(h);
        //System.out.println(list);

        System.out.println("+++++++++++");
        System.err.println("-------------");
        String code = "0020.HK";
        String ccy = "USD";
        String ccy2 = "USD";
        String ccy3 = "CNH";

        String bb = code.split("\\.")[0];
        String aa = code.split("\\.")[1];

        if ("HK".equals(aa)){//对于港股，就不要截取。
            bb = code;
        }

        System.out.println("最终的CodeBB： "+ bb    );


        if ("USD".compareTo(ccy)==0){
            String[] temp = code.split("\\.");
            code = temp[0] + ".US";
        }

        code = "IH 2205";
        code = code.replace(" ", "").replace(".", "").trim();
        code = code.toUpperCase() + ".CFE";

        System.out.println("实际的Code： "+ code);

        System.out.println("截取前两位：  " + ccy.substring(0,2));
        System.out.println("比较相等：" + !ccy.substring(0,2).equals(ccy2.substring(0,2)));
        System.out.println("比较相等：" + ccy.substring(0,2).equals(ccy3.substring(0,2)));

        String aaa = "688261.SH";
        String bbb = "9995 44   55";
        String cc = "TSLA.US.AA";
        String dd = "  dfg vvv  ";

        System.err.println("++++++++++++++++++++++");
        System.out.println(aa.split("\\.",2)[0]);
        System.out.println(aa.split("\\.")[0]);
       System.out.println(bb.split("\\.",5)[0]);
        System.out.println(cc.split("\\.",2)[0]);

        String str1[] = aa.split("\\.", 2);
        String str2[] = bb.split(" ", 5);
        String str3[] = cc.split("\\.", 2);

        System.out.println(cc.substring(0,2));


        BigDecimal aa = BigDecimal.valueOf(50663640.24);
        BigDecimal bb = BigDecimal.valueOf(6.3629);
        BigDecimal cc = BigDecimal.valueOf(1);
        System.out.println(aa.abs().divide(bb).divide(cc));
*/

/*
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 1);

        Date temp = cal.getTime();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = df.format(temp);
        Date accountDate = cal.getTime();
        Date account2 = df.parse(strDate);
        System.out.println(accountDate);
        System.out.println("=================");
        System.out.println(account2);


        String tasl = "TSLA.O";
        System.out.println(tasl);
        System.out.println("TSLA.O".equals(tasl));
*/
        BigDecimal aa1 = BigDecimal.valueOf(55.55);
        BigDecimal neg = aa1.negate();
        System.out.println("正数的negate：   " + neg);
        System.out.println("负数的negate：   " + neg.negate());



    }
}

