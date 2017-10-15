package annotation;


/**
 * Created by zfz on 2017/10/14.
 */
public class AnnotationLearn03 {

    private static @AnnotationLearn02.WeekDays int currDay;

    public static void main(String[] args) {
        setCurrDay(-1);
    }



    public static void setCurrDay(@AnnotationLearn02.WeekDays int weekDay){
       currDay = weekDay;
    }

    @AnnotationLearn02.WeekDays
    public int getCurrDay(){
        return currDay;
    }
}
