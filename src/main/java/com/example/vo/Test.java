package com.example.vo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ckx
 * @date: 2020/4/1
 * @description:
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        Long sjc = 1594599998L;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String resultTime = simpleFormat.format(new Date(sjc * 1000L));
        String riq = resultTime.substring(0,10);
        String sj = resultTime.substring(12,resultTime.length());
        System.out.println( riq);
        System.out.println(sj);
    }

}
