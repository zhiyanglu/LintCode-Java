import java.util.HashMap;


public class PermutationIndex {
	/**
	 * Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, 
	 * which are ordered in lexicographical order. The index begins at 1.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,6,4,5,8,1,7,3};
		System.out.println(new PermutationIndex().permutationIndex(A));
	}

	
    public long permutationIndex(int[] A) {
        // Write your code here
        int[] less = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
        	less[i] = 0;
        	for(int j = i+1; j < A.length; j++){
                if(A[j] < A[i]){
                    less[i]++;
                }
            }
        }
        
        long ans = 0;
        for(int i = 0; i < less.length; i++){
        	long a = less[i];
        	long b = fac(A.length - 1 - i);
            ans += a * b;
        }
        return ans+1;
    }

	//
	public long permutationIndex2(int[] A) {
        // Write your code here
		HashMap<Integer, Integer> hash = new HashMap();
		
		for (int i = 0; i < A.length; i++) {
			if (hash.containsKey(A[i]))
				hash.put(A[i], hash.get(A[i]) + 1);
			else {
				hash.put(A[i], 1);
			}
		}
		
		long ans = 0;
		for(int i = 0; i < A.length; i++){
			for(int j = i+1; j < A.length; j++){
				if(A[j] < A[i]){
					hash.put(A[j], hash.get(A[j]) - 1);
					ans += generateNum(hash);
					hash.put(A[j], hash.get(A[j]) + 1);
				}
			}
			hash.put(A[i], hash.get(A[i]) - 1);
		}
		
		return ans+1;
		
    }
	
	long generateNum(HashMap<Integer, Integer> hash){
		long denominator = 1;
		int sum = 0;
		for(int val : hash.values()){
			if(val == 0)
				continue;
			denominator *= fac(val);
			sum += val;
		}
		if(sum == 0) return 0;
		return fac(sum) / denominator;
	}
	
	long fac(int numerator){
		long now = 1;
		for(int i = 1; i <= numerator; i++){
			now *= (long)i;
		}
		return now;
	}
}
