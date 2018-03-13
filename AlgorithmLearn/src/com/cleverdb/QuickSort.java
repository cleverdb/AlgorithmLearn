package com.cleverdb;

/**
 * ��������
 * 1����������ȡ��һ������Ϊ����
 * 2����������������ȫ���ŵ�������ߣ�С�ڻ��ߵ��ڵ���ȫ���ŵ������ұ�
 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ����
 * ʱ�临�Ӷ�O(N*logN)
 * @author V.Bo.Dong
 *
 */
public class QuickSort {

	static void sort(int[] array){
		sort(array, 0, array.length-1);
	}
	
	static void sort(int[] array,int left, int right){
	
		if(right <= left) return;
		int l=left, r=right;//l����±꣬r�Ҳ��±�
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
