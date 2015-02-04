
public class RandomQs {
	
	/**
	 * Method designed to find the median of two sorted arrays. 
	 * O(n) run time.
	 * Simply merges the arrays into 1 sorted array and then grabs middle elements
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int median(int arr1[], int arr2[]){
		int n = arr1.length+arr2.length;
		int union[] = new int[n];
		Sorts.merge(union,arr1,arr2);
		
		if(union.length %2 == 0){
			return (union[n/2]+union[n/2-1])/2;
		}else{
			return (union[n/2]);
		}
	}
	
	public static int median(int arr1[]){
		if(arr1.length % 2 == 0){
			return (arr1[arr1.length/2 -1] + arr1[arr1.length/2])/2;
		}else{
			return arr1[arr1.length/2];
		}
		
	}
	/**
	 * Method designed to find the median of two sorted arrays
	 * O(lg n) run time
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int getMedian(int arr1[], int arr2[], int size){
		//trivial cases
		
		if(size <= 0){
			return -1; //improper input
		}
		
		if(arr1.length == 2 && arr2.length == 2){
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1]) ) /2; //constant
		}
		
		//case 1(no overlap in arrays)
		if(arr1[arr1.length-1] < arr2[0]){
			return (arr1[arr1.length-1] + arr2[0])/2; //constant
		}
		
		//case 2(identical arrays, same median)
		//grab medians
		int m1 = median(arr1);
		int m2 = median(arr2);
		if(m1 == m2){
			return m1; //constant
		}
		
		//case 3(overlap in arrays)
		if(m1 < m2){
			if(size % 2 == 0){
				int[] small = new int[arr1.length/2 + 1];
				System.arraycopy(arr1, small.length/2, small, 0, small.length);
				return getMedian(small,arr2,(size-size/2) + 1);
			}else{
				int[] small = new int[arr1.length/2];
				System.arraycopy(arr1, small.length/2, small, 0, small.length);
				return getMedian(small,arr2,size-size/2);
			}
		}else{
			if(size % 2 == 0){
				int[] small = new int[arr2.length/2 + 1];
				System.arraycopy(arr2, small.length/2, small, 0, small.length);
				return getMedian(small,arr1,(size-size/2) + 1);
			}else{
				int[] small = new int[arr2.length/2];
				System.arraycopy(arr2, small.length/2, small, 0, small.length);
				return getMedian(small,arr1,size-size/2);
			}
		}
	}
}
