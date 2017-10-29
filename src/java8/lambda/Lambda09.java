package java8.lambda;

/**
 * 可以指定一个实例方法，使其能够用于给定类的任意对象而不是指定对象。
 * 此时，需要像下面创建方法引用：
 *
 * className::instanceMethodName
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda09 {

    public static void main(String[] args) {
        int count = 0;
        HighTemp[] weekDayHighs = {
                new HighTemp(89),
                new HighTemp(90),
                new HighTemp(78),
                new HighTemp(89),
                new HighTemp(89)
        };
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("count "+count);
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("count "+count);
    }

    // 注意：当表达式HighTemp::sameTemp或者HighTemp::lessThanTemp
    // 被传递到counter()方法中时，会创建一个函数式接口MyFunc的实例
    // 这个和类名直接调用是有区别的
    static <T> int counter(T[] vals, MyFunc<T> f, T v){
        int count = 0;
        for (int index =0; index<vals.length; index++){
            if (f.func(vals[index], v)) count++;
        }
        return count;
    }

    interface MyFunc<T>{
        boolean func(T v1, T v2);
    }

    static class HighTemp{
        private int hTemp;

        public HighTemp(int hTemp) {
            this.hTemp = hTemp;
        }

        boolean sameTemp(HighTemp ht2){
            return hTemp==ht2.hTemp;
        }

        boolean lessThanTemp(HighTemp ht2){
            return hTemp<ht2.hTemp;
        }
    }

}
