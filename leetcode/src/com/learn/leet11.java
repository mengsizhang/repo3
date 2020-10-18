package com.learn;

public class leet11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
           res = Math.max(res,Math.min(height[l],height[r])*(r-l));
           if(height[l]<height[r]){//我们每次将对应的数字较小的那个指针往 一个指针的方向移动一个位置
               l++;                // 就表示我们认为 这个指针不可能再作为容器的边界了
           }else{
               r--;
           }
        }
        return res;
    }
}
