package java8.lambda;

/**
 * 实例方法的方法引用
 * 要传递对某个对象的实例方法的引用，需要使用下面的基本语法：
 * objRef::methodName
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda08 {

    public static void main(String[] args) {
        MyStringOps strOps = new MyStringOps();
        String result = strOpt(strOps::strReverse, "ILoveChina");
        System.out.println("result "+result);
    }

    public static String strOpt(StrFunc strFunc, String s){
        return strFunc.func(s);
    }


    interface StrFunc{
        String func(String str);
    }

    static class MyStringOps{
        String strReverse(String str){
            String result = "";
            for (int n = str.length()-1; n>=0; n-- ){
                 result+=str.charAt(n);
            }
            return result;
        }
    }

}
