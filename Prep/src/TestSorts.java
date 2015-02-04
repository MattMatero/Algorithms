import java.util.Random;

public class TestSorts {
	public static void main(String[] args){
		sorts();
	}
	
	
	public static void sorts(){
		int[] nums = new int[10];
		//int[] nums2 = new int[1000000];
		Random rand = new Random();
		for(int i =0; i < nums.length; i++){
			nums[i] = (rand.nextInt(100) +1);
			//nums2[i] = nums[i];
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		//Sorts.quickSort(nums,0,nums.length-1);
		//Sorts.mergeSort(nums);
		//Sorts.insertionSort(nums);
		Sorts.tail_recursive_quick_sort(nums, 0, nums.length-1);
		for(int i = 0; i < nums.length; i++){
				System.out.print(nums[i] + " ");
			
		}
	}
	

	
}
