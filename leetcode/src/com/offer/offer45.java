package com.offer;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class offer45 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        fastSort(str, 0, nums.length - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            res.append(str[i]);
        }
        return res.toString();
    }

    public void fastSort(String[] str, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = str[i];
        while (i < j) {
            while ((str[j] + str[l]).compareTo(str[l] + str[j]) >= 0 && i < j) {
                j--;
            }
            while ((str[i] + str[l]).compareTo(str[l] + str[i]) <= 0 && i < j) {
                i++;
            }
            String temp = str[i];
            str[i]=str[j];
            str[j]=temp;
        }
        str[l]=str[i];
        str[i]=tmp;
        fastSort(str,l,i-1);
        fastSort(str,i+1,r);
    }
}
