package adapterpattern;

/**
 * Created by zfz on 2017/12/11.
 */
public class OperationAdapter implements ScoreOperation{
    private QuickSort quickSort;
    private BinarySearch binarySearch;

    public OperationAdapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) { // 调用失陪族
        return quickSort.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return binarySearch.binarySearch(array, key);
    }
}
