package com.pd.interview.algorithm.arr;

/**
 * @title: Difference
 * @author: wudipangde
 * @date: 2023/9/6 10:46
 */
public class Difference {
    private int[] diff;

    /**输入初始数组*/
    public Difference(int[] nums){
        assert nums.length>0;
        diff = new int[nums.length];
        diff[0] =nums[0];
        for(int i =0;i< nums.length;i++){
            diff[i] =nums[i]-nums[i-1];

        }
    }

    /**给区间增加value*/
    public void incr(int i,int j,int value){
        diff[i] += value;
        if(j+1< diff.length){
            diff[j+1]-=value;
        }
    }
}
