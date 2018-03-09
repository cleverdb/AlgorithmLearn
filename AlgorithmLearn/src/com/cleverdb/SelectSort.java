package com.cleverdb;


/**
 * ѡ������
 * ԭ���������һ�ʼ���ҵ�������С�����λ��
 * ʵ�֣����for����ǰδ������index���ڲ�for�����Ƚ����ȡ��Сֵindex
 * �㷨ά�ȣ����ð�����򣬽��������ݽ������������ǱȽϴ���Ϊ���� �����Ӷ�O(N2)
 * @author Bo.Dong
 *
 */
public class SelectSort {

	public static  void sort(int[] array){
		
		int len = array.length;
		for(int out = 0 ; out < len-1 ; out++ ){
			//Ĭ�ϵ�ǰindexֵ��С
			int tempIndex = out;
			for(int in = out + 1 ; in < len; in++){
				//����Сֵ�Ƚ�
				if(array[tempIndex] > array[in]){
					//�滻��Сֵindex
					tempIndex = in;
				}
			}
			//swapֵ
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
