package com.cleverdb;

import java.util.Hashtable;
import java.util.TreeMap;

/**
 * ð������
 * ԭ��ͨ���Ƚ������������λ��
 * ʵ�֣����forѭ������ÿ�αȽϴ�������һ�Σ��������Ҫ�Ƚϣ�������length-1�Σ��������εݼ�����һ��ѭ���꣬����������һ�,�ڲ�forѭ�������������ݱȽϣ�
 * �㷨ά�ȣ�N*(1+N)/2 ==>  O��N2��
 * @author Bo.Dong
 *
 *
 */

public class BubbleSort {

	public static void sort(int[] array){
		int len = array.length;
		Hashtable<K, V>
		//���ƱȽϵĴ���
		for(int out = len - 1; out > 1 ; --out ){
			//
			for(int in = 0 ; in < out; in++){
				//����ֵ�Ƚϣ�����λ��
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
