package com.cleverdb;

/**
 * 快速排序
 * 1：从数组中取出一个数作为基数
 * 2：将比这个数大的数全部放到它的左边，小于或者等于的数全部放到它的右边
 * 3：再对左右区间重复第二步，直到各区间只有一个数
 * 时间复杂度O(N*logN)
 * @author V.Bo.Dong
 *
 */
public class QuickSort {

	static void sort(int[] array){
		sort(array, 0, array.length-1);
	}
	
	static void sort(int[] array,int left, int right){
	
		if(right <= left) return;
		int l=left, r=right;//l左侧下标，r右侧下标
		int pivot = array[left];
		while(l < r){
			while(l < r && array[r] >= pivot){
				r--;
			}
			while(l < r && array[l] <= pivot){
			    l++;
			}
			if(l < r){
				int temp = array[r];
				array[r] = array[l];
				array[l] = temp;
			}
		}
		array[left] = array[l];
		array[l] = pivot;
		sort(array, left, l-1);
		sort(array, l+1, right);
	}
	public static void main(String[] args) {
		//int[] array = {6, 1, 2, 7, 9, 11, 4, 5, 10, 8};
		int[] array = {6, 1, 2, 4, 5};
		sort(array);
		for(int a : array){
			System.out.println(a);
			
		}
	}
}
