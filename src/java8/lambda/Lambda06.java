package java8.lambda;

/**
 * lambda���ʽ���������
 * ���lambda�������ⲿ�ı��� ��ô�ñ����ͻ��Ϊfinal����
 * �����ٶԸñ������и�ֵ�������������Լ�����
 * Created by zfz on 2017/11/11.
 */
public class Lambda06 {

    public static void main(String[] args) {
        int num = 10;

        MyFunc mylambda = (n)->{
            int v = num+n;
            //num++;

          return v;
        };
//        num = 9;
        int result = mylambda.func(4);
        System.out.println("result "+result);
    }

    interface MyFunc{
        int func(int n);
    }


}
