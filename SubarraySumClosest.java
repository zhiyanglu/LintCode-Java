import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
 * @author Lu
 *
 */
public class SubarraySumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Match{
		int sum;
		int index;
		Match(int sum, int index){
			this.sum = sum;
			this.index = index;
		}
	}
	
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(nums.length == 0) return res;
        
        Match[] sums = new Match[nums.length + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        	sums[i] = new Match(sum, i);
        }
        sums[sums.length - 1] = new Match(0, -1);
        
        Arrays.sort(sums, new Comparator<Match>(){
        	public int compare(Match o1, Match o2){
        		return o1.sum - o2.sum;
        	}
        });
        
        int a = 0;
        int b = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 1; i < sums.length; i++){
        	Match left = sums[i-1];
        	Match right = sums[i];
        	if(Math.abs(right.sum - left.sum) < closest){
        		a = Math.min(left.index, right.index) + 1;
        		b = Math.max(left.index, right.index);
        		closest = Math.abs(right.sum - left.sum);
        	}
        }
        
        res.add(a);
        res.add(b);
        return res;
    }


}
