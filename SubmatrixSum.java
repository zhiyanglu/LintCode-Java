import java.util.HashMap;
import java.util.Map;


public class SubmatrixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{-10},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1},{1}};
		new SubmatrixSum().submatrixSum(matrix);
	}
	
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
    	int[][] res = new int[2][2];
    	if(matrix == null || matrix.length == 0) return res;
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	int[][] sum = new int[m+1][n+1];
    	for(int i = 0; i <= m; i++){
    		sum[i][0] = 0;
    	}
    	for(int i = 0; i <= n; i++){
    		sum[0][i] = 0;
    	}
    	for(int i = 1; i <= m; i++){
    		for(int j = 1; j <= n; j++){
    			sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
    		}
    	}
    	
    	
    	
    	for(int l = 0; l <= m; l++){
    		Map<Integer, Integer> map = new HashMap();
    		for(int h = l + 1; h <= m; h++){
    			for(int j = 0; j <= n; j++){
    				
    				//calculate diff
    				//diff is sum from (l,0) to (h, j)
    				//if (l, 0) to (h, j1) is diff && (l, 0) to (h, j2) is diff
    				//then (l, j1) to (h, j2) is 0
    				int diff = sum[h][j] - sum[l][j];
    				if(map.containsKey(diff)){
    					res[0][0] = l;
    					res[0][1] = map.get(diff);
    					res[1][0] = h-1;
    					res[1][1] = j-1;
    				}else{
    					map.put(diff, j);
    				}
    			}
    		}
    	}
    	
    	return res;    	
    	
    }


}
