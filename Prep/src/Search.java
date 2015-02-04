
public class Search {
	
	public int binSearch(int[] arr, int key){
		   int lo = 0;
	        int hi = arr.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < arr[mid]) hi = mid - 1;
	            else if (key > arr[mid]) lo = mid + 1;
	            else return mid;
	        }
	       
	        return -1; //not found
	}
}
