package com.搜狗.编程题一;

import java.util.Arrays;

public class Solution {
    public int numberofprize (int a, int b, int c) {
        int max=0;
        int min=0;
        int[] num=new int[3];
        num[0]=a;
        num[1]=b;
        num[2]=c;
        while (true){
            Arrays.sort(num);
            if(num[2]-num[0]<2){
                break;
            }else{
                if(num[2]==num[1]){
                    num[0]++;
                    num[2]--;
                    num[1]--;
                }else{
                    num[2]-=2;
                    num[0]++;
                }
            }
        }
        return num[0];
    }
}
