package com.苏宁易购;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
       Set<Integer> marked=new HashSet<>();
        for (Integer i:arrayA) {
            marked.add(i);
        }
        ArrayList<Integer> res=new ArrayList<>();
        for (Integer i:arrayB) {
            if(marked.contains(i)){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}
