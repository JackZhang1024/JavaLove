package java8.lambda;

/**
 * lambda表达式与变量捕获
 * 如果lambda引用了外部的变量 那么该变量就会成为final常量
 * 不能再对该变量进行赋值操作或者子增自减操作
 * Created by zfz on 2017/11/11.
 */
public class Lambda06 {

    public static void main(String[] args) {
        int num = 10;

        MyFunc mylambda = (n)->{
            int v = num+n;
            //num++;

          return v;
        };
//        num = 9;
        int result = mylambda.func(4);
        System.out.println("result "+result);
    }

    interface MyFunc{
        int func(int n);
    }


}
