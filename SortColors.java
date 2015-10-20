/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author Lu
 *
 */
public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,0,0,1,2,0,2};
		new SortColors().sortColors(nums);
	}
	
    public void sortColors(int[] nums) {
        // write your code here
        int lo = 0;
        int hi = nums.length - 1;
        int i = 0;
        while(i <= hi){
            if(nums[i] == 0){
            	swap(nums, lo, i);
            	lo++;
            	i++;
            }else if(nums[i] == 1){
            	i++;
            }else{
            	swap(nums, i, hi);
            	hi--;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b){
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }


}
