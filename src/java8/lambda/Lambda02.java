package java8.lambda;

/**
 * Created by zfz on 2017/11/11.
 */
public class Lambda02 {

    public static void main(String[] args) {
        NumericFunc numericFunc = (n)->{
            int result = 1;
            for (int index =1; index <= n; index++){
                result = result*index;
            }
            return result;
        };
        int result = numericFunc.func(3);
        System.out.println("result "+result);
    }

    interface NumericFunc{
        int func(int n);
    }

}
