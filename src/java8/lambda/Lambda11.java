package java8.lambda;

/**
 * ���캯������
 *
 * �봴�������������ƣ� ���Դ������캯�������á������﷨��һ����ʽ������ʾ��
 * classname::new
 *
 * ���԰�������ø�ֵ������ķ����빹�캯�����ݵ��κκ���ʽ�ӿڵ����á�
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
