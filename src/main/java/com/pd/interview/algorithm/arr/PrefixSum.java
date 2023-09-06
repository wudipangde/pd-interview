package com.pd.interview.algorithm.arr;

/**
 * @title: PrefixSunm
 * @author: wudipangde
 * @date: 2023/9/6 10:29
 */
public class PrefixSum {
    private int[] preSum;

    /**对数组进行累加*/
    public PrefixSum(int[] nums){
        preSum = new int[nums.length+1];
        for(int i =1;i< nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
    }

    /**进行计算*/
    public int sumRange(int left,int right){
        return preSum[right+1]-preSum[left];
    }

    /**传统思路*/
    public static int sum(int[] nums,int left,int right){
        int sum =0;
        for(int i =0;i< nums.length;i++){
            if((i >=left-1)&&i<right){
                sum += nums[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3,1,4,5};
        PrefixSum p =new PrefixSum(nums);
        System.out.println(p.sumRange(1,5));
        System.out.println(PrefixSum.sum(nums,1,5));
    }


}
