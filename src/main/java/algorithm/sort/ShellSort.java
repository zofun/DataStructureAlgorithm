package algorithm.sort;

import com.sun.javafx.collections.SortableList;

/**
 * @ClassName : ShellSort
 * @Author : TCW
 * @Date: 2020-05-06 21:11
 */
public class ShellSort implements SortAlgorithm {
    public <T extends Comparable<T>> T[] sort(T[] arr) {
        int len=arr.length;
        int h=1;
        while (h<len/3){
            h=h*3+1;
        }
        while (h>=1){
            for (int i=h;i<len;i++){
                for (int j=i;j>=h&&SortUtils.less(arr[j],arr[j-h]);j-=h){
                    SortUtils.swap(arr,j,j-h);
                }
            }
            h/=3;
        }

        return arr;
    }
}
