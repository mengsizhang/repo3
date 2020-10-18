package com.nowcoder.网易.炮台攻击;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count=0;
            int R = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            if(getDistance(x1,y1,x0,y0)<=R){
                count++;
            }
            if(getDistance(x2,y2,x0,y0)<=R){
                count++;
            }
            if(getDistance(x3,y3,x0,y0)<=R){
                count++;
            }
            System.out.println(count+"x");
        }
    }
    public static double getDistance(int x1,int y1,int x2,int y2){

        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
}
