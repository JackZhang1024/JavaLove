package java8.lambda;

/**
 * ��������
 *
 * ��һ����Ҫ��������lambda ���ʽ��أ������������á�
 * ���������ṩ��һ�����ö���ִ�еķ�ʽ������������lambda���ʽ��ء�
 * ��Ϊ��Ҳ��Ҫ�ɼ��ݵĺ���ʽ�ӿڹ��ɵ�Ŀ�������ġ�
 *
 * ���������ж���
 * 1. ��̬����������
 *
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda07 {

    public static void main(String[] args) {
        // MyStringOps::strReverse����Ϊһ�����ó��ֵ�
        // ΪʲôstrReverse������ΪstrOps�ĵ�һ������
        // ��ΪstrReverse��StringOpt�ĺ���ʽ�ӿڼ���
        String result = strOps(MyStringOps::strReverse,"123456");
        System.out.println("result "+result);
    }


    static String strOps(StringOpt opt, String str){
        return opt.strOpt(str);
    }

    interface StringOpt{
        String strOpt(String s);
    }

    // MyStringOps��һ���Ǿ�̬�� ��strReverseһ���Ǿ�̬����
    static class MyStringOps{

        static String strReverse(String str){
            String result = "";
            for (int n = str.length()-1; n>=0; n--){
                 result += str.charAt(n);
            }
            return result;
        }
    }



}
