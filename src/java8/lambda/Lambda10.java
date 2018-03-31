package java8.lambda;

/**
 * 泛型中的方法使用
 * Created by zfz on 2017/11/11.
 */
public class Lambda10 {

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 3, 4, 5, 6};
        String[] strs = {"one", "two", "three", "two", "four"};
        int result = myOp(MyArrayOps::countMatching, vals, 4);
        int result2  =myOp(MyArrayOps::countMatching, strs, "two");
        System.out.println("result 1 "+result+" result2 "+result2);
    }

    static <T> int myOp(MyFunc<T> f, T[] vals, T v){
        return f.func(vals, v);
    }

    interface MyFunc<T>{
        int func(T[] vals, T v);
    }

    static class MyArrayOps{
        static <T> int countMatching(T[] vals, T v){
            int count = 0;
            for (int i=0; i<vals.length; i++){
                if (vals[i]==v) count++;
            }
            return count;
        }
    }
}
