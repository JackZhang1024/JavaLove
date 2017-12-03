package java8.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * ��������
 *
 * �������е�Ԫ�ط��ؽ��
 * ���������ľ��ǽ�һ����������һ��ֵ�Ĳ���
 * max()��min() count() ������������
 *
 * �����ڷ�������ṩreduce()������ͨ��
 * reduce()���������Ի������������������з���һ��ֵ��
 * ���ݶ��壬�����������������ն˲�����
 *
 * Created by zfz on 2017/11/11.
 */
public class Stream02 {

    public static void main(String[] args) {

        // ����һ���б�
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        // ������������

        // ��һ����������
        Optional<Integer> productObj = myList.stream().reduce((a, b)->{
            return  a*b;
        });
        if (productObj.isPresent()){
            System.out.println("Product as optional:  "+productObj.get());
        }

        // �ڶ����������� identity�ǵ�λֵ����˼
        // �ۼƺ����ǳ˷���ʱ�� identity��1
        // �ۼƺ����Ǽӷ���ʱ�� identity��0
        // reduce() ������ a��ʾ�����ۼƽ���е�ǰ��ֵ b ��ʾ����������һ��Ԫ��
        int product = myList.stream().reduce(1, (a, b)->a*b);
        System.out.println("Product as int:  "+product);

        // �����б���ż���ĳ˻�
        int product1 = myList.stream().reduce(1, (a, b)->{
            if (b%2==0) return a*b;
            else return a;
        });
        System.out.println("�б���ż���ĳ˻� "+product1);
    }


}
