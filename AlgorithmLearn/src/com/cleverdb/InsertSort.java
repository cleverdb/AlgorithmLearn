package com.cleverdb;

import java.util.LinkedList;

/**
 * 插入排序 
 * 原理：将一组数据分成两组，分别将其称为有序组与待插入组。每次从待插入组中取出一个元素，与有序组的元素进行比较，并找到合适的位置，将该元素插到有序组当中。就这样，每次插入一个元素，有序组增加，待插入组减少。直到待插入组元素个数为0。当然，插入过程中涉及到了元素的移动
 * 算法维度：在一般情况下，比冒泡排序快一倍，比选择排序还要快，经常被用在比较复杂的排序算法的最后阶段，例如快速排序。O(N2)
 * @author Bo.Dong
 *
 */
public class InsertSort {

	public static void sort(int[] array) {

		int len = array.length;
		for (int i = 1; i < len; i++) {
			//待插入的数据项
			int temp = array[i];
			//带插入数据前一项，（有序组最末端）
			int before = i-1;
			// 循环比较，待插入项和有序组比较，移动有序组项
			while(before >= 0 && temp < array[before]){
				//若有序组项大于待插入项，向后移动
				array[before+1] = array[before];
				//继续向前比对
				before--;
			}
			//放入待插入项
			array[before+1] = temp;
			
		}
	}

	public static void main(String[] args) {
		int[] array = { 6, 8, 3, 4, 9, 7 };
		sort(array);
		for (int a : array) {
			System.out.println(a);
		}
	}
}
