
package com.cleverdb;

/**
 * 希尔算法
 * 通过间隔系数，减少复制移动次数，基于插入排序
 * 时间复杂度：O(N*(logN)^2)
 * @author Bo.Dong
 *
 */
public class ShellSort {

	static void sort(int[] arr){
		int len = arr.length;
		int h = 1;
		while(h <= len/3)//寻找合适的间隔步数
			h = h*3+1;
		
		while(h>0){//逐步减小间隔值，最后至1
			//核心：插入排序
			for(int i = h; i < len; i++){// 从间隔值h开始未排序
				int n = i;
				int temp = arr[n];//临时值
				while(n >= h && temp <= arr[n-h] ){//当n>=h,保证index大于或者等于0； 比较是为了交换位置
					arr[n] = arr[n-h];
					n-=h;
				}
				arr[n]  = temp;//放入待插入的值
			}
			h = (h-1)/3;//减小间隔值
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
