package algorithm.sort;


import static algorithm.sort.SortUtils.*;

/**
 * 快速排序
 * 时间复杂度nlg(n) 空间复杂度lg(n)
 * @author TCW
 */
public class QuickSort implements SortAlgorithm{


    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        doSort(unsorted,0,unsorted.length-1);
        return unsorted;
    }

    private static <T extends Comparable<T>> int partition(T[] array,int left,int right){
        //找到枢轴
        int mid=(left+right)/2;
        T pivot=array[mid];

        //将比枢轴小的放到枢轴的左边，比枢轴大的放到枢轴右边
        while (left<=right){
            while (less(pivot,array[right])){
                right--;
            }
            while (less(array[left],pivot)){
                left++;
            }
            if(left<=right){
                swap(array,right,left);
                left++;
                right--;
            }
        }
        return left;

        //返回数组的分割位置
    }

    private static <T extends Comparable<T>> void doSort(T[] array,int left,int right){
        if(left<right){
            int pivot=partition(array,left,right);
            doSort(array,left,pivot-1);
            doSort(array,pivot,right);
        }
    }
}
