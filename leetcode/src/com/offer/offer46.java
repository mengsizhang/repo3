package com.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class offer46 {
    //可以用 f(i)表示以第 i位结尾的前缀串翻译的方案数
   // case1：每个数字单独翻译有f(i)=f(i-1)种方案；case2：组合某些连续的两位,如果组合的两位范围在10-25之间，则相当于f(i)=f(i-1)+f(i-2);
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];//因为num的第一位num[0]对应的是dp[1]，所以定义长度是len+1
        dp[0] = 1;//假如num=12,有两种翻译方案即 dp[2] = dp[1] + dp[0] = 2，且dp[1]=1,推导得出dp[0]=1
        dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String temp = str.substring(i - 2, i);//左开右闭
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
