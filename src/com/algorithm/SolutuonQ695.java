package com.algorithm;

public class SolutuonQ695 {
    int [][] flag;
    public int maxAreaOfIsland(int[][] grid) {
        flag = new int[grid.length][grid[0].length];
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(flag[i][j]==0&&grid[i][j]==1){
                    flag[i][j]=1;
                    int temp=dfs(grid,i,j);
                    max = Math.max(max,temp+1);
                }

            }
        }
        return max;
    }
    public int dfs(int [][] grid,int i,int j){
        int depth = 0;
        if(i-1>=0&&flag[i-1][j]==0&&grid[i-1][j]==1){
            flag[i-1][j]=1;
            depth++;
            depth=depth+dfs(grid,i-1,j);
        }
        if(i+1<grid.length&&flag[i+1][j]==0&&grid[i+1][j]==1){
            flag[i+1][j]=1;
            depth++;
            depth=depth+dfs(grid,i+1,j);
        }
        if(j-1>=0&&flag[i][j-1]==0&&grid[i][j-1]==1){
            flag[i][j-1]=1;
            depth++;
            depth=depth+ dfs(grid,i,j-1);
        }
        if(j+1<grid[i].length&&flag[i][j+1]==0&&grid[i][j+1]==1){
            flag[i][j+1]=1;
            depth++;
            depth=depth+dfs(grid,i,j+1);
        }
        return depth;
    }
}
