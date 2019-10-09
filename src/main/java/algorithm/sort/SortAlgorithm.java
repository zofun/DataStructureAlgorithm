package algorithm.sort;



/**
 * @author TCW
 * 排序算法的通用接口
 */
public interface SortAlgorithm {
    /**
     * 排序算法的主方法
     * @param unsorted
     * @param <T>
     * @return
     */
   <T extends Comparable<T>> T[] sort(T[] unsorted);

}
