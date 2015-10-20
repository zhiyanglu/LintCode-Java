import java.util.ArrayList;


public class MaximumSubarrayDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		System.out.println(new MaximumSubarrayDifference().maxDiffSubArrays(nums));

	}

	
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) return 0;
        
        int sum, minSum, maxSum, min, max;
        
        int len = nums.size();
        int[] min_left = new int[len];
        int[] max_left = new int[len];
        
        sum = 0; minSum = 0; maxSum = 0; 
        min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            min = Math.min(min, sum - maxSum);
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum);
            
            max_left[i] = max;
            min_left[i] = min;
        }        
        
        int maxDif = Integer.MIN_VALUE;
        
        sum = 0; minSum = 0; maxSum = 0; 
        min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
        for(int i = len-1; i > 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            min = Math.min(min, sum - maxSum);
            
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum);
            
            maxDif = Math.max(maxDif, 
                Math.max(max_left[i-1] - min, max - min_left[i-1]));
        }
        

        return maxDif;
    }

    
    
}
