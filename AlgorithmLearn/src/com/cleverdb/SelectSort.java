package com.cleverdb;


/**
 * 选择排序
 * 原理：从数组第一项开始，找到数组最小项，调换位置
 * 实现：外层for：当前未排序项index，内层for：待比较项，获取最小值index
 * 算法维度：相对冒泡排序，降低了数据交换次数，但是比较次数为降低 ，复杂度O(N2)
 * @author Bo.Dong
 *
 */
public class SelectSort {

	public static  void sort(int[] array){
		
		int len = array.length;
		for(int out = 0 ; out < len-1 ; out++ ){
			//默认当前index值最小
			int tempIndex = out;
			for(int in = out + 1 ; in < len; in++){
				//与最小值比较
				if(array[tempIndex] > array[in]){
					//替换最小值index
					tempIndex = in;
				}
			}
			//swap值
			int temp = array[tempIndex];
			array[tempIndex] = array[out];
			array[out] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {6,8,3,4,9,7};
		sort(array);
		for(int a : array){
			System.out.println(a);
		}
		System.out.println();
	}
}
