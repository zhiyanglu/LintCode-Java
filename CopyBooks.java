import java.util.Arrays;

public class CopyBooks {
    
	
	public static void main(String[] args){
		int[] pages = {3,2,4};
		int k = 2;
		System.out.println(new CopyBooks().copyBooks(pages, k));
	}
	
	/**
	 * O(n*k) solution
	 * @param pages
	 * @param k
	 * @return
	 */
    public int copyBooks2(int[] pages, int k) {
        // write your code here
        
        if(pages == null || pages.length == 0) return 0;
        
        k = Math.min(pages.length,k);
        
        //minutes[i][j] = min( max( minutes[i-1][t], sum(t+1, j) )
        //1 <= i <= k, 0 <= j <= n - 1, 0 <= t < j
        int[][] minutes = new int[k][pages.length];
        int[] sum_from_start = new int[pages.length];
        sum_from_start[0] = pages[0];
        for(int i = 1; i < pages.length; i++){
            sum_from_start[i] = sum_from_start[i-1] + pages[i];
        }
        for(int i = 0; i < k; i++){
            minutes[i][0] = pages[0];
        }
        for(int i = 1; i < pages.length; i++){
            minutes[0][i] = minutes[0][i-1] + pages[i];
        }
        
        for(int i = 1; i < k; i++){
            int left = 0;
            int right = 1;
            while(right < pages.length){
                int curr = sum_from_start[right] - sum_from_start[left];
                if(minutes[i][right] == 0){
                    minutes[i][right] = Math.max(curr, minutes[i - 1][left]);
                }else{
                    minutes[i][right] = Math.min(Math.max(curr, minutes[i - 1][left]), minutes[i][right]);                    
                }
                
                if(left < right && minutes[i - 1][left] < curr){
                    left++;
                }else{
                    right++;
                    if(left > 0) left--;//potential solution
                }
            }
        }
        
        return minutes[k-1][pages.length-1];

    }

	
	/**
	 * O(n^2*k) solution
	 * 
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        
        if(pages == null || pages.length == 0) return 0;
        
        k = Math.min(pages.length,k);
        
        //minutes[i][j] = min( max( minutes[i-1][t], sum(t+1, j) )
        //1 <= i <= k, 0 <= j <= n - 1, 0 <= t < j
        int[][] minutes = new int[k][pages.length];
        
        for(int i = 0; i < k; i++){
            minutes[i][0] = pages[0];
        }
        for(int i = 1; i < pages.length; i++){
            minutes[0][i] = minutes[0][i-1] + pages[i];
        }
        
        for(int i = 1; i < k; i++){
            for(int j = 1; j < pages.length; j++){
                
                int cost = 0;
                //assign books from j to t to new worker
                for(int t = j; t > 0; t--){
                    cost += pages[t];
                    if(minutes[i][j] == 0){
                    	minutes[i][j] = Math.max(cost,minutes[i-1][t-1]);
                    }else{
                        minutes[i][j] = Math.min(Math.max(cost,minutes[i-1][t-1]),minutes[i][j]);                    	
                    }
                }
                
            }
        }
        
        return minutes[k-1][pages.length-1];

    }
}
