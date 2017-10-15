package annotation;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Method;

import static annotation.AnnotationLearn02.*;

/**
 * Created by zfz on 2017/10/14.
 */
public class AnnotationTest {

    @Test
    public void testSource(){
        try{
            Method testSourceMethod = AnnotationLearn02.Foo.class.getDeclaredMethod("testSource");
            AnnotationLearn02.TestSource testSource = testSourceMethod.getAnnotation(AnnotationLearn02.TestSource.class);
            Assert.assertEquals("source", testSource.sourceTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testClass(){
        try{
            Method testClassMethod = Foo.class.getDeclaredMethod("testClass");
            AnnotationLearn02.TestClass testClass = testClassMethod.getAnnotation(AnnotationLearn02.TestClass.class);
            Assert.assertEquals("class Test", testClass.classTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRunTime(){
        try{
            Method testRunTimeMethod = Foo.class.getDeclaredMethod("testRuntime");
            AnnotationLearn02.TestRuntime testRuntime = testRunTimeMethod.getAnnotation(AnnotationLearn02.TestRuntime.class);
            Assert.assertEquals("runtime Test", testRuntime.runTimeTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
