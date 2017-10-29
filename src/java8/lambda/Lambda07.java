package java8.lambda;

/**
 * 方法引用
 *
 * 有一个重要的特性与lambda 表达式相关，叫做方法引用。
 * 方法引用提供了一种引用而不执行的方式。这种特性与lambda表达式相关。
 * 因为他也需要由兼容的函数式接口构成的目标上下文。
 *
 * 方法引用有多种
 * 1. 静态方法的引用
 *
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda07 {

    public static void main(String[] args) {
        // MyStringOps::strReverse是做为一个引用出现的
        // 为什么strReverse可以作为strOps的第一个参数
        // 因为strReverse和StringOpt的函数式接口兼容
        String result = strOps(MyStringOps::strReverse,"123456");
        System.out.println("result "+result);
    }


    static String strOps(StringOpt opt, String str){
        return opt.strOpt(str);
    }

    interface StringOpt{
        String strOpt(String s);
    }

    // MyStringOps不一定是静态类 但strReverse一定是静态方法
    static class MyStringOps{

        static String strReverse(String str){
            String result = "";
            for (int n = str.length()-1; n>=0; n--){
                 result += str.charAt(n);
            }
            return result;
        }
    }



}
