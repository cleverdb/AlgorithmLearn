
package com.cleverdb;

/**
 * ϣ���㷨
 * ͨ�����ϵ�������ٸ����ƶ����������ڲ�������
 * ʱ�临�Ӷȣ�O(N*(logN)^2)
 * @author Bo.Dong
 *
 */
public class ShellSort {

	static void sort(int[] arr){
		int len = arr.length;
		int h = 1;
		while(h <= len/3)//Ѱ�Һ��ʵļ������
			h = h*3+1;
		
		while(h>0){//�𲽼�С���ֵ�������1
			//���ģ���������
			for(int i = h; i < len; i++){// �Ӽ��ֵh��ʼδ����
				int n = i;
				int temp = arr[n];//��ʱֵ
				while(n >= h && temp <= arr[n-h] ){//��n>=h,��֤index���ڻ��ߵ���0�� �Ƚ���Ϊ�˽���λ��
					arr[n] = arr[n-h];
					n-=h;
				}
				arr[n]  = temp;//����������ֵ
			}
			h = (h-1)/3;//��С���ֵ
		}
	}
	public static void main(String[] args) {
		int[] array = { 6, 8, 3, 4, 9, 7, 15, 24, 10, 14, 1, 5, 11};
		sort(array);
		for (int a : array) {
			System.out.println(a);
		}
	}
}
