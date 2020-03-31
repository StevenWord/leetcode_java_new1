package com.algorithm;

import java.util.HashMap;

public class SolutionQ13 {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);
        int res = 0;
        int cursor = 0;
        for(;cursor<s.length()-1;cursor++){
            if(map.get(s.charAt(cursor))>=map.get(s.charAt(cursor+1))){
                res = res+map.get(s.charAt(cursor));
            }
            else if(map.get(s.charAt(cursor))<map.get(s.charAt(cursor+1))){
                res = res+map.get(s.charAt(cursor+1))-map.get(s.charAt(cursor));
                cursor++;
            }
        }
        if(cursor<s.length())
            res = res+map.get(s.charAt(cursor));
        return res;
    }
}
