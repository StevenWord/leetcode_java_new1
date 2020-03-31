package com.algorithm;

import com.designpatterns.listener.Button;
import com.designpatterns.listener.Listener;
import com.designpatterns.listener.MouseOnListener;
import com.designpatterns.listener.OnClickListener;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =0;
        if(scanner.hasNext())
            n=scanner.nextInt();
        if(n==0){
            System.out.println(0);
            return;
        }
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int ans =getgcd(i,j);
                max=Math.max(i*j/ans-ans,max);
            }
        }
        System.out.println(max);
    }
    private static int getgcd(int i,int j){
        int min = Math.min(i,j);
        int max = Math.max(i,j);
        int gcd = 1;
        for(int a=min;a>=0;a--){
            if(min%a==0&&max%a==0){
                gcd=a;
                return gcd ;
            }
        }
        return gcd;
    }


}

