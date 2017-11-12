package java8.datetime;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zfz on 2017/12/3.
 */
public class DateTimeLearn01 {

    public static void main(String[] args) {
        formatDate1();
        formatDate2();
    }


    private static void formatDate1(){
        Date date = new Date();
        DateFormat dateFormatChina = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINA);
        System.out.println(dateFormatChina.format(date));

        DateFormat dateFormatJapan = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.JAPAN);
        System.out.println(dateFormatJapan.format(date));

        DateFormat dateFormatUSA = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        System.out.println(dateFormatUSA.format(date));
    }

    private static void formatDate2(){
        Date date = new Date();
        DateFormat dateFormat;
        dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
        System.out.println("China :"+dateFormat.format(date));

        dateFormat = DateFormat.getTimeInstance(DateFormat.LONG, Locale.US);
        System.out.println("US :"+dateFormat.format(date));

        dateFormat = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
        System.out.println("Canada :"+dateFormat.format(date));

    }

}
