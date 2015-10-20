import java.util.ArrayList;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum.
 * The number in each subarray should be contiguous.
 * Return the largest sum.
 * @author Lu
 *
 */
public class MaximumSubarrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        
        
        // left[i] records the largest sum from 0 to i in sum
        int[] left = new int[len];
        int minSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }
        
        // right[i] records the largest sum form i to sum.size in sum
        int[] right = new int[len];
        minSum = 0;
        sum = 0;
        max = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }
        
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < len-1; i++){
            maxSum = Math.max(maxSum, left[i] + right[i+1]);
        }
        
        return maxSum;
    }


}
