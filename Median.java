
public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,9,4,5};
		System.out.println(new Median().median(nums));
	}
	
    public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        int mid = (len-1) / 2;
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int lo = start + 1;
            int hi = end;
            int pivot = nums[start];
            while(lo < hi){
                if(nums[hi] < pivot){
                    swap(nums, lo, hi);
                    lo++;
                }else{
                    hi--;
                }
            }
            if(nums[lo] > pivot) lo--;
            swap(nums, start, lo);
            
            if(lo > mid){
                end = lo - 1;
            }else if(lo < mid){
                start = lo + 1;
            }else{
                return nums[lo];
            }
        }
        
        return nums[start];
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
