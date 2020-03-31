package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SolutionQ6 {
    public static String convert(String s,int numRows){
        if(numRows==1)
            return s;
        int i=0,j=0;
        StringBuffer ans= new StringBuffer("");
        for(int cur_row=1;cur_row<=numRows;cur_row++){
            i=numRows-cur_row;
            j=numRows-i-1;
            int flag=0;
            int len=0;
            while(cur_row+len-1<s.length()){
                if(flag==0){
                    if(i!=0)
                        ans.append(s.charAt(cur_row+len-1));
                    len=len+i*2;
                    flag=1;
                }
                else {
                    if(j!=0)
                        ans.append(s.charAt(cur_row + len - 1));
                    len =len+ j*2;
                    flag = 0;
                }
            }
        }
        return ans.toString();
    }
    public static String convert1(String s,int numRows){
        if(numRows==1)
            return s;
        List<StringBuilder> rows=new ArrayList<StringBuilder>();
        for(int i=0;i<Math.min(numRows,s.length());i++)
            rows.add(new StringBuilder());
        int goingDown=1;
        int curRow=0;
        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow==0||curRow==numRows-1)goingDown=(-1)*goingDown;
            curRow+=goingDown;
        }
        StringBuilder ret=new StringBuilder();
        for(StringBuilder row:rows)ret.append(row);
        return ret.toString();

    }
}
