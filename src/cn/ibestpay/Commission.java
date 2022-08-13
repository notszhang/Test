package cn.ibestpay;

import java.math.BigDecimal;

public class Commission {

    public static void main(String args[]) {

        BigDecimal feeBps = BigDecimal.valueOf(18.8870);
        String securityType = "Equity";
        String ccy = "CNY";
        String counterparty = "CICC";
        String transType = "SS";
        System.err.println("++++++++++++++");
        System.out.println(test(feeBps, securityType, ccy, counterparty, transType));

    }

    public static String test(BigDecimal feeBps, String securityType, String ccy, String counterparty, String transType) {

        //String tradingfee = "select total_buy,total_sell from tbl_trading_fee where market = ? ";
        //Map<String, Object> tradingfeeMap = jdbcTemplate.queryForMap(tradingfee, ccy);
        /**
         * 美元没有tradeFee，直接判断即可
         */

        if ("USD".equals(ccy) && feeBps.compareTo(BigDecimal.valueOf(4)) == 0) {
            return "HT";
        } else if ("USD".equals(ccy) && feeBps.compareTo(BigDecimal.valueOf(4)) != 0) {
            return "LT";
        }
        /**
         * 计算期货交易费用
         * 中证期货使用的通道是CFFE   港股期货使用HKEx
         * 分别使用不同的费率
         * 只有市场费用没有交易费用，是一个特殊的通道费。LT没有市场费
         */
        if ("Futures".equals(securityType) && feeBps.compareTo(BigDecimal.ZERO) == 0) {
            return "LT";
        } else if ("Futures".equals(securityType) && feeBps.compareTo(BigDecimal.valueOf(0.0004)) == 0) {
            return "CFFE";
        } else if ("Futures".equals(securityType) && feeBps.compareTo(BigDecimal.valueOf(0.0008)) == 0) {
            return "HKEx";
        }

        /**
         * 对于HKD的交易，买卖费用是同一个0.00137850
         * feebps减去这个买卖费用后，剩下的就是Commission
         * 大于6，就是HT
         */
        //BigDecimal tempHkd = (BigDecimal) tradingfeeMap.get("total_sell");
        BigDecimal tempHkd = BigDecimal.valueOf(0.00137850);
        tempHkd = feeBps.subtract(tempHkd.multiply(BigDecimal.valueOf(10000))).abs();
        if ("HKD".equals(ccy) && tempHkd.compareTo(BigDecimal.valueOf(6)) == 1) {
            return "HT";
        } else if ("HKD".equals(ccy) && tempHkd.compareTo(BigDecimal.valueOf(6)) == -1) {
            return "LT";
        }

        //BigDecimal CnSell = (BigDecimal) tradingfeeMap.get("total_sell");
        //BigDecimal CnBuy = (BigDecimal) tradingfeeMap.get("total_buy");
        BigDecimal CnSell = BigDecimal.valueOf(0.00110870);
        ;
        BigDecimal CnBuy = BigDecimal.valueOf(0.00010870);
        ;
        BigDecimal tempCn = BigDecimal.ZERO;
        if ("B".equals(transType.substring(0, 1))) {//买入
            tempCn = feeBps.subtract(CnBuy.multiply(BigDecimal.valueOf(10000))).abs();
        } else if ("S".equals(transType.substring(0, 1))) {//卖出
            tempCn = feeBps.subtract(CnSell.multiply(BigDecimal.valueOf(10000))).abs();
        }
        if ("MS".equals(counterparty.substring(0, 2))) {//MSPB
            //不区分CNH或CNY，大于10就是HT
            if (tempCn.compareTo(BigDecimal.valueOf(10)) == 1) {
                return "HT";
            } else {
                return "LT";
            }

        } else if ("CIC".equals(counterparty.substring(0, 3))) {//CICC和CICS
            //不区分CNH或CNY，大于7就是HT
            if (tempCn.compareTo(BigDecimal.valueOf(7)) == 1) {
                return "HT";
            } else {
                return "LT";
            }
        }

        return "NA";
    }
}
