package com.pd.interview.algorithm.datastructure;

/**
 * @author wudipangde
 * @Description: 位运算
 * @date 2021/10/30
 */
public class BitOperate {
    public static void main(String[] args) {
        /**
         * 左移( << )：操作数的非0位左移n位，低位补0
         * 右移( >> )：操作数的非0位右移n位，高位补0
         * 无符号右移( >>> )：正数右移，高位用0补，负数右移，高位用1补，当负数使用无符号右移时，用0进行补位
         * 位非( ~ )：操作数为1则为0，否则为1
         * 位与( & )：第一个数和第二个数，都为1则为1，否则为0
         * 位或( | )：第一个数和第二个数，有一个为1则为1，否则为0
         * 位异或( ^ )：第一个数和第二个数，有一个不相同则为1，否则为0
         */
        System.out.println(5<<1);
        System.out.println(-5>>1);
        System.out.println(~5);
        System.out.println(5&4);
        System.out.println(5|4);
    }
}
