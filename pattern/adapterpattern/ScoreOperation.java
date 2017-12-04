package adapterpattern;

/**
 * Created by zfz on 2017/12/11.
 */
public interface ScoreOperation {

    public int[] sort(int[] array); // 成绩排序
    public int search(int[] array, int key); // 成绩查找
}
