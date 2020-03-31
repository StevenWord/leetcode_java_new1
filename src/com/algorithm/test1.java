package com.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public  class test1{
    public void test(){
        Map<Integer,String> map= new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");
        /**
         * 迭代器遍历map
         */
        Iterator it =  map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry) it.next();
            System.out.println("迭代器遍历map"+entry.getKey()+": "+entry.getValue());
        }
        /**
         * 迭代器遍历map的key
         */
        Iterator itkey =  map.keySet().iterator();
        while(itkey.hasNext()){
            int key = (int)itkey.next();
            System.out.println("迭代器遍历map的key"+key);
        }
        /**
         * 迭代器遍历map的value
         */
        Iterator itvalue =  map.values().iterator();
        while(itvalue.hasNext()){
            String string= (String) itvalue.next();
            System.out.println("迭代器遍历map的value"+string);
        }
    }

}
