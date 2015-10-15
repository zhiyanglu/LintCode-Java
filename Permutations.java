import java.util.ArrayList;

/**
 * Given a list of numbers, return all possible permutations.
 * @author Lu
 *
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(new Permutations().permute(nums));
	}
	
	
	/**
	 * non-recursion solution
	 * @param nums
	 * @return
	 */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
    	ArrayList<ArrayList<Integer>> res = new ArrayList();
    	int[] index = new int[nums.size()];
    	for(int i = 0; i < index.length; i++){
    		index[i] = i;
    	}
    	while(hasNextPermutation(index)){
    		ArrayList<Integer> list = new ArrayList();
    		for(int i = 0; i < index.length; i++){
    			list.add(nums.get(index[i]));
    		}
    		res.add(list);
    		nextPermutation(index);
    	}

    	ArrayList<Integer> list = new ArrayList();
		for(int i = 0; i < index.length; i++){
			list.add(nums.get(index[i]));
		}
		res.add(list);

    	
    	return res;
    }
    private boolean hasNextPermutation(int[] index){
    	for(int i = 0; i < index.length; i++){
    		if(index[i] != index.length - i - 1) return true;
    	}
    	return false;
    }
    private void nextPermutation(int[] index){
    	int i;
    	for(i = index.length-1; i > 0; i--){
    		if(index[i] > index[i-1]) break;
    	}
    	if(i == 0){
    		for(int j = 0; j < index.length / 2; j++){
    			int temp = index[j];
    			index[j] = index[index.length - 1 - j];
    			index[index.length - 1 - j] = temp;
    		}
    		return;
    	}
    	
    	int si = i;
    	for(int k = i; k < index.length; k++){
    		if(index[i-1] < index[k] && index[k] < index[si]){
    			si = k;
    		}
    	}
    	int temp = index[i-1];
    	index[i-1] = index[si];
    	index[si] = temp;
    	int lo = i;
    	int hi = index.length-1;
    	
    	while(lo < hi){
    		temp = index[lo];
    		index[lo] = index[hi];
    		index[hi] = temp;
    		lo++;
    		hi--;
    	}
    	
    }


}
