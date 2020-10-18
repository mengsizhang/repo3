package com.bilibli;

import java.util.*;

public class Solution {
    public int GetFragment(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        if(str.length()==1){
            return 1;
        }
        StringBuilder sb= new StringBuilder();
        Set<String> set = new HashSet<>();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i)==str.charAt(i-1)){
                sb.append(str.charAt(i));
            }else{
                set.add(sb.toString());
                sb=new StringBuilder();
                sb.append(str.charAt(i));
            }
        }
        return str.length()/set.size();
    }
}
