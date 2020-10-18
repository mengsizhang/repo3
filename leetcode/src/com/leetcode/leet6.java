package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class leet6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();//创建一个list集合容器，里面的每个元素是一个字符串
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());//循环几次，就创建多少个空的字符串元素
        }
        int currRow = 0;
        boolean flag = false;//控制字符的行的方向，向上还是向下
        //一行就是一个元素，迭代遍历并拼接字符到每一个元素里，
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) {
                flag = !flag;
            }
            currRow += flag ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        //将每行的字符串拼接到一个字符串里
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
