package java8.lambda;

import java.util.function.Function;

/**
 * Ԥ����ĺ���ʽ�ӿ�
 *
 * java.util.function �����ṩ��һЩԤ����ĺ���ʽ�ӿ�
 * 1. UnaryOperator<T>
 *    ������Ϊ T �Ķ���Ӧ��һԪ���㣬 �����ؽ�������������Ҳ��T.
 *    �����ķ�����Ϊapply()
 *
 * 2. BinaryOperator<T>
 *    ������Ϊ T ������������в����������ؽ�������ؽ��������Ҳ��T.
 *    �����ķ�����Ϊapply()
 *
 * 3. Consumer<T>
 *    ������ΪT �Ķ�����в����������ķ�����Ϊaccept()
 *
 * 4. Supplier<T>
 *    ��������Ϊ T �Ķ��󡣰����ķ�����Ϊget()
 *
 * 5. Function<T, R>
 *    ������Ϊ T�Ķ������ò����������ؽ�����������Ϊ R�Ķ���
 *    �����ķ�����Ϊ apply()
 *
 * 6. Predicate<T>
 *    ȷ������Ϊ T�Ķ����Ƿ�����ĳ��Լ�������صĽ���ǲ���ֵ��
 *    �����ķ�����Ϊ test()
 *
 * Created by zfz on 2017/11/11.
 */
public class Lambda13 {

    public static void main(String[] args) {
        functionLearn();
    }

    private static void functionLearn(){
        Function<Integer, Integer> function = (n)-> {
            int result = 1;
            for (int i=1; i <= n; i++){
                 result =result*i;
            }
            return result;
        };
        int result = function.apply(4);
        System.out.println("result "+result);
    }


}
