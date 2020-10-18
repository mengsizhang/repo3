package com.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class offer12 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, col = board[0].length, strLen = word.length();
        if (strLen > rows * col) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board
     * @param words
     * @param i
     * @param j
     * @param k 字符串里字符的索引
     * @return
     */
    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //递归终止条件：越界、二维数组的字符与要找的字符不匹配，要匹配的字符串全都成功匹配(字符索引到头了)
        if (i > board.length - 1 || i < 0 || j > board[0].length - 1 || j < 0 || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        char tmp =board[i][j];//因为不能走回头路，已经匹配过的字符不能再进去，所以先记录下每次访问的字符
        board[i][j]='/';//将每次访问的字符置为'/'，以至于不可能再匹配
        boolean res = dfs(board,words,i-1,j,k+1)||dfs(board,words,i+1,j,k+1)||dfs(board,words,i,j-1,k+1)||dfs(board,words,i,j+1,k+1);
        board[i][j]=tmp;//回溯，如果该条路径没走通，要回退，要把原本被标记的字符恢复为原样
        return res;
    }
}
