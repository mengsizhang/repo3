package com.leetcode;

/**
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；
 * 类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class leet38 {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder();
        int prev = 0;
        int curr = 1;
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);//采用递归实现
        for (curr = 1; curr < str.length(); curr++) {
            if (str.charAt(prev) != str.charAt(curr)) {//如果碰到当前字符与之前的字符不相等时更新字符串
                int count = curr - prev;//之前字符连续出现的次数
                res.append(count).append(str.charAt(prev));
                prev = curr;
            }
        }
        if (prev != curr) {//防止最后一段数相等，但此时curr已经走到了字符串末尾，依然没有符合if 条件，导致最后一段相等的数还没添加到字符串里，所以写这个来补充
            int count = curr - prev;
            res.append(count).append(str.charAt(prev));
        }
        return res.toString();
    }
}
