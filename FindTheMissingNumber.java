/**
 * Given an array contains N numbers of 0 .. N, find which 
 * number doesn't exist in the array.
 * Example
 * Given N = 3 and the array [0, 1, 3], return 2.
 * Challenge
 * Do it in-place with O(1) extra memory and O(n) time.
 * @author Lu
 *
 */
public class FindTheMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i && nums[i] != nums.length){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i) return i;
        }
        return nums.length;
    }

}
