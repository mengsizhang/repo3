package com.途虎养车.第一题;

public class Main {
    public int combination (int r, int n) {
       r=r<n-r?r:n-r;
       long sum=1;
        for (long i = n; i >n-r ; i--) {
            sum*=i;
        }
        long c1=1;
        for (long i = 1; i <=r ; i++) {
            c1*=i;
        }
        return (int)(sum/c1);
    }
}
