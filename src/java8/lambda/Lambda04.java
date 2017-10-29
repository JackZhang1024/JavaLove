package java8.lambda;

/**
 * 将lambda表达式作为参数
 * Created by zfz on 2017/11/11.
 */
public class Lambda04 {

    public static void main(String[] args) {
        String result = stringOp((str)->str.toUpperCase(), "world");
        System.out.println("result "+result);

        StringFunc stringFunc = (str)->{
            String outCome = "";
            for (int n= str.length()-1; n>=0; n--){
                 outCome += str.charAt(n);
            }
            return outCome;
        };
        String result2 =stringOp(stringFunc, "I love china");
        System.out.println("result2 "+result2);

        String result3 =stringOp((str)->{
            String outCome = "";
            for (int n= str.length()-1; n>=0; n--){
                outCome += str.charAt(n);
            }
            return outCome;
        }, "I Love China");
        System.out.println("result3 "+result3);
    }

    public static String stringOp(StringFunc strFunc, String s){
        return strFunc.func(s);
    }

    interface StringFunc{
        String func(String n);
    }




}
