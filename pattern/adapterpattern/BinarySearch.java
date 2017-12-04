package adapterpattern;

/**
 * 二分法搜索
 * Created by zfz on 2017/12/11.
 */
public class BinarySearch {

    public int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal > key) {
                high = midVal - 1;
            } else if (midVal < key) {
                low = midVal + 1;
            } else {
                return 1; // 找到元素返回1
            }
        }
        return -1; // 没有找到元素返回 -1
    }

}
