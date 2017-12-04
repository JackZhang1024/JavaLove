package generic;

/**
 *
 * Created by zfz on 2017/12/8.
 */
public class GenericLearn03 {

    public static void main(String[] args) {
        GenCons cons1 = new GenCons(100);
        cons1.showVal();
        GenCons cons2 = new GenCons(200.56);
        cons2.showVal();
    }

    static class GenCons {
        private double val;
        // 构造函数可以泛型化
        <T extends Number> GenCons(T t) {
            val = t.doubleValue();
        }

        public void showVal() {
            System.out.println("val " + val);
        }

    }


}
