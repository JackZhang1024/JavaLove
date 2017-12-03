package java8.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * ��API�Ĺؼ�һ�������ܹ�ִ�зǳ����ӵĲ��ҡ����˺�ӳ�����ݵȲ���
 * ����˵ ��API�ṩ�˼����õ����ݴ���ʽ
 *
 * 1. �м���� ��״̬֮�� ��Ϊ 1.��״̬ 2.��״̬
 * 2. �ն˲���
 *
 * Created by zfz on 2017/11/11.
 */
public class Stream01 {

    public static void main(String[] args) {

        // ����һ��Integer����
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Original list: "+myList);

        // ��ȡ������ϵ���
        Stream<Integer> myStream = myList.stream();

        // ��ȡ�����е���Сֵ
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if (minVal.isPresent()){
            System.out.println("Minimum is "+minVal.get());
        }

        // �����ϱߵ�ʹ�����ն˲���stream.min() ���¸��������ѹ���
        // ������ʹ�� �����ʹ���� �ͱ�������stream()
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent()){
            System.out.println("Maximum is "+maxVal.get());
        }
        System.out.println();

        //�Լ��Ͻ������� Ĭ�ϵ�Ӧ������������
        Stream<Integer> sortedStream = myList.stream().sorted();
        sortedStream.forEach((n)-> System.out.println(n+""));
        System.out.println();

        // �Լ��Ͻ��й��˲��� ��ü����е�����
        Stream<Integer> oddVals = myList.stream().sorted()
                .filter(n->n%2 == 1);
        oddVals.forEach(n-> System.out.println(n+""));
        System.out.println();

        // �Լ��Ͻ��в��� ��ȡ�����д���5������
        oddVals = myList.stream()
                .sorted()
                .filter(n->n%2==1)
                .filter(n->n>5);
        oddVals.forEach(n-> System.out.println(n+""));
        System.out.println();
    }
}
