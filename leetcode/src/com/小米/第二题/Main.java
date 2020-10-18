package com.小米.第二题;

import java.util.Scanner;

public class Main {
    static boolean flag=false;
    static int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      String str=sc.nextLine();
      char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
      if(exist(board,str)){
          System.out.println("true");
      }else{
          System.out.println("false");
      }
    }
    public static boolean exist(char[][] board,String word){
        if(board==null||board.length==0||word==null||word.length()==0){
            return false;
        }
        boolean[][] marked=new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]==word.charAt(0)){
                    marked[i][j]=true;
                    dfs(board,marked,word,i,j,1);
                    marked[i][j]=false;
                }
            }
        }
        return flag;
    }
    public static void dfs(char[][] board,boolean[][] marked,String word,int i,int j,int index){
        if(flag==true){return;}
        if(index==word.length()){
            flag=true;
            return;
        }
        for (int k = 0; k <directions.length ; k++) {
            int nexti=i+directions[k][0];
            int nextj=j+directions[k][1];
            if(nexti>=0&&nexti<board.length&&nextj>=0&&nextj<board[0].length&&board[nexti][nextj]==word.charAt(k)){
                marked[nexti][nextj]=true;
                dfs(board, marked, word, nexti, nextj, index+1);
                marked[nexti][nextj]=false;
            }
        }
    }
}
