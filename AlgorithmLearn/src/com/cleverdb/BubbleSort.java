package com.cleverdb;

import java.util.Hashtable;
import java.util.TreeMap;

/**
 * 冒泡排序
 * 原理：通过比较相邻两项，交换位置
 * 实现：外层for循环控制每次比较次数（第一次，所有项都需要比较，所以是length-1次，次数依次递减，第一次循环完，最大结果在最后一项）,内层for循环控制相邻数据比较，
 * 算法维度：N*(1+N)/2 ==>  O（N2）
 * @author Bo.Dong
 *
 *
 */

public class BubbleSort {

	public static void sort(int[] array){
		int len = array.length;
		Hashtable<K, V>
		//控制比较的次数
		for(int out = len - 1; out > 1 ; --out ){
			//
			for(int in = 0 ; in < out; in++){
				//相邻值比较，交换位置
				if(array[in] > array[in+1]){
					int temp = array[in];
					array[in] = array[in+1];
					array[in+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {6,8,3,4,7,9};
		sort(array);
		for(int a : array){
			System.out.println(a);
		}
	}
}
