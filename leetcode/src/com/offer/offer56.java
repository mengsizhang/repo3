package com.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class offer56 {
     public int[] singleNumbers(int[] nums) {
         Arrays.sort(nums);
         int[] res = new int[2];
         for (int i = 0; i <nums.length ;) {
             if(i+1<nums.length&&nums[i]==nums[i+1]){
                 i+=2;
             }else{
                if(res[0]==0){
                    res[0]=nums[i];
                }else{
                    res[1]=nums[i];
                }
                 i++;
             }
         }
         return res;
     }
}
