package generic;

/**
 * 泛型层次
 * 泛型类可以是类层次的一部分，就像非泛型类那样。
 * 因此，泛型类可以作为超类或子类。
 * <p>
 * 泛型和非泛型层次之间的关键区别是:
 * 在泛型层次中，类层次中的所有子类都必须向上传递超类
 * 所有类型参数。这与必须沿着类层次向上传递构造参数类似
 * <p>
 * Created by zfz on 2017/12/8.
 */
public class GenericLearn05 {


    public static void main(String[] args) {
        GenTwo<Integer> genTwo = new GenTwo<>(12);
        System.out.println(genTwo.getT());

        GenThree<String, Integer> genTree = new GenThree<>("Hello World!", 20);
        System.out.println(genTree.getT());
        System.out.println(genTree.getNumber());

        GenFour<String> genFour = new GenFour<>(12, "Nice To meet You");
        System.out.println(genFour.getT());
        System.out.println(genFour.getNum());
    }

    public static class GenOne<T> {
        T t;

        public GenOne(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static class GenTwo<T> extends GenOne<T> {

        public GenTwo(T t) {
            super(t);
        }
    }

    public static class GenThree<T, V> extends GenOne<T> {
        private V number;

        public GenThree(T t, V num) {
            super(t);
            this.number = num;
        }

        public V getNumber() {
            return number;
        }

        public void setNumber(V number) {
            this.number = number;
        }
    }

    // 普通类型作为泛型类的超类
    public static class NonGen {
        private int num;

        public NonGen(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static class GenFour<T> extends NonGen{
        private T t;

        public GenFour(int num, T t) {
            super(num);
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }


}
