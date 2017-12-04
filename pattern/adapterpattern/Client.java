package adapterpattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class Client {

    public static void main(String[] args) {
       ScoreOperation operation = new OperationAdapter();
       int[] scores = new int[]{82, 93, 49, 67, 78};
       int[] results = operation.sort(scores);
       for (int index =0; index < results.length; index++){
           System.out.println("score "+results[index]);
       }
       int score = operation.search(scores, 78);
       if (score!=-1){
           System.out.println("找到成绩");
       }else{
           System.out.println("没找到成绩");
       }

    }

}
