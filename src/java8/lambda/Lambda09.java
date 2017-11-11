package java8.lambda;

/**
 * ����ָ��һ��ʵ��������ʹ���ܹ����ڸ������������������ָ������
 * ��ʱ����Ҫ�����洴���������ã�
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

    // ע�⣺�����ʽHighTemp::sameTemp����HighTemp::lessThanTemp
    // �����ݵ�counter()������ʱ���ᴴ��һ������ʽ�ӿ�MyFunc��ʵ��
    // ���������ֱ�ӵ������������
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
