package java8.lambda;

/**
 * 构造函数引用
 *
 * 与创建方法引用相似， 可以创建构造函数的引用。所需语法的一般形式如下所示：
 * classname::new
 *
 * 可以把这个引用赋值给定义的方法与构造函数兼容的任何函数式接口的引用。
 * Created by zfz on 2017/11/11.
 */
public class Lambda11 {

    public static void main(String[] args) {
        MyFunc myClassCons = MyClass::new;

        MyClass mc = myClassCons.func(100);
        System.out.println("Val in mc is "+mc.getVal());
    }


    interface MyFunc{
        MyClass func(int n);
    }


    static class MyClass{
        private int val;

        MyClass(){
            val = 0;
        }

        MyClass(int v){
            this.val = v;
        }

        public int getVal() {
            return val;
        }
    }


}
