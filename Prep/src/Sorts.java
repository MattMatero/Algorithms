
public class Sorts {
	
	/**
	 * Insertion Sort. Compares adjacent array values and swaps them if necessary. 
	 * worst case O(n^2)
	 * average case O(n^2)
	 * stack space O(1) (sorts array elements in place)
	 * worst case stack space O(n) if copying to a new array(?)
	 * Stable sort (Does not change the relative order of elements with equal keys)
	 * @param array
	 * @return
	 */
	  public static void insertionSort(int array[]) {
	        for (int j = 1; j < array.length; j++) {
	            int key = array[j];
	            int i = j-1;
	            while ( (i >= 0) && ( array [i] > key ) ) {
	               array [i+1] = array [i];
	            	i--;
	            }
	            array[i+1] = key;
	        }
	  }
	  
	  /**
	   * Quick Sort: Picks a pivot element(middle element of your data) and then compares
	   * the beginning of the array and end of array to that pivot while each end moves closer
	   * to the middle. If elements are found that are out of place, they are swapped with each other
	   * 
	   * based on where those elements were, we will recursively sort the lower or higher end of the array
	   * 
	   * Another way to choose the pivot more optimally is take the average of the first, middle and last elements. 
	   * This will reflect a number closer to the median of the array
	   * 
	   * worst case O(n^2)
	   * avg case O(n lg n)
	   * stack space O(n) 
	   * 	to use only O(lg n) space, use a tail recursive implementation. Recursively sort the low end while the tail recursion 
	   * 	sorts the rest. Using stack space of O(n) will cause a stack overflow with large enough data.
	   * 
	   * @param arr
	   * @param low
	   * @param high
	   * @return
	   */
	  public static void quickSort(int[] arr, int low, int high){
		  int i = low, j = high;
		  
		  int pivot = arr[low +(high-low)/2];
		  while(i <= j){
			  //go until we find an i value we care about
			  while(arr[i] < pivot){
				  i++;
			  }
			  
			  //go until we find a j value we care about
			  while(arr[j] > pivot){
				  j--;
			  }
			  
			  //if i is still less than j after finding elements out of place swap them 
			  //and continue down the array
			  if(i <= j){
				  swap(arr,i,j);
				  i++;
				  j--;
			  }
			  
		  }
		  
		  	  //if j passes our pivot we sort the lower end up to j
			  if(j > low){
				  quickSort(arr,low,j);
			  }
			  // if i passes our pivot we sort from i to high 
			  if(i < high){
				  quickSort(arr,i,high);
			  }
		  
		  
	  }
	  
	  
	  
	  public static void swap(int[] arr, int posX, int posY){
		  int temp = arr[posX];
		  arr[posX] = arr[posY];
		  arr[posY] = temp;
	  }
	  
	  
	  public static int[] mergeSort(int[] arr){
		 if(arr.length == 1){
			 return arr;
		 }
		 
		 int[] merge1 = new int[arr.length/2];
		 int[] merge2 = new int[arr.length - merge1.length];
		 
		 //split into 2 sub arrays
		 System.arraycopy(arr,0,merge1,0,merge1.length);
	     System.arraycopy(arr,merge1.length,merge2,0,merge2.length);
	     
	     merge1 = mergeSort(merge1); //sort low half
	     merge2 = mergeSort(merge2); // sort up half
	     
	     merge(arr,merge1,merge2);
	     return arr;
	  }
	  
	  public static void merge(int[] total, int[] merge1, int[] merge2){
		 int left = 0, right = 0, whole = 0; //index for merge1,merge2 and total
		 
		 //continue while in bounds
		 while(left < merge1.length && right < merge2.length){
			 //add smaller element onto the final list
			 if(merge1[left] < merge2[right]){
				 total[whole] = merge1[left];
				 left++;
			 }
			 else{
				 total[whole] = merge2[right];
				 right++;
			 }
			whole++;  //increment counter for total list after an insertion occured
		 }
		 
		 int[] remaining;
		 int rest;
		 
		 if(left >= merge1.length){
			 remaining = merge2;
			 rest = right;
		 }else{
			 remaining = merge1;
			 rest = left;
		 }
		 
		 for( int i = rest; i < remaining.length; i++){
			 total[whole] = remaining[i];
			 whole++;
		 }
	  }
	  
	  
	  public static void tail_recursive_quick_sort(int[] A, int p, int r)
      {
              int q;
              while (p < r)
              {
            	  q = partition(A, p, r);
                    if(q - p < r - q){
                      tail_recursive_quick_sort(A, p, q - 1);
                      p = q + 1;
                    }else{
                    	tail_recursive_quick_sort(A, q+1, r);
                    	r = q-1;
                    }
              }
      }

      private static int partition(int[] A, int p, int r)
      {
              int x = A[r];
              int i = p - 1;
              int exchange;
              for (int j = p; j <= r - 1; j++)
              {
                      if (A[j] <= x)
                      {
                              i++;
                              exchange = A[i];
                              A[i] = A[j];
                              A[j] = exchange;
                      }
              }

              exchange = A[i + 1];
              A[i + 1] = A[r];
              A[r] = exchange;

              return i + 1;

	  
      }  
}
