package com.cleverdb;

/**
 * �鲢�㷨
 * @author V.Bo.Dong
 *
 */
public class Merge {

	/**
	 * 
	 * �����Ѿ����������
	 * @param srcA ��������A
	 * @param lengthA ��������A�ĳ���
	 * @param srcB ��������B
	 * @param lengthB ��������B�ĳ���
	 * @param srcC �鲢����
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
	 * ��������--�鲢����
	 * ʱ�临�Ӷȣ�N*logN
	 * @param array ����������
	 */
	static void sort(int[] array){
		int[] temp = new int[array.length] ;
		triabgleSort(array, temp, 0, array.length-1);
	}
	/**
	 * @param src ��Ҫ���������
	 * @param des ��ʱ�������
	 * @param low �����λ
	 * @param hig �����λ
	 */
	static void triabgleSort(int[] src,  int[] des, int low, int hig){
		if(low == hig){
			return;
		}else{
			int mid = (low+hig)/2;
			//���鲢����
			triabgleSort(src, des, low, mid);
			//�Ҳ�鲢����
			triabgleSort(src, des, mid+1, hig);
		    //�鲢����
			mergeArray(src, des, low, mid, hig);
			
		}
	}
	
	/**
	 * �鲢����
	 * @param src ԭ����
	 * @param des ��ʱ����
	 * @param low ������±�
	 * @param mid �м�ֵ
	 * @param hig ���Ҳ��±�
 	 */
	static void mergeArray(int[] src,  int[] des, int low, int mid, int hig){
		int i = low; //����±�ָ��index
		int j = mid + 1; // �Ҳ��±�ָ��index
		int index = 0; // ��ʱ�����±�
		while(i <= mid && j <= hig){ // ֻ�������±궼С���ٽ�ֵ�������������Ҫ�Ƚϣ�����ֱ�Ӹ��Ƶ���ʱ����
			if(src[i] > src[j]){
				des[index++] =src[j++];
			}else{
				des[index++] =src[i++];
			}
		}
		while(i <= mid){//��������黹��ֵ
			des[index++] =src[i++];
		}
		while(j <= hig){//���Ҳ����黹��ֵ
			des[index++] =src[j++];
		}
		for(int n = 0 ;n < index; n++){//����ʱ�����ֵcopy��ԭ����
			src[low+n] =des[n];
		}
	}
	
	/**
	 * �ݹ���� x^y
	 * @param x
	 * @param y
	 * @return
	 */
	static long calculata(int x ,int y){
		if(y == 1){
			return x;
		}
		else{
			if((y&1) != 0) //���Ϊ����������Ե�ǰ��
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
