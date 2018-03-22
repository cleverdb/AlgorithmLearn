package com.cleverdb;

/**
 * 
 * 基数排序
 * 时间复杂度:O(N)--->O(N*logN)
 * @author Bo.Dong
 *
 */
public class RadixSort {

	static void sort(int[] array, int radix){
		int len = array.length;
		int temp = 0;//临时记录数组下标
		int div = 1;//除数 1...10...100
		int[][] bucket = new int[10][len];//二维数组，存放对应的数组值
		int[] number=new int[len];//用于记录每个桶里有多少个数字
		int maxRadix = maxRadix(array, radix);//获取最大数的位数
		for(int i = 0 ; i <= maxRadix; i++){//控制循环次数
			for(int j = 0 ; j < len; j++){//分配数据到对应的桶
				int val = array[j];
				int bucketIndex = (val/div) % radix;
				bucket[bucketIndex][number[bucketIndex]]=val;
				number[bucketIndex]++;
			}
			
			for(int k= 0; k<len; k++){//按顺序取出每个桶数据，重新排列数据
				if(number[k] > 0){
					for(int j= 0 ;j<number[k]; j++){
						array[temp] = bucket[k][j];
						temp++;
					}
					number[k] = 0;//清空记录数
				}
				
			}
			temp = 0;//数组下表归0，用于下次循环
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