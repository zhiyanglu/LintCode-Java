import java.util.ArrayList;

/**
 * Given an integer array, find a continuous rotate subarray where the sum of numbers is the biggest. 
 * Your code should return the index of the first number and the index of the last number. 
 * (If their are duplicate answer, return anyone. The answer can be rorate array or non- rorate array)
 * @author Lu
 *
 */
public class SubarraySumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {8,-1,-1,-1,-1,4,5};
		System.out.println(new SubarraySumII().continuousSubarraySumII(A));
		StringBuilder sb = new StringBuilder();
		
	}
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(A == null || A.length == 0) return res;
        
        int len = A.length;
        int lo = 0, hi = 0;
        int max_start = 0, max_end = 0;
        int max = A[0];
        int total = 0;

        //find max subarray without rotation
        int cur = 0;
        for(hi = 0; hi < len; hi++){
            cur += A[hi];
            total += A[hi];
            if(cur > max){
                max = cur;
                max_start = lo;
                max_end = hi;
            }
            if(cur < 0){
                lo = hi+1;
                cur = 0;
            }
        }
        
        
        lo = 0;
        hi = 0;
        int min = A[0];
        int min_start = 0, min_end = 0;
        cur = 0;
        //find min subarray without rotation
        for(hi = 0; hi < len; hi++){
            cur += A[hi];
            if(cur < min){
                min = cur;
                min_start = lo;
                min_end = hi;
            }
            if(cur > 0){
                lo = hi+1;
                cur = 0;
            }
        }
        
        //edge case: all value is negative
        if(min_start == 0 && min_end == A.length-1){
            res.add(max_start);
            res.add(max_end);
        }else{
        	
        	//if total - min is larger, calculate rotate subarray
            if(max < total - min){
                res.add(min_end+1);
                res.add(min_start-1);
            }else{
                res.add(max_start);
                res.add(max_end);
            }
        }
        
        
        return res;

 
    }


}
