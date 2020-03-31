package com.algorithm;

public class SolutionQ892 {
    public int surfaceArea(int[][] grid) {
        int totalsurface = 0;
        int i = grid.length;
        int j = grid[0].length;
        for(int row=0;row<i;row++){
            for(int column=0;column<j;column++){
                if(grid[row][column]!=0)
                    totalsurface +=grid[row][column]*4+2;
                if(column>0){
                    totalsurface-=Math.min(grid[row][column-1],grid[row][column])*2;
                }
                if(row>0){
                    totalsurface-=Math.min(grid[row-1][column],grid[row][column])*2;
                }
            }
        }

        return totalsurface;
    }
}
