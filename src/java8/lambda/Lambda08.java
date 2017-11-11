package java8.lambda;

/**
 * ʵ�������ķ�������
 * Ҫ���ݶ�ĳ�������ʵ�����������ã���Ҫʹ������Ļ����﷨��
 * objRef::methodName
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda08 {

    public static void main(String[] args) {
        MyStringOps strOps = new MyStringOps();
        String result = strOpt(strOps::strReverse, "ILoveChina");
        System.out.println("result "+result);
    }

    public static String strOpt(StrFunc strFunc, String s){
        return strFunc.func(s);
    }


    interface StrFunc{
        String func(String str);
    }

    static class MyStringOps{
        String strReverse(String str){
            String result = "";
            for (int n = str.length()-1; n>=0; n-- ){
                 result+=str.charAt(n);
            }
            return result;
        }
    }

}
