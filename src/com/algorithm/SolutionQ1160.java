package com.algorithm;

import java.util.HashMap;
import java.util.Iterator;

public class SolutionQ1160 {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> charmap =new HashMap<Character, Integer>();
        for(int i=0;i<chars.length();i++){
            if(!charmap.containsKey(chars.charAt(i)))
                charmap.put(chars.charAt(i),1);
            else charmap.put(chars.charAt(i),charmap.get(chars.charAt(i))+1);
        }
        int length = 0;
        for(int i=0;i<words.length;i++){
            HashMap<Character,Integer> wordmap=new HashMap<>(0);
            for(int j=0;j<words[i].length();j++){
                if(!wordmap.containsKey(words[i].charAt(j)))
                    wordmap.put(words[i].charAt(j),1);
                else wordmap.put(words[i].charAt(j),wordmap.get(words[i].charAt(j))+1);
            }
            Iterator it = wordmap.keySet().iterator();
            boolean flag = true;
            while(it.hasNext()){
                char key = (char)it.next();
                int numwords = wordmap.get(key);
                if(charmap.get(key)==null){
                    flag = false;
                    break;
                }
                int numchars = charmap.get(key);
                if(numchars<numwords){
                    flag = false;
                    break;
                }
            }
            if(flag)
                length+= words[i].length();

        }
        return length;
    }
}

