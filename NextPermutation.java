
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    /**
     * 1. find the index of first peak from right
     * 2. find MIN(nums[next] > nums[index-1]) next = (index, nums.length-1)
     * 3. swap(nums[index-1], nums[next])
     * 4. reverse nums(index, nums.length)
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int index = 0;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                index = i;
                break;
            }
        }
        if(index == 0){
            reverse(nums, 0, nums.length-1);
            return nums;
        }
        
        int index_next = index;
        for(int i = index; i < nums.length; i++){
            if(nums[i] > nums[index - 1] && nums[i] <= nums[index_next]){
                index_next = i;
            }
        }
        swap(nums, index-1, index_next);
        reverse(nums, index, nums.length-1);
        
        return nums;
    }
    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
    private void swap(int[] nums, int a, int b){
        if(a == b) return;
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }

}
