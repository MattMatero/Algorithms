
public class Function {
	
	/**
	 * Finds the square root of a number by using an iterative binary search
	 * algorithm.
	 * @author Matt Matero
	 * @param num - A given number that we have to find the Square root of
	 * @param tolerance - How close we want our answer to be to the exact answer
	 * @return - the sqrt of the num
	 */
	public static double binSerSqrt(double num, double tolerance){
			
			if(num < 0)
				return 0.0;
			
		    double low = 0;
		    double high = num;
		    double mid = (high - low) / 2;

		    while (Math.abs((mid * mid) - num) > tolerance){ //checks if within tolerance
		        //too high
		    	if ((mid * mid) > num) {

		            high = mid;
		            mid = (high - low) / 2;

		        } else{

		            low = mid;
		            mid = mid + ((high - low) / 2);

		        }
		     System.out.println(mid); //prints out all attempts
		    }
		    
		    return mid;
		}
	
	
	
	/**
	 * Finds the square root of a number using an ancient babylonian technique with a tolerance of .01
	 * 
	 * @param num - A given number that we find the sqrt of
	 * @return - the sqrt of the num
	 */
	public static double AncientSqrt(double num){
		if(num < 0)
			return 0.0;
		
		double sqrt = num; //assumes sqrt is equal to num(i.e. num = 1)
		 	//while you haven't hit the sqrt yet keep going
		    while (Math.abs((sqrt * sqrt) - num) > .01) {
		    	System.out.println(sqrt);	    	
		    	//sets sqrt to the number divided by 2*sqrt and finds the half    	 
		        sqrt = (num / sqrt + sqrt) / 2; 
		    }
		    
		    return sqrt;
	}
}
