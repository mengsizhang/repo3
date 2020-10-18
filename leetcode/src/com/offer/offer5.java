package com.offer;

import java.util.Arrays;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class offer5 {
   /* public String replaceSpace(String s) {
      StringBuilder sb = new StringBuilder();
        for (Character c:s.toCharArray()) {
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }*/
    public String replaceSpace(String s) {
        int len =s.length();
        char[] str = new char[len*3];
        int size =0;
        for (int i = 0; i <len ; i++) {
            char c = s.charAt(i);
            if(c==' '){
                str[size++]='%';
                str[size++]='2';
                str[size++]='0';
            }else{
                str[size++]=c;
            }
        }
        String newStr = new String(str,0,size);
        return newStr;
    }
}
