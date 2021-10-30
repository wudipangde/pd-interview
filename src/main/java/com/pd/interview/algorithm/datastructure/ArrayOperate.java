package com.pd.interview.algorithm.datastructure;

import java.util.Arrays;

/**
 * @author wudipangde
 * @Description:XX
 * @date 2021/10/30
 */
public class ArrayOperate {
    private static String[] getReversalString(String[] args){
        if(args==null || args.length ==0){
            return args;
        }
        int j=args.length-1;
        for(int i = 0;i<args.length/2;i++){
            String temp = "";
            temp = args[i];
            args[i]=args[j];
            args[j] =temp;
            j--;
        }
        return args;
    }

    public static void main(String[] args) {
        String[] param ={"c","h","a","n","g","e","r"};
        String[] result = getReversalString(param);
        for(String s:result){
            System.out.print(s+",");
        }
        System.out.println("\n---------");
        int[] a =new int[5];
        a[0] = 3;a[1] = 4;a[3] = 4;
        Arrays.sort(a);
        for(int s:a){
            System.out.print(s+",");
        }

    }
}
