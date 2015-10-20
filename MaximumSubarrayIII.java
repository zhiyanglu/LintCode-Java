import java.util.ArrayList;

/**
 * Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * @author Lu
 *
 */
public class MaximumSubarrayIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		int k = 1;
		new MaximumSubarrayIII().maxSubArray(nums, k);
	}

    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     * 
     * Analysis:
     * DP. d[i][j] means the maximum sum we can get by selecting i subarrays from the first j elements.
     * d[i][j] = max{d[i-1][p]+maxSubArray(p+1,j)}
     * we iterate p from i-1 to j-1, so we can record the max subarray we get at current p, this value can be used to calculate the max subarray from p-1 to i when p becomes p-1.
     */
    public static int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        
    	int[][] opt = new int[k + 1][nums.size() + 1];
    	
    	for(int i = 1; i < k + 1; i++){
    		for(int j = i; j < nums.size() + 1; j++){
    			opt[i][j] = Integer.MIN_VALUE;
    			//opt[i][j] = max{opt[i-1][p] + maxSubarry(p+1, j)}, p = (i-1, j-1)
    			
    			
    			//finding max sub array in nums(i-1, j-1)
    			int max = Integer.MIN_VALUE;
    			int sum = 0;
    			for(int p = j - 1; p >= i - 1; p--){
    				if(sum < 0){
    					sum = 0;
    				}
    				sum += nums.get(p);
    				max = Math.max(max, sum);
    				
    				opt[i][j] = Math.max(opt[i][j], opt[i-1][p] + max);
    			}
    			
    		}
    	}
        return opt[k][nums.size()];
        
    }

}
