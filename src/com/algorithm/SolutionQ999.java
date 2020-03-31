package com.algorithm;

public class SolutionQ999 {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        boolean notMeet = true;
    b:    for(int i=0;i<board.length;i++){
            boolean flag = false;
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='p'&&notMeet)
                    flag = true;
                if(board[i][j]=='B'&&notMeet)
                    flag = false;
                if(board[i][j]=='R'&&flag==true&&notMeet){
                    count++;
                    notMeet = false;
                    continue ;
                }
                if(notMeet&&board[i][j]=='R'){
                    notMeet = false;
                    continue ;
                }
                if(notMeet==false&&board[i][j]=='p'){
                    count++;
                    break  b;
                }
                if(notMeet==false&&board[i][j]=='B'){
                    break b;
                }
                if(notMeet==false&&j==board.length-1)
                    break b;

            }
        }
        notMeet = true;
    a:    for(int j=0;j<board.length;j++){
            boolean flag = false;
            for(int i=0;i<board.length;i++){
                if(board[i][j]=='p'&&notMeet)
                    flag = true;
                if(board[i][j]=='B'&&notMeet)
                    flag = false;
                if(board[i][j]=='R'&&flag==true&&notMeet){
                    count++;
                    notMeet = false;
                    continue ;
                }
                if(notMeet&&board[i][j]=='R'){
                    notMeet = false;
                    continue ;
                }
                if(notMeet==false&&board[i][j]=='p'){
                    count++;
                    break a;
                }
                if(notMeet==false&&board[i][j]=='B'){
                    break a;
                }
                if(notMeet==false&&i==board.length-1)
                    break a;

            }
        }
        return count;
    }
}
