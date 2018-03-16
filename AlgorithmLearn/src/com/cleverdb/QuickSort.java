package com.cleverdb;

/**
 * ��������
 * 1����������ȡ��һ������Ϊ����
 * 2����������������ȫ���ŵ�������ߣ�С�ڻ��ߵ��ڵ���ȫ���ŵ������ұ�
 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ����
 * ʱ�临�Ӷ�O(N*logN)
 * @author Bo.Dong
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
		while(l < r){//��֤����±�С���Ҳ��±�
			//�ӻ�������һ�࿪ʼ����
			while(l < r && array[r] >= pivot){//����>>>�����С�ڻ�����ֵ��Ȼ��ֹͣ
				r--;
			}
			while(l < r && array[l] <= pivot){//����>>>�Ҳ��Ҵ��ڻ�����ֵ��Ȼ��ֹͣ
			    l++;
			}
			if(l < r){//�������ݽ���
				int temp = array[r];
				array[r] = array[l];
				array[l] = temp;
			}
		}
		//�����������ʱ��������С�ڻ������Ҳ���ڻ���
		array[left] = array[l];
		array[l] = pivot;
		//�ݹ�ѭ�����
		sort(array, left, l-1);
		//�ݹ�ѭ���Ҳ�
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
