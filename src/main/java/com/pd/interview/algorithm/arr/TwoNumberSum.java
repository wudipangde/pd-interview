package com.pd.interview.algorithm.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @title: TwoSum
 * @author: wudipangde
 * @date: 2023/3/10 15:43
 */
public class TwoNumberSum {
    /**
     * 暴力破解 (时间复杂度O(N^2))
     */
    public static int[] twoSumBrute(int[] source,int target){
        if(source.length<2){
            return new int[0];
        }
        for(int i=0;i<source.length-1;i++){
            for(int j=i+1;j<source.length;j++){
                if(source[i]+source[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * hash法则
     */
    public static int[] twoSumHash(int[] source,int target){
        if(source.length<2){
            return new int[0];
        }
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<source.length;i++){
            if(map.containsKey(target-source[i])){
                return new int[]{map.get(target-source[i]),i};
            }
            map.put(source[i],i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] source = new int[]{2,3,6};
        int target = 8;
        System.out.println(Arrays.toString(twoSumBrute(source, target)));
        System.out.println(Arrays.toString(twoSumHash(source, target)));
    }
}
