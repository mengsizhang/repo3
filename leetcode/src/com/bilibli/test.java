package com.bilibli;

public class test {
    public int GetMaxConsecutiveOnes(int[] arr, int k) {
        if (arr == null) {
            return 0;
        }
        int left = 0, right = 0;
        int[] map = new int[2];
        int historyCharMax = 0;
        for (; right < arr.length; right++) {
            map[arr[right]]++;
            historyCharMax = Math.max(historyCharMax, map[1]);
            if (historyCharMax + k < right - left + 1) {
                map[arr[left]]--;
                left++;
            }
        }
        return right - left;
    }
}
