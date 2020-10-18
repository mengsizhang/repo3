package com.搜狗.编程题二;

public class Solution {
    public boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        int i = 0, j = str.length() - 1;
        while (i < j) {
            while (i < j && !isCharOrNum(str.charAt(i))) {
                i++;
            }
            while (i < j && !isCharOrNum(str.charAt(j))) {
                j--;
            }
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isCharOrNum(char a) {
        return (a >= '0' && a <= '9') || (a >= 'a' && a <= 'z');
    }
}
