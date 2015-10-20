/**
 * Given an array of n objects with k different colors (numbered from 1 to k), 
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * @author Lu
 *
 */
public class SortColorsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * O(1) space solution
	 * @param colors
	 * @param k
	 */
	public void sortColors(int[] colors, int k){
		int count = 0;
		int start = 0;
		int end = colors.length - 1;
		
		while(count < k){
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int i = start; i < end; i++){
				min = Math.min(min, colors[i]);
				max = Math.max(max, colors[i]);
			}
			
			int left = start;
			int right = end;
			int cur = left;
			while(cur <= right){
				if(colors[cur] == min){
					swap(colors, left, cur);
					cur++;
					left++;
					start++;
				}else if(colors[cur] == max){
					swap(colors, right, cur);
					right--;
					end--;
				}else{
					cur++;
				}
			}
			count += 2;
		}
	}
	private void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	/**
	 * O(k) space solution
	 * @param colors
	 * @param k
	 */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] count = new int[k];
        for(int i = 0; i < colors.length; i++){
            count[colors[i]-1]++;
        }
        
        int color = 1;
        int index = 0;
        while(color <= k){
            if(count[color-1] == 0){
                color++;
            }else{
                count[color-1]--;
                colors[index] = color;
                index++;
            }
        }
    }
}
