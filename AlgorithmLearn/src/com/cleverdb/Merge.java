package com.cleverdb;

/**
 * 归并算法
 * @author V.Bo.Dong
 *
 */
public class Merge {

	/**
	 * 
	 * 两个已经有序的数组
	 * @param srcA 有序数组A
	 * @param lengthA 有序数组A的长度
	 * @param srcB 有序数组B
	 * @param lengthB 有序数组B的长度
	 * @param srcC 归并数组
	 */
	static void sort(int[] srcA, int lengthA, int[] srcB, int lengthB, int[] srcC){
		
		int a=0,b=0,c=0;
		
		while(a<lengthA && b<lengthB){
			if(srcA[a] > srcB[b]){
				srcC[c++] = srcB[b++];
			}else{
				srcC[c++] = srcA[a++];
			}
		}
		while(a<lengthA){
			srcC[c++] = srcA[a++];
		}
		while(b<lengthB){
			srcC[c++] = srcB[b++];
		}
	}

	/**
	 * 分治排序--归并排序
	 * 时间复杂度：N*logN
	 * @param array 待排序数组
	 */
	static void sort(int[] array){
		int[] temp = new int[array.length] ;
		triabgleSort(array, temp, 0, array.length-1);
	}
	/**
	 * @param src 需要排序的数组
	 * @param des 临时存放数组
	 * @param low 分组低位
	 * @param hig 分组高位
	 */
	static void triabgleSort(int[] src,  int[] des, int low, int hig){
		if(low == hig){
			return;
		}else{
			int mid = (low+hig)/2;
			//左侧归并排序
			triabgleSort(src, des, low, mid);
			//右侧归并排序
			triabgleSort(src, des, mid+1, hig);
		    //归并数组
			mergeArray(src, des, low, mid, hig);
			
		}
	}
	
	/**
	 * 归并数组
	 * @param src 原数组
	 * @param des 临时数组
	 * @param low 最左侧下标
	 * @param mid 中间值
	 * @param hig 最右侧下标
 	 */
	static void mergeArray(int[] src,  int[] des, int low, int mid, int hig){
		int i = low; //左侧下标指针index
		int j = mid + 1; // 右侧下标指针index
		int index = 0; // 临时数组下标
		while(i <= mid && j <= hig){ // 只有两侧下标都小于临界值，两侧数组才需要比较，否则直接复制到临时数组
			if(src[i] > src[j]){
				des[index++] =src[j++];
			}else{
				des[index++] =src[i++];
			}
		}
		while(i <= mid){//当左侧数组还有值
			des[index++] =src[i++];
		}
		while(j <= hig){//当右侧数组还有值
			des[index++] =src[j++];
		}
		for(int n = 0 ;n < index; n++){//将临时数组的值copy到原数组
			src[low+n] =des[n];
		}
	}
	
	/**
	 * 递归计算 x^y
	 * @param x
	 * @param y
	 * @return
	 */
	static long calculata(int x ,int y){
		if(y == 1){
			return x;
		}
		else{
			if((y&1) != 0) //如果为奇数，则乘以当前数
				return  calculata( x*x, y/2)*x;
			return  calculata( x*x, y/2);
		 }
	}
	
	
	public static void main(String[] args) {
		int[] srcA={3,6,9};
		int[] srcB={4,5,7,10,13};
		int[] srcC = new int[8];
		sort(srcA, 3, srcB, 5, srcC);
		for(int i : srcC){
			System.out.print(i+">");
			
		}
		int [] arr = {20,12,34,45,8,64,78,50,1,40,90,66};
		sort(arr);
		for(int i : arr){
			System.out.print(i+">");
			
		}
		System.out.println(calculata(3, 18));
	}
}
