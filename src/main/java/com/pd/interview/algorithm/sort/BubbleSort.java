package com.pd.interview.algorithm.sort;

/**
 * @author wudipangde
 * @Description:XX
 * @date 2021/10/30
 */
public class BubbleSort {
    /**
     * 循环遍历多次，每次把大元素往后调，每次确定一个最大值，多次排序达到排序队列
     */
    private static int[] bubbleSort(int[] arr){
        if(arr ==null || arr.length==0){
            return arr;
        }
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length-1-i;j++){
                int temp =0;
                if(arr[j]>arr[j+1]){
                    temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,3,2,8,9,7};
        for(int a:bubbleSort(arr)){
            System.out.print(a+",");
        }
    }
}
