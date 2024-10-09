package com;

import java.util.Arrays;

public class MergeSorter {
	
	public void sort(int[] data) {
		mergeSort(data, 0, data.length-1);
	}	

	// Merge Sort method
    private void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;  // No need for Math.floor here
            mergeSort(data, start, mid);  // Sort left half
            mergeSort(data, mid + 1, end);  // Sort right half
            merge(data, start, mid, end);  // Merge the two sorted halves
        }
    }

    // Merge method to combine two sorted subarrays
    private void merge(int[] data, int start, int mid, int end) {
        int sizeOfLeft = mid - start + 1;
        int sizeOfRight = end - mid;

        // Temporary arrays
        int[] left = new int[sizeOfLeft];
        int[] right = new int[sizeOfRight];

        // Copy data into left and right arrays
        for (int i = 0; i < sizeOfLeft; i++) {
		left[i] = data[start + i]; // be careful here
	}
	for (int j = 0; j < sizeOfRight; j++) {
		right[j] = data[mid + 1 + j]; // be careful
	}

        int i = 0, j = 0;
        int k = start;

        // Merge back into the original array
        while (i < sizeOfLeft && j < sizeOfRight) {
            if (left[i] <= right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from left and right arrays
        while (i < sizeOfLeft) {
            data[k] = left[i];
            i++;
            k++;
        }

        while (j < sizeOfRight) {
            data[k] = right[j];
            j++;
            k++;
        }
    }
	
	public void minimumSum(int[] data){
		int leftMost = 0; 
		int rightMost = data.length-1;
	    int min_sum = data[leftMost] + data[rightMost];	
	    int min_l = leftMost;
        int min_r =rightMost;
	    while(leftMost < rightMost)
	    {
	        int sum = data[leftMost] + data[rightMost];
	 
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
		MergeSorter sorter = new MergeSorter();
		int[] data = {4,1,3,2,5,-2,-3};
		sorter.sort(data);
		sorter.minimumSum(data);
		//System.out.println(data[0]+data[data.length-1]);
		System.out.println(Arrays.toString(data));
	}
}
