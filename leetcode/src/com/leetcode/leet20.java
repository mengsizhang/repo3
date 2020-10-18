package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class leet20 {
    Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    //用栈结构来解决这个问题
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);//一个一个字符来判断
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();//如果栈为空，则设置一个哑值进去，否则弹出当前栈顶元素
                if (topElement != map.get(c)) {//判断栈顶元素与当前map的value是否相等即是否左符号与右符号是否匹配，如果不相等即不匹配，直接返回false
                    return false;
                }
            } else {
                stack.push(c);//如果不在map里，说明是左符号，那就直接入栈就OK
            }
        }
        return stack.isEmpty();//最后根据栈是否为空来判定是否所有符号都配对成功，若栈不为空说明没有完全配对成功，则是false
    }
}
