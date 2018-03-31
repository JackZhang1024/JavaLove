package java8.lambda;

/**
 * lambda表达式与异常
 * Created by zfz on 2017/11/11.
 */
public class Lambda05 {

    public static void main(String[] args) {
        double[] arrays = new double[]{10, 20, 20, 30};
        DoubleNumericArrayFunc doubleNumericArrayFunc = (n)->{
            double result = 0;
            if (n.length==0){
                throw new EmptyArrayException();
            }
            for (int index=0; index<n.length; index++){
                 result+=n[index];
            }
            return result;
        };
        try {
            double result1= doubleNumericArrayFunc.func(arrays);
            System.out.println("result1 "+result1);
            double result2= doubleNumericArrayFunc.func(new double[0]);
            System.out.println("result2 "+result2);
        }catch (EmptyArrayException e){
            e.printStackTrace();
        }

    }

    static class EmptyArrayException extends Exception {

        public EmptyArrayException() {
            super("数组不能为空");
        }
    }

    interface DoubleNumericArrayFunc {
        double func(double[] n) throws EmptyArrayException;
    }


}
