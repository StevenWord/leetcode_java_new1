package com.algorithm;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;

public class SolutionQ3{
    //use HashSet,
        public static int lengthOfLongestSubString(String s){
              int n=s.length();
              HashSet<Character>set=new HashSet<Character>();
              int ans=0,i=0,j=0;
              while(i<n&&j<n){
                      if(!set.contains(s.charAt(j))){
                                set.add(s.charAt(j++));
                                ans=Math.max(ans,j-i);
                      }
                      else{
                          set.remove(s.charAt(i++));
                      }
                }
              return ans;
        }
        // use HashMap
    public static int lengthOfLongestSubString2(@NotNull String s){
            int n=s.length(), ans=0,i=0,j=0;
            HashMap<Character, Integer>map=new HashMap<Character, Integer>();
            while(i<n&&j<n){
                if(map.containsKey(s.charAt(j))){
                    i=Math.max(map.get(s.charAt(j))+1,i);//省略了删除map的步骤
                }
                ans=Math.max(ans,j-i+1);
                map.put(s.charAt(j),j);
                j++;
            }
            return ans;
    }


}
