package com.algorithm;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SolutionQ820 {
    public int minimumLengthEncoding(String[] words) {
        int[] flag = new int[words.length];
        int length = 0;
        int totallength = 0;
        int numflag = 0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if((words[i].length()>words[j].length()&&flag[j]==0)||
                        ((words[i].length()==words[j].length()&&flag[j]==0&&i>j))){
                    boolean isrecover = true;
                    int p=words[i].length()-1;
                    int q=words[j].length()-1;
                    while(q>=0&&isrecover){
                        if(words[i].charAt(p)!=words[j].charAt(q)){
                            isrecover = false;
                        }
                        q--;p--;
                    }
                    if(isrecover==true){
                        length+=words[j].length();
                        flag[j]=1;
                        numflag++;
                    }

                }
            }
        }
        for(int i=0;i<words.length;i++){
            totallength+=words[i].length();
        }
        return totallength+words.length-numflag-length;
    }

    public int minimumLengthEncoding1(String[] words) {
        Set<String> set= new HashSet<>();
        for(String s:words){
            set.add(s);
        }
        for(String word:words){
            for(int k=1;k<word.length();k++){
                set.remove(word.substring(k));
            }
        }
        int ans = 0;
        for(String word:set){
            ans += word.length()+1;
        }
        return ans;
    }
}
