package com.cleverdb;

/**
 * 
 * ��������
 * ʱ�临�Ӷ�:O(N)--->O(N*logN)
 * @author Bo.Dong
 *
 */
public class RadixSort {

	static void sort(int[] array, int radix){
		int len = array.length;
		int temp = 0;//��ʱ��¼�����±�
		int div = 1;//���� 1...10...100
		int[][] bucket = new int[10][len];//��ά���飬��Ŷ�Ӧ������ֵ
		int[] number=new int[len];//���ڼ�¼ÿ��Ͱ���ж��ٸ�����
		int maxRadix = maxRadix(array, radix);//��ȡ�������λ��
		for(int i = 0 ; i <= maxRadix; i++){//����ѭ������
			for(int j = 0 ; j < len; j++){//�������ݵ���Ӧ��Ͱ
				int val = array[j];
				int bucketIndex = (val/div) % radix;
				bucket[bucketIndex][number[bucketIndex]]=val;
				number[bucketIndex]++;
			}
			
			for(int k= 0; k<len; k++){//��˳��ȡ��ÿ��Ͱ���ݣ�������������
				if(number[k] > 0){
					for(int j= 0 ;j<number[k]; j++){
						array[temp] = bucket[k][j];
						temp++;
					}
					number[k] = 0;//��ռ�¼��
				}
				
			}
			temp = 0;//�����±��0�������´�ѭ��
			div*=radix;//
			
		}
		
	}
	
	/**
	 * @param array
	 * @param radix
	 * @return
	 */
	private static int maxRadix(int[] array, int radix){
		int max = getMax(array);
		int n = 1, i = max;
		do {
		    i /=radix;
			n++;
		} while (i > radix);
		return n;
	}
	
	/**
	 * @param array
	 * @return
	 */
	private static int getMax(int[] array){
		int max = array[0];
		for(int val : array){
			if(val > max)
				max = val;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] array = {773, 22, 93, 43, 101, 14, 28, 65, 39, 81, 1005};
		sort(array, 10);
		for (int a : array) {
			System.out.println(a);
		}
	}
}
