package java8.lambda;

/**
 * Created by zfz on 2017/11/11.
 */
public class Lambda01 {


    public static void main(String[] args) {
        NumberTest numberTest = (a, b)-> a+b;
        int result = numberTest.add(10, 20);
        System.out.println(result);
        numberTest = (a, b)-> a*b;
        result = numberTest.add(10, 10);
        System.out.println(result);
        isOddTest isOddTest = a-> a%2==0;
        boolean isOdd = isOddTest.isOdd(13);
        System.out.println(isOdd);


    }

    // 函数式接口一
    public interface NumberTest{
        int add(int a, int b);
    }

    // 函数式接口二
    public interface isOddTest{
        boolean isOdd(int n);
    }




}
