package com.奇安信.第一题;

public class Main {
    public int maxCandies(int[] candies, int[] coin, int n) {
        int sum=0;
        for (int i = 0; i <candies.length ; i++) {
            sum+=candies[i];
        }
        if(n>=candies.length-1){
            return sum;
        }
        int ans=0,count=0;
        for (int i = 0; i <candies.length ; i++) {
            if(candies[i]==0){
                count+=candies[i];
            }
            ans=count;
        }
        for (int i = 0; i <candies.length-n+1 ; i++) {
            int tmp=count;
            for (int j = i; j <i+n ; j++) {
                if(coin[j]==1){
                    tmp+=candies[j];
                }
                ans=Math.max(ans,tmp);
            }
        }
        return ans;
    }
}
