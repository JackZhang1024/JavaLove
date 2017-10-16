package DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zfz on 2017/10/16.
 */
public class Test {

    public static void main(String[] args) {
        String date = getFormattedDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("date "+date);
    }

    public static String getFormattedDate(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

}
