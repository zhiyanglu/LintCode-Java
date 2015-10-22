/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * You code should return the length of the LIS.
 * 
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 * @author Lu
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * A O(nlogn) solution with binary search
	 * 
	 * if we know Min(last element of the increasing subsequences with the current max length), we can compare it with the nums[i]
	 * to increase the max length
	 * 
	 * @param nums
	 * @return
	 */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums.length == 0) return 0;

        int max = 1;
        
        //c[i] represents the minimum value of the last element in a increasing sequence with length i;
        int[] c = new int[nums.length + 1];
        
        //initially the minimum value of the last element in a size 1 sequence is nums[0]
        c[1] = nums[0];  
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] < c[1]){
                c[1] = nums[i];
            }
            //nums[i] is greater than the minimum value of the tail of the current longest sequence
            else if(nums[i] >= c[max]){
                max++;
                c[max] = nums[i];
            }
            //nums[i] is less than the last element of current longest sequence
            //if we can find c[k-1] < nums[i] < c[k], we should update c[k] to nums[i]
            //use binary search
            else{
                int lo = 1;
                int hi = max;
                while(lo + 1 < hi){
                    int mid = (hi - lo) / 2 + lo;
                    if(c[mid] > nums[i]){
                        hi = mid;
                    }else{
                        lo = mid + 1;
                    }
                }
                int k = c[lo] > nums[i] ? lo : hi;
                c[k] = nums[i];
            }
            
        }
        
        return max;
    }

}
