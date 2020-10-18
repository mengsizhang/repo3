package com.bilibli;

public class first {
    public String baseNeg2(int N) {
        StringBuffer res = new StringBuffer(40);
        while (N != 0) {
            int mod = N % (-2);
            N /= -2;
            if (mod == -1) {
                res.append(1);
                N++;
            } else {
                res.append(mod);
            }
        }
        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}
