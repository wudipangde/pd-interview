package com.pd.interview.algorithm.sort;

/**
 * @author wudipangde
 * @Description:XX
 * @date 2021/10/30
 */
public class QuickSort {
    /**
     * 1、从序列挑出一个元素，为基准
     * 2、进行重新排序，所有比基准小的分在左边，比基准大的分到右边，进行分区操作
     * 3、递归的 去给两边排序
     */
    private static int[] recursionQuickSort(int[] arr){
        if(arr ==null || arr.length==0){
            return arr;
        }
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=1+i;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min =j;
                }
            }
            if(min!=i){
                int temp =arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,3,2,8,9,7};
        for(int a:recursionQuickSort(arr)){
            System.out.print(a+",");
        }
        for(int a:recursionQuickSort(arr)){
            System.out.print(a+",");
        }
    }
}
