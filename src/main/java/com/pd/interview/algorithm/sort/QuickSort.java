package com.pd.interview.algorithm.sort;

import java.util.Stack;

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
    private static int[] quickSortRecursion(int[] arr,int low,int high){
        if(arr ==null || arr.length<=0 || low>=high){
            return arr;
        }
        int left = low ; int right = high;
        //挖坑1：保存基准的值
        int temp = arr[left];
        while(left<right){
            //从后往前找到比基准小的元素，插入到基准位置坑1中
            while(left<right && arr[right]>=temp){
                right --;
            }
            arr[left] =arr[right];
            //从前往后找到比基准大的值，放到坑2的位置
            while(left<right && arr[left]<=temp){
                left++;
            }
            arr[right] =arr[left];
        }
        //基准值补填到坑3中，准备分治递归快排
        arr[left] =temp;
        quickSortRecursion(arr, low, left - 1);
        quickSortRecursion(arr, left + 1, high);
        return arr;
    }

    public static int[] quickSortByStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // 初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while (!stack.isEmpty()) {
            // 出栈进行划分
            int high = stack.pop();
            int low = stack.pop();

            int pivotIdx = partition(arr, low, high);

            // 保存中间变量
            if (pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if (pivotIdx < high && pivotIdx >= 0) {
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }

        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        if (arr.length <= 0) {
            return -1;
        }
        if (low >= high){
            return -1;
        }
        int l = low;
        int r = high;
        // 基准的值
        int pivot = arr[l];
        while (l < r) {
            // 坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while (l < r && arr[r] >= pivot) {
                r--;
            }
            arr[l] = arr[r];
            // 坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while (l < r && arr[l] <= pivot) {
                l++;
            }
            arr[r] = arr[l];
        }

        // 基准值填补到坑3中，准备分治递归快排
        arr[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,3,2,8,9,7};
        for(int a:quickSortRecursion(arr,0,arr.length-1)){
            System.out.print(a+",");
        }
        for(int a:quickSortByStack(arr)){
            System.out.print(a+",");
        }
    }
}
