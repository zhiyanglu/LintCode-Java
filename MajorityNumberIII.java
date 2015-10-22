import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 * Find it.
 * O(n) time and O(k) extra space
 * @author Lu
 *
 */
public class MajorityNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        //we will need to maintain a data structure that contains the relative
        //votes of k-1 candidates
        //if any relative votes of these candidates in the data structure becomes 0
        //remove it from the data structure
        //we should be able to add the votes of a candidate easily
        
        Map<Integer, Integer> map = new HashMap();
        for(Integer n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
            
            if(map.size() >= k){
                removeCandidate(map);
            }
        }

        for(Integer candidate : map.keySet()){
            map.put(candidate, 0);
        }
        int max = nums.get(0);
        for(Integer candidate : nums){
            if(!map.containsKey(max)){
                max = candidate;
            }
            if(map.containsKey(candidate)){
                map.put(candidate, map.get(candidate) + 1);
                max = map.get(max) > map.get(candidate) ? max : candidate;
            }
        }
        
        return max;
    }
    
    private void removeCandidate(Map<Integer, Integer> map){
        ArrayList<Integer> removeList = new ArrayList<Integer>();
        for(Integer candidate : map.keySet()){
            map.put(candidate, map.get(candidate) - 1);
            if(map.get(candidate) == 0){
                removeList.add(candidate);
            }
        }
        for(Integer key : removeList){
            map.remove(key);
        }
    }


}
