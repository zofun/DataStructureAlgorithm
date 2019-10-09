package algorithm.sort;



import static algorithm.sort.SortUtils.*;

/**
 * 归并排序
 * 时间复杂度为nlg(n) 空间复杂度为n
 * @author TCW
 *
 */
public class MergeSort implements SortAlgorithm {
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        doSort(unsorted,0,unsorted.length-1);
        return unsorted;
    }

    private <T extends Comparable<T>> void doSort(T[] arr,int L,int R){
        if(L==R){
            return;
        }
        int mid=L+(R-L)/2;
        doSort(arr,L,mid);
        doSort(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private <T extends Comparable<T>> void merge(T[] arr,int L,int mid,int R){
        //java是不支持泛型数组的
        T[] tmp=(T[])new Comparable[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        //比较左右两边的元素，谁小，就把它填入
        //也就是将[L,mid],[mid+1,R]两个区间内的元素有序的合并到tmp中
        while (p1<=mid&&p2<=R){
            tmp[i++]=less(arr[p1],arr[p2])?arr[p1++]:arr[p2++];
        }
        //把剩余的元素填入tmp，以下两个循环只有一个会执行
        while (p1<=mid){
            tmp[i++]=arr[p1++];
        }
        while (p2<=R){
            tmp[i++]=arr[p2++];
        }

        //把合并好的复制给原数组
        for(i=0;i<tmp.length;i++){
            arr[L+i]=tmp[i];
        }

    }
}
