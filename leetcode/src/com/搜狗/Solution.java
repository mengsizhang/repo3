package com.搜狗;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long getPasswordCount(String password) {
        if (password == null || password.length() == 0 || password.length() == 1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            dfs("" + i, password, set, 0, 1);
        }
        return set.contains(password) ? set.size() - 1 : set.size();
    }

    public void dfs(String newPwd, String oldPwd, Set<String> set, int ni, int oi) {
        if (newPwd.length() == oldPwd.length()) {
            set.add(newPwd);
            return;
        }
        int n = (int) (newPwd.charAt(ni) - 48);
        int o = (int) (oldPwd.charAt(oi) - 48);
        if ((n + o) % 2 == 0) {
            int cent = (n + o) / 2;
            dfs(newPwd + cent, oldPwd, set, ni + 1, oi + 1);
        } else {
            int cent = (int) Math.ceil((n + o) / 2.0);
            dfs(newPwd + cent, oldPwd, set, ni + 1, oi + 1);
            cent = (int) Math.floor((n + o) / 2.0);
            dfs(newPwd + cent, oldPwd, set, ni + 1, oi + 1);
        }
    }
}
