package java8.lambda;

/**
 * 创建泛型类的构造函数
 *
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda12 {



    public static void main(String[] args) {
        MyFunc<String> myFunc = MyClass<String>::new;
        MyClass<String> myClass = myFunc.func("Hello world!");
        String result = myClass.getVal();
        System.out.println("result "+result);

        //数组的构造函数引用
        //创建出包含两个MyClass对象的数组,并赋给每个元素初值
        MyFunc2<MyClass> myFunc2= MyClass[]::new;
        MyClass[] a = myFunc2.func(2);
        a[0] = new MyClass("1");
        a[1] = new MyClass("2");
        System.out.println("a[0].getVal()  "+ a[0].getVal());
        System.out.println("a[1].getVal()  "+ a[1].getVal());
    }

    public interface MyFunc<T>{
        MyClass<T> func(T n);
    }


    public interface MyFunc2<T>{
        T[] func(int n);
    }

    static class MyClass<T>{
        private T val;

        MyClass(){
            val = null;
        }

        MyClass(T v){
            this.val =v;
        }

        public T getVal() {
            return val;
        }
    }
}
