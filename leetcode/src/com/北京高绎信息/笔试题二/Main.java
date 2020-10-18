package com.北京高绎信息.笔试题二;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arry = sc.nextLine().split(" ");
            int[] nums = new int[arry.length];
            for (int i = 0; i < arry.length; i++) {
                nums[i] = Integer.parseInt(arry[i]);
            }
            int target = Integer.parseInt(sc.nextLine());
            System.out.println(search(nums, target));
        }
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int middle = 0;
        if (target < nums[low] || target > nums[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (nums[middle] > target) {
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
