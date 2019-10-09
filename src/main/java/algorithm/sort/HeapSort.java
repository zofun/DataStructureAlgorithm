package algorithm.sort;
import com.sun.scenario.effect.impl.HeapImage;
import sun.misc.LRUCache;

import static algorithm.sort.SortUtils.*;


/**
 * 堆排序
 * @author TCW
 */
public class HeapSort implements SortAlgorithm {
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int size=unsorted.length;
       Heap<T> heap=new Heap<T>(unsorted);
       heap.makeMinHeap(0);
       T[] sorted=(T[]) new Comparable[unsorted.length];
       int i=0;
       while (size>0){
           sorted[i++]=heap.gerRoot(--size);
       }

       return sorted;

    }


    private static class Heap<T extends Comparable<T>>{
        private T[] heap;

        public Heap(T[] heap){
            this.heap=heap;
        }
        private void heapSubtree(int rootIndex,int lastChild){
            int leftIndex=rootIndex*2+1;
            int rightIndex=rootIndex*2+2;
            T root=heap[rootIndex];
            if(rightIndex<=lastChild){
                T left=heap[leftIndex];
                T right=heap[rightIndex];
                if(less(left,right)&&less(left,root)){
                    swap(heap,leftIndex,rootIndex);
                    heapSubtree(leftIndex,lastChild);
                }else if(less(right,root)) {
                    swap(heap,rightIndex,rootIndex);
                    heapSubtree(rightIndex,lastChild);
                }
            }else if(leftIndex<=lastChild){
                //如果没有右孩子，但是有左孩子
                T left=heap[leftIndex];
                if(less(left,root)){
                    swap(heap,leftIndex,rootIndex);
                    heapSubtree(leftIndex,lastChild);
                }
            }
        }

        private void makeMinHeap(int root){
            int leftIndex=root*2+1;
            int rightIndex=root*2+2;
            boolean hasLeftChild=leftIndex< heap.length;
            boolean haRightChild=rightIndex< heap.length;
            if(haRightChild){
                makeMinHeap(leftIndex);
                makeMinHeap(rightIndex);
                heapSubtree(root,heap.length-1);
            }else if(hasLeftChild){
                heapSubtree(root,heap.length-1);
            }
        }

        private T gerRoot(int size){
            swap(heap,0,size);
            heapSubtree(0,size-1);
            return heap[size];
        }

    }
}
