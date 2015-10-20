import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-4,5,-1000};
		System.out.println(new SubarraySum().subarraySum2(nums));
		System.out.println(new SubarraySum().subarraySum(nums));
		
	}
	
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                nums[i] += nums[i-1];
            }
            if(nums[i] == 0){
                res.add(0);
                res.add(i);
                return res;
            }
        }
        
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                res.add(map.get(nums[i]) + 1);
                res.add(i);
                return res;
            }else{
                map.put(nums[i], i);
            }
        }   
        return null;
    }
    
    public ArrayList<Integer> subarraySum2(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }else{
                map.put(sum, i);
            }
        }
        
        return null;
    }

}
