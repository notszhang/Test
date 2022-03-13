package cn.ibestpay;

public class LuckyNumberClass {


    public static void main(String args[]) {
        String companyName = "Google";
        String programName = "SPS";
        int currentYear = 2021;
        int companyHash = getHash(companyName);
        int programHash = getHash(programName);
        int spsLuckyNumber = companyHash + programHash + currentYear;
        System.out.println(spsLuckyNumber);
    }

    static int getHash(String theString){
        return theString.hashCode();
    }
}
