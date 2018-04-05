package java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by zfz on 2017/12/3.
 */
public class DateTimeLearn02 {

    public static void main(String[] args) {
        getLocalTime();
        formatLocalTime();
        parseLocalTime();
    }

    private static void getLocalTime() {
        LocalDate curDate = LocalDate.now();
        System.out.println(curDate);
        LocalTime curTime = LocalTime.now();
        System.out.println(curTime);
        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime);
    }

    private static void formatLocalTime() {
        LocalDate curDate = LocalDate.now();
        System.out.println(curDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        LocalTime curTime = LocalTime.now();
        System.out.println(curTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));

        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));

    }

    private static void parseLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.parse("2017/12/03 20:42:23",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(localDateTime);

    }


}
