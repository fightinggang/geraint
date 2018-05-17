package com.oner.pratice.algorithm;

import java.util.Arrays;

/**
 * @author Geraint
 * <p>
 * http://blog.csdn.net/wuxinyicomeon/article/details/5996675
 * 排序方法   最差时间分析	        平均时间复杂度	    稳定度	空间复杂度
 * 冒泡排序	    O(n2)	        O(n2)	        稳定	    O(1)
 * 快速排序	    O(n2)	        O(n*log2n)	    不稳定	O(log2n)~O(n)
 * 选择排序	    O(n2)	        O(n2)	        稳定	    O(1)
 * 二叉树排序	    O(n2)	        O(n*log2n)	    不一顶	O(n)
 * 插入排序      O(n2)	        O(n2)	        稳定	    O(1)
 * 堆排序	       O(n*log2n)	    O(n*log2n)	    不稳定	O(1)
 * 希尔排序	    O	            O	            不稳定	O(1)
 */
public class Sort {
    public static void main(String[] args) {
        int[] scores = new int[]{1, 8, 4, 7, 6, 15, 9, 2};
        System.out.println("======冒泡排序=======");
        int[] bubbleResult = bubbleSort(scores);
        System.out.println(Arrays.toString(bubbleResult));

        System.out.println("======选择排序=======");
        int[] selectionResult = selcetionSort(scores);
        System.out.println(Arrays.toString(selectionResult));

        System.out.println("======插入排序=======");
        int[] insertionResult = insertionSort(scores);
        System.out.println(Arrays.toString(insertionResult));
    }

    /**
     * 冒泡排序：两两比较
     * 已优化后的方法。
     *
     * @param sourceArray ：源数组
     * @return*/

    private static int[] bubbleSort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < array.length - 1; i++) {
            // 标识符，若没有发生交换则说明已有序
            boolean flag = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    /**
     * 选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第二步，直到所有元素均排序完毕。
     *
     * @param sourceArray
     * @return
     */
    private static int[] selcetionSort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // 最小值与 i 的值提哈un
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param sourceArray
     * @return
     */
    private static int[] insertionSort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int index = 0; index < array.length; index++) {
            // 获得需要插入的数值
            int key = array[index];
            // 下标值
            int position = index;
            // 获得需要插入的数值
            while (position > 0 && key < array[position - 1]) {
                array[position] = array[position - 1];
                position--;
            }
            // 存在比其小的数，插入
            if (position != index) {
                array[position] = key;
            }
        }
        return array;
    }
}
