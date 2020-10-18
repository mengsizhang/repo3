package com.nowcoder.网易.下厨房;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNextLine()){
            String[] array=sc.nextLine().split(" ");
            for (int i = 0; i <array.length ;++i) {
                set.add(array[i]);
            }
        }
        System.out.println(set.size());
    }
}
