package annotation;

import java.lang.reflect.Method;

import static annotation.AnnotationLearn02.*;

/**
 * Created by zfz on 2017/10/14.
 */
public class AnnotationTest {


    public static void main(String[] args) {

    }


    public static void testSource(){
        try{
            Method testSourceMethod = AnnotationLearn02.Foo.class.getDeclaredMethod("testSource");
            AnnotationLearn02.TestSource testSource = testSourceMethod.getAnnotation(AnnotationLearn02.TestSource.class);
            System.out.println("source"+testSource.sourceTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testClass(){
        try{
            Method testClassMethod = Foo.class.getDeclaredMethod("testClass");
            AnnotationLearn02.TestClass testClass = testClassMethod.getAnnotation(AnnotationLearn02.TestClass.class);
            System.out.println("class Test"+testClass.classTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testRunTime(){
        try{
            Method testRunTimeMethod = Foo.class.getDeclaredMethod("testRuntime");
            AnnotationLearn02.TestRuntime testRuntime = testRunTimeMethod.getAnnotation(AnnotationLearn02.TestRuntime.class);
            System.out.println("runtime Test "+testRuntime.runTimeTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
