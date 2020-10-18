package com.奇安信.第二题;

public class Main {
    public int getMaxArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int res=0;
        if (x2 <=x3 && y2 <= y3){
           res= (x3-x1)*(y4-y2);
        }
        return res;
    }
}
