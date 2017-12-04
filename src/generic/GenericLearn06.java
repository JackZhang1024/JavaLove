package generic;

/**
 * 运行时不能获取泛型类型信息
 * Created by zfz on 2017/12/8.
 */
public class GenericLearn06 {

    public static void main(String[] args) {
        Gen<Integer> genInteger = new Gen<>(12);
        Gen2<Integer> gen2Integer = new Gen2<>(12);
        Gen2<String> gen2String = new Gen2<>("hello");

        if (gen2Integer instanceof Gen2<?>) {
            System.out.println("gen2Integer is instance of Gen2");
        }
        if (gen2Integer instanceof Gen<?>){
            System.out.println("gen2Integer is instance of Gen");
        }
        if (gen2String instanceof Gen<?>){
            System.out.println("gen2String is instance of Gen");
        }
        if (gen2String instanceof Gen2<?>){
            System.out.println("gen2String is instance of Gen2");
        }
        if (genInteger instanceof Gen<?>){
            System.out.println("genInteger is instance of Gen");
        }
        if (genInteger instanceof Gen2<?>){
            System.out.println("genInteger is instance of Gen2");
        }

        // 不合法的参数 因为在运行的时候并不清楚genInteger的泛型参数类型是什么
        // 所以不能进行类型转换
        //if (genInteger instanceof Gen<Integer>){

        Gen<Integer> genIntegerOne = gen2Integer;
        System.out.println("GenIntegerOne  "+genIntegerOne.getT());

    }

    public static class Gen<T> {
        private T t;

        public Gen(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static class Gen2<T> extends Gen<T> {
        public Gen2(T t) {
            super(t);
        }
    }


}
