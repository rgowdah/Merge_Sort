package com;

import java.util.Arrays;

public class MergeSorter_Double {
	
	public void sort(double[] data) {
		mergeSort(data, 0, data.length-1);
	}	
	
	private void mergeSort(double[] data, int start, int end) {
		if (start < end) {
			int mid = (int) Math.floor((start+end)/2);
			mergeSort(data, start, mid);
			mergeSort(data, mid+1, end);
			merge(data, start, mid, end);
		}
	}
	
	private void merge(double[] data, int start, int mid, int end) {
		int sizeOfLeft = mid-start+1;
		int sizeOfRight = end - mid;
		double[] left = new double[sizeOfLeft];
		double[] right = new double[sizeOfRight];
		for (int i = 0; i < sizeOfLeft; i++) {
			left[i] = data[start + i]; // be careful here
		}
		for (int j = 0; j < sizeOfRight; j++) {
			right[j] = data[mid + 1 + j]; // be careful
		}
		int i = 0, j = 0;
		for (int k = start; k <= end; k++) {
			if ((j >= sizeOfRight) || (i < sizeOfLeft && left[i] <= right[j])) {
				data[k] = left[i];
				i++;
			} else {
				data[k] = right[j];
				j++;
			}
		}
	}
	
	public void minimumSum(double[] data){
		int leftMost = 0; 
		int rightMost = data.length-1;
	    double min_sum = data[leftMost] + data[rightMost];	
	    int min_l = leftMost;
        int min_r =rightMost;
	    while(leftMost < rightMost)
	    {
	        double sum = data[leftMost] + data[rightMost];
	 
	        /*If abs(sum) is less then update the result items*/
	        if(Math.abs(sum) < Math.abs(min_sum))
	        {
	            min_sum = sum;
	            min_l = leftMost;
	            min_r = rightMost;
	        }
	        if(sum < 0)
	            leftMost++;
	        else
	            rightMost--;
	 
	    }
	    System.out.println(" The two elements whose sum is minimum are : "+data[min_l]+" , "+ data[min_r]);

	}
	
	public static void main(String[] args) {
		MergeSorter_Double sorter = new MergeSorter_Double();
		//double[] data = {-5,1,3,2,5,-2,-3};
		double[] data = {-100,-5,1.414,0,1000};
		sorter.sort(data);
		sorter.minimumSum(data);
		//System.out.println(data[0]+data[data.length-1]);
		System.out.println(Arrays.toString(data));
	}
}
