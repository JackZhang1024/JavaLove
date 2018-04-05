package annotation;

import java.lang.annotation.*;

/**
 * Created by zfz on 2017/10/14.
 */
public class AnnotationLearn02 {


    static class Foo{

        @TestSource(sourceTest = "source")
        public void testSource(){

        }

        @TestClass()
        public void testClass(){

        }

        @TestRuntime()
        public void testRuntime(){

        }

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface TestSource{
        String sourceTest() default "source Test";
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface TestClass{
        String classTest() default "class Test";
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface TestRuntime{
        String runTimeTest() default "runtime Test";
    }

    @Target({ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.CLASS)
    @interface IntDef{
        int[] value() default {};
    }

    public static final int SUNDAY   = 1;
    public static final int MONDAY   = 2;
    public static final int TUESDAY  = 3;
    public static final int WEDNESDAY= 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY   = 6;
    public static final int SATURDAY = 7;

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    @IntDef({SUNDAY, MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY})
    @Retention(RetentionPolicy.RUNTIME)
    @interface WeekDays{

    }

}
