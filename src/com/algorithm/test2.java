package com.algorithm;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=0;
        if(scanner.hasNext())
            n=scanner.nextInt();
        int a[]= new int[n];
        for(int i=0;i<n;i++){
            if(scanner.hasNext())
                a[i]=scanner.nextInt();
        }
        int count = 0;
        for(int i=0;i<n;i++){
            count+=a[i];
        }
        count -= (n-1)*n;
        System.out.println(count);

    }

}
