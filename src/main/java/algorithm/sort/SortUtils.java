package algorithm.sort;


import java.util.Arrays;

/**
 * 排序工具类
 * @author TCW
 */
public class SortUtils {

    /**
     * 交互数组中的两个数
     * @param array 待交互的元素所在的数组
     * @param a 待交互的第一个数的下标
     * @param b 待交互的第二个数的下标
     * @return
     */
    public static <T> boolean swap(T[] array,int a,int b){
        T tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
        return  true;
    }

    /**
     * 判断第一个数是否小于第二个数
     * @param a
     * @param b
     * @return
     */
    public static <T extends Comparable<T>> boolean less(T a,T b){
        return a.compareTo(b)<0;
    }

    /**
     * 打印输出
     * @param toPrint
     */
    static void print(Object[] toPrint){
        System.out.println(Arrays.toString(toPrint));
    }
}
