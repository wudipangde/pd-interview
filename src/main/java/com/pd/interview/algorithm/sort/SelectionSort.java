package com.pd.interview.algorithm.sort;

/**
 * @author wudipangde
 * @Description:XX
 * @date 2021/10/30
 */
public class SelectionSort {
    /**
     * 每次找到最小的值，依次放在最前面
     */
    private static int[] selectionSort(int[] arr){
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
        for(int a:selectionSort(arr)){
            System.out.print(a+",");
        }
    }
}
