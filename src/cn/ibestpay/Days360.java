package cn.ibestpay;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Days360 {
    /**
     * FALSE 或省略
     * 如果起始日期是一个月的最后一天，则等于同月的 30 号。
     * 如果终止日期是一个月的最后一天，并且起始日期早于 30 号，则终止日期等于下一个月的 1 号，否则，终止日期等于本月的 30 号。
     */
    public static int evaluate(Date d0, Date d1) {
        String startingDate = getStartingDate(d0);
        String endingDate = getEndingDateAccordingToStartingDate(d0, d1);
        System.out.println("+++++++++++++++++++");
        String startYear = startingDate.substring(0, 4);
        String startMonth = startingDate.substring(4, 6);
        String startDay = startingDate.substring(6, 8);

        Integer d = Integer.valueOf(startYear);
        Integer e = Integer.valueOf(startMonth);
        Integer f = Integer.valueOf(startDay);

        //System.out.println("开始日期的年份是：" + Integer.valueOf(startYear) + ", 开始日期的月份是："+Integer.valueOf(startMonth)+", 开始日期的日期是:"+Integer.valueOf(startDay) );

        String endYear = endingDate.substring(0, 4);
        String endMonth = endingDate.substring(4, 6);
        String endDay = endingDate.substring(6, 8);
        //System.out.println("结束日期的年份是：" + Integer.valueOf(endYear) + ", 结束日期的月份是："+Integer.valueOf(endMonth)+", 结束日期的日期是:"+Integer.valueOf(endDay) );

        Integer a = Integer.valueOf(endYear);
        Integer b = Integer.valueOf(endMonth);
        Integer c = Integer.valueOf(endDay);

        int days360 = a * 360 + b * 30 + c - d * 360 - e * 30 - f;
        //System.out.println( "总日期是: "+days360);


        return days360;
    }


    public static String getStartingDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String startDate = sdf.format(date);
        if (isLastDayOfMonth(date)) {
            startDate = startDate.substring(0, 6).concat("30");
        }
        return startDate;
    }

    /**
     * FALSE 或省略
     * <p>
     * 如果起始日期是一个月的最后一天，则等于同月的 30 号。
     * 如果终止日期是一个月的最后一天，并且起始日期早于 30 号，则终止日期等于下一个月的 1 号，否则，终止日期等于本月的 30 号。
     */
    private static String getEndingDateAccordingToStartingDate(Date d0, Date d1) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String enddate = sdf.format(d1);

        String startingDate = getStartingDate(d0);//使用计算后的开始日期
        Integer day = Integer.valueOf(startingDate.substring(6, 8));

        if (isLastDayOfMonth(d1)) {
            if (day < 30) {
                Date endDate = getFirstDayOfNextMonth(d1);
                String endDateStr = sdf.format(endDate);
                return endDateStr;
            } else {
                enddate = enddate.substring(0, 6).concat("30");
                return enddate;
            }
        } else {
            return sdf.format(d1);
        }
    }

    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static Date getFirstDayOfNextMonth(Date date) {
        Calendar dateC = Calendar.getInstance();
        dateC.setTime(date);

        Calendar newDate = (Calendar) dateC.clone();
        if (dateC.get(Calendar.MONTH) < Calendar.DECEMBER) {
            newDate.set(Calendar.MONTH, dateC.get(Calendar.MONTH) + 1);
        } else {
            newDate.set(Calendar.MONTH, 0);
            newDate.set(Calendar.YEAR, dateC.get(Calendar.YEAR) + 1);
        }
        newDate.set(Calendar.DATE, 1);
        return newDate.getTime();
    }

    public static int days360(Date d0, Date d1) {
        return evaluate(d0, d1);
    }

    public static int month360(Date d0, Date d1) {
        BigDecimal c = BigDecimal.valueOf(evaluate(d0, d1));
        c = c.divide(BigDecimal.valueOf(30), 0, BigDecimal.ROUND_HALF_UP);
        return c.intValue();
    }

    public static Date testDay(Date d0){
        //获得入参的日期
        Calendar cd = Calendar.getInstance();
        cd.setTime(d0);

        //获取下个月第一天：
        cd.add(Calendar.MONTH, 1);
        //设置为1号,当前日期既为次月第一天
        cd.set(Calendar.DAY_OF_MONTH,1);

        return cd.getTime();

    }

}
