package com.cleverdb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归
 * @author Bo.Dong
 *
 */
public class Triangle {

	
	/**
	 * 计算1+2+3+....+n
	 * @param n
	 * @return
	 */
	 static int sum(int n){
		if(n > 1)
			return n + sum(n-1);
		return n;

	}
	
	 /**
	  * 列出 [a,b,c,d]拼接的组合
	 * @param array
	 * @return
	 */
	 static List<String> sortByFor( char[] array){
		 if(array.length == 1) 
			 return Arrays.asList(String.valueOf(array));
					 
		List<String> result = new ArrayList<>(); 
		 for(int i = 0 ; i< array.length ; i++){
			 List<String> list = sortByFor(removeOne(array[i],array));
			 for(String  str : list){
				 result.add(array[i]+str);
			 }
		 }
		 return result;
	 }

	static char[] removeOne( char ch , char[] array){
		int len = array.length;
		char[] temp =  new char[len-1];
		int index = 0;
		for(int i =0 ; i < len; i++){
			if(array[i] != ch){
				temp[index] = array[i];
			    index ++;
			}
		}
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(sum(3));
		//System.out.println(sort(new char[]{'a','b','c'}));
		System.out.println(sortByFor(new char[]{'1','2','3','4','5'}));
	}
}
