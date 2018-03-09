package com.cleverdb;

import java.util.LinkedList;

/**
 * �������� 
 * ԭ����һ�����ݷֳ����飬�ֱ����Ϊ��������������顣ÿ�δӴ���������ȡ��һ��Ԫ�أ����������Ԫ�ؽ��бȽϣ����ҵ����ʵ�λ�ã�����Ԫ�ز嵽�����鵱�С���������ÿ�β���һ��Ԫ�أ����������ӣ�����������١�ֱ����������Ԫ�ظ���Ϊ0����Ȼ������������漰����Ԫ�ص��ƶ�
 * �㷨ά�ȣ���һ������£���ð�������һ������ѡ������Ҫ�죬���������ڱȽϸ��ӵ������㷨�����׶Σ������������O(N2)
 * @author Bo.Dong
 *
 */
public class InsertSort {

	public static void sort(int[] array) {

		int len = array.length;
		for (int i = 1; i < len; i++) {
			//�������������
			int temp = array[i];
			//����������ǰһ�����������ĩ�ˣ�
			int before = i-1;
			// ѭ���Ƚϣ����������������Ƚϣ��ƶ���������
			while(before >= 0 && temp < array[before]){
				//������������ڴ����������ƶ�
				array[before+1] = array[before];
				//������ǰ�ȶ�
				before--;
			}
			//�����������
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
