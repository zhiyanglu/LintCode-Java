import java.util.ArrayList;


public class MinimumAdjustmentCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAdjustmentCost solution = new MinimumAdjustmentCost();
		int[] nums = {12,3,7,4,5,13,2,8,4,7,6};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			A.add(nums[i]);
		}
		solution.MinAdjustmentCost(A, 2);
	}
	
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int[][] m = new int[A.size()][100];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < 100; j++){
                m[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return find(A, new ArrayList<Integer>(A), 0, target, m);
    }
    
    private int find(ArrayList<Integer> A, ArrayList<Integer> B, int index, int target, int[][] m){
        if(index == B.size()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        if(index == 0){
            for(int i = 1; i <= 100; i++){
                B.set(index, i);
                int dif = Math.abs(B.get(index) - A.get(index));
                int next = find(A, B, index + 1, target, m);
                min = Math.min(min, dif + next);
            }
        }else{
            for(int i = Math.max(1, B.get(index-1) - target); i <= Math.min(100, B.get(index-1) + target); i++){

                B.set(index, i);
                int dif = Math.abs(B.get(index) - A.get(index));

                if(m[index][i-1] != Integer.MAX_VALUE){
                    int next = m[index][i-1];
                    min = Math.min(min, dif + next);
                }else{
                    int next = find(A, B, index + 1, target, m);
                    min = Math.min(min, dif + next);
                }
            }
        }
        
        return min;

    }


}
