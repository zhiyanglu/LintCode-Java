
public class BackPack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,4,8,5};
		int m = 10;
		new BackPack().backPack(m, A);
	}
	
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        //dp[i][j] indicates that if we can use first i items in A
        //to form size j
        dp[0][0] = true;
        
        for(int i = 1; i <= A.length; i++){
            for(int j = 0; j <= m; j++){
                
                //if we can use first i-1 items to form j, we can form j
                if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
                //if we can use first i-1 items to form j - A[i], we can form j
                else if(j >= A[i-1] && dp[i-1][j - A[i-1]]){
                    dp[i][j] = true;
                }
            }
        }
        for(int i = m; i >= 0; i--){
            if(dp[A.length][i] == true){
                return i;
            }
        }
        
        return 0;
    }


}
