package reflection;

/**
 * Created by zfz on 2018/4/6.
 */

@MyAnnotation(name = "Jack", value = "100")
public class AnnotationObjcet {


    @MyAnnotation(name = "Lily", value = "90")
    private String field;


    public void doSomethings(@MyAnnotation(name = "Rose", value = "80") String gender){
        System.out.println("DoSomeThings");
    }

    @MyAnnotation(name = "Lucy", value = "70")
    public void doOtherThings(){
        System.out.println("Do OtherThings");
    }

}
