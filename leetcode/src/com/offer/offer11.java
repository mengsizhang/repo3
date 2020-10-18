package com.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class offer11 {
    public int minArray(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (numbers[mid] > numbers[end]) {//旋转点一定在右排序空间即[mid+1,end]
                start = mid + 1;
            } else if (numbers[mid] < numbers[end]) {//旋转点一定在左排序空间[start,mid]
                end = mid;
            } else {//相等时无法判断在哪个排序空间，只能缩小查找范围
                end--;
            }
        }
        return numbers[end];//当start=end=mid时就退出循环了
    }
}
