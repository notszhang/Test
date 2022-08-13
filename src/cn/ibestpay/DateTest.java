package cn.ibestpay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {

        //Calendar是一个抽象类，所以用Calendar.getInstance()方法创建对象
        Calendar caltest = Calendar.getInstance();
        //add方法第一个参数如果是1则代表的是对年份操作，2是对月份操作，3是对星期操作，5是对日期操作，11是对小时操作，12是对分钟操作，13是对秒操作，14是对毫秒操作。第二个参数表示改变，-1表示对日期减一
        caltest.add(Calendar.DATE, -1);
        System.err.println(Calendar.DATE);
        //用date对象获取日期
        Date date = caltest.getTime();
        //格式化日期格式
        String format = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(date);
        System.out.println(format);
        /////////////////////
        Calendar cal = Calendar.getInstance();//当日
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date temp1 = cal.getTime();//当日
        cal.add(Calendar.DATE, -1);//美股要保存为实际日期的前一天
        Date temp2 = cal.getTime();//前一天
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = df.format(temp1);
        String strDate2 = df.format(temp2);

        System.out.println(strDate1);
        System.out.println(strDate2);
    }
}
