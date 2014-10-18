import java.util.Arrays;
import java.util.Random;
/**
 * A class that will run multiple ways to do the rod cutting problem(CLRS question)
 * @author Matt Matero
 *
 */


public class Driver {

	
	public static void main(String[] args){
		int[] p = generatePrices(); //generates prices for each length
		
		Arrays.sort(p); //sorts p so larger lengths are worth more
		
		for(int len = 10; len < p.length; len++){
			long start = System.currentTimeMillis();
			int val = cutRod(p,len);
			long total = System.currentTimeMillis() - start;
			System.out.println(total + "ms value: " + val + " length: " + len);
			start = System.currentTimeMillis();
	    	int val2 = rodMemoized(p,len);
	    	total = System.currentTimeMillis() - start;
	    	System.out.println(total + "ms value: " + val2 + " length: " + len);
	    	start = System.currentTimeMillis();
	    	int val3 = rodBottomUp(p,len);
	    	total = System.currentTimeMillis() - start;
	    	System.out.println(total + "ms value: " + val3 + " length: " + len);
	    	System.out.println();
		}
	}
	
	
	public static int[] generatePrices(){
		Random rand = new Random();
		int[] prices = new int[5000];
		for(int i = 0; i < prices.length; i++){
			prices[i] = rand.nextInt(1000000);
		}
		
		return prices;
	}
	
	/**
	 * Straight forward resurive algorithm for rod cutting
	 * @param p - the list of prices per inch
	 * @param n - the length of the rod
	 * @return - the optimal price
	 */
	public static int cutRod(int[] p, int n){
	    if(n==0){
	    	return 0;
	    }
	    
	    int q = 0;
	    
	    for(int i=0; i<n; i++){
	        q = Math.max( q, p[i]+cutRod(p,n-i-1));
	    }
	    
	    return q;
	}
	
	/**
	 * A memoized version of the rod cutting problem. 
	 * @param p - list of prices
	 * @param n - length
	 * @return - the optimal price
	 */
	public static int rodMemoized(int[] p, int n){
		int table[] = new int[p.length +1]; //makes table
		Arrays.fill(table, Integer.MIN_VALUE); //fills table
		return rodMemoizedHelp(p,n,table); //calculates price
	}
	
	/**
	 * helper method for the memoized rod cutting. 
	 * @param p - the prices
	 * @param n - the length
	 * @param priceTable - the lookup table
	 * @return
	 */
	private static int rodMemoizedHelp(int[] p, int n, int[]priceTable){
		
		//checks if price has been computed
		if(priceTable[n] >= 0){ 
			return priceTable[n];
		}
		
		int price = 0;
		
		//computes price
		if(n != 0){
			price = Integer.MIN_VALUE;
			for(int i = 1; i <= n; i++){
				price = Math.max(price,p[i-1]+rodMemoizedHelp(p,n-i,priceTable));
			}
		}
		
		//inserts
		priceTable[n] = price;
		return price;
	}
	
	/**
	 * Rod cutting taking a bottom up approach
	 * @param price - the list of prices
	 * @param n - the length of the rod
	 * @return - the optimal value
	 */
	 public static int rodBottomUp(int[] price, int n){
		int[] table = new int[price.length + 1];
		table[0] = 0;
		//fills table
		for(int j = 1; j <= n; j++){
			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= j; i++){
				max = Math.max(max, price[i-1] + table[j-i]);
			}
			table[j] = max;
		}
		
		return table[n];
	}
	
}
