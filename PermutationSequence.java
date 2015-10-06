import java.util.ArrayList;


public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PermutationSequence().getPermutation(3, 4);
	}
	
    public String getPermutation(int n, int k) {
    	String res = "";
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i <= n; i++){
    		list.add(i);
    	}
    	
    	int fact, index;
    	
    	for(int i = n; i > 0; i--){
    		fact = fact(i - 1);
    		index = (int)Math.ceil((double)k / fact);
    		
    		res += list.get(index);
    		list.remove(index);
    		
    		k = k % fact;
    		if(k == 0) k = fact;
    	}
    	
    	return res;
    }

    private int fact(int n){
    	if(n <= 1) return 1;
    	else return n * fact(n-1);
    }

}
