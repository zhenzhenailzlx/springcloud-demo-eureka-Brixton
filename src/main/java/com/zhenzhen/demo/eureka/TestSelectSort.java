package com.zhenzhen.demo.eureka;

import java.util.Arrays;

public class TestSelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tempArray = {32,21,56,78,99};
		//heapSort(tempArray);
		
		//binarySort(tempArray,0,tempArray.length-1);
		
		halfSort(tempArray);
		
		
		System.out.println(Arrays.toString(tempArray));
	}

	private static void halfSort(int[] tempArray) {
		
		for(int i=1;i<=tempArray.length-1;i++) {
			
			int temp = tempArray[i];
			int low = 0;
			int high = i-1;
			
			while(low<=high) {
				int middle = (low + high)/2;
				if(temp>tempArray[middle]) {
					low = middle +1;
				}else {
					high = middle -1;
				}
			}
			
			
			for(int j = i-1;j>=high+1;j--) {
				tempArray[j+1] = tempArray[j];
			}
			
			tempArray[high+1] = temp;
			
		}
		
	}

	private static void binarySort(int[] tempArray,int start,int end) {
		
		int low = start;
		int high = end;
		int temp = tempArray[low];
		if(low >= high) {
			return;
		}

		while(low < high) {
			while(low<high && tempArray[high]>temp) {
				-- high;
			}
			tempArray[low] = tempArray[high];
			
			
			while(low<high && tempArray[low]<temp) {
				++ low;
			}
			tempArray[high]=tempArray[low];
			
		}
		
		tempArray[low] = temp;
		
		
		binarySort(tempArray,start,high-1);
		
		binarySort(tempArray,high+1,end);
	}

	private static void heapSort(int[] tempArray) {
		//构建大顶堆   
		for(int i = tempArray.length/2-1;i>=0;i--) {
			adjustHeap(tempArray,i,tempArray.length);
		}
		
		//把第一个元素和最后一个元素做交换，重新筛选出大顶堆
		int temp;
		for(int j=tempArray.length-1;j>0;j--) {
			temp = tempArray[j];
			tempArray[j]  =tempArray[0];
			tempArray[0] = temp;
			
			adjustHeap(tempArray,0,j);
		}
		
		
	}

	private static void adjustHeap(int[] tempArray, int i, int length) {
		
		int temp = tempArray[i];
		int s;
		for(s = 2*i +1;s<length;s=2*s+1) {
			//判断叶子节点那个大
			if((s+1)<length && tempArray[s]<tempArray[s+1]) {
				s = s +1;
			}
			
			if(temp>=tempArray[s]) {
				break;
			}
			tempArray[i] = tempArray[s];
			i = s;
		}
		
		tempArray[i] = temp;
		
		
	}

}
