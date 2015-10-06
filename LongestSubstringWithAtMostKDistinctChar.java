import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithAtMostKDistinctChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "eceba";
		int k = 3;
		new LongestSubstringWithAtMostKDistinctChar().lengthOfLongestSubstringKDistinct(s, k);
	}
	
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null) return 0;
        int lo = 0;
        int hi = 0;
        int distinct = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap();
        while(hi < s.length()){
            char c = s.charAt(hi);
            
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
                max = Math.max(max, hi - lo + 1);
            }else{
                map.put(c, 1);
                distinct++;
                
                while(distinct > k){
                    char r = s.charAt(lo);
                    map.put(r, map.get(r) - 1);
                    if(map.get(r) == 0){
                        distinct--;
                        map.remove(r);
                    }
                    lo++;
                }
            }
            hi++;
        }
        
        return max;
    }


}
