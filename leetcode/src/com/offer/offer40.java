package com.offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 */
public class offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1, k);
    }

     int[] quickSort(int[] arr, int l, int h, int k) {
        int m = partition(arr, l, h);
        if (m == k) {
            return Arrays.copyOf(arr, k);
        }
        return m > k ? quickSort(arr, l, m - 1, k) : quickSort(arr, m + 1, h, k);
    }

     int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int pivotIndex = l;
        for (int i = l; i < h; i++) {
            if (arr[i] < pivot) {
                if (i > pivotIndex) {
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, h);
        return pivotIndex;
    }

     void swap(int[] arry, int i, int j) {
        int temp = arry[j];
        arry[j] = arry[i];
        arry[i] = temp;
    }
}
