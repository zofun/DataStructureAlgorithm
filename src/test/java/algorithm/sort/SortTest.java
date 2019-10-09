package algorithm.sort;

import org.junit.Assert;
import org.junit.Test;
import static algorithm.sort.SortUtils.*;

public class SortTest {
    private Integer[] IntegerArray={1,7,3,2,6,5,2,9,25,8};
    private Integer[] SortedIntegerArray={1, 2, 2, 3, 5, 6, 7, 8, 9, 25};

    @Test
    public void QuickSortTest(){
        QuickSort quickSort=new QuickSort();
        quickSort.sort(IntegerArray);
        print(IntegerArray);
        Assert.assertArrayEquals(IntegerArray,SortedIntegerArray);
    }

    @Test
    public void MergeSortTest(){
        MergeSort mergeSort=new MergeSort();
        mergeSort.sort(IntegerArray);
        print(IntegerArray);
        Assert.assertArrayEquals(IntegerArray,SortedIntegerArray);
    }

    @Test
    public void HeapSortTest(){
        HeapSort heapSort=new HeapSort();
        Comparable[] sort = heapSort.sort(IntegerArray);
        print(sort);
        Assert.assertArrayEquals(sort,SortedIntegerArray);
    }

}
