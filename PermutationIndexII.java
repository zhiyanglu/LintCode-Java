import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PermutationIndexII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public long permutationIndexII(int[] A) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], 1);
            }else{
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        
        long ans = 0;
        for(int i = 0; i < A.length; i++){
            Set<Integer> used = new HashSet<Integer>();
            for(int j = i + 1; j < A.length; j++){
                if(A[j] < A[i] && !used.contains(A[j])){
                    used.add(A[j]);
                    
                    map.put(A[j], map.get(A[j]) - 1);
                    ans += permute(map);
                    map.put(A[j], map.get(A[j]) + 1);
                }
            }
            
            map.put(A[i], map.get(A[i]) - 1);
        }
        
        return ans+1;
        
    }
    
    private long permute(HashMap<Integer, Integer> map){
        int tot = 0;
        long dup = 1;
        for(Integer n : map.values()){
            if(n == 0) continue;
            tot += n;
            dup *= fact(n);
        }
        
        return fact(tot) / dup;
    }
    
    
    
    long fact(int fact){
        if(fact == 0) return 0;
        if(fact == 1) return 1;
        return fact * fact(fact - 1);
    }

}
