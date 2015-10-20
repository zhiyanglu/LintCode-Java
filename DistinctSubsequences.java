
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "aacaacca";
		String T = "ca";
		new DistinctSubsequences().numDistinct(S, T);
	}	

	
	/**
	 * add a new letter in S
	 * if the letter is not the same with the last of T, number is the same as the number without the new letter
     * if the letter is the same with the last letter of T, number is the sum of the number without the new letter and the number without the last letter of both S and T
	 * @param S
	 * @param T
	 * @return
	 */
    public int numDistinct(String S, String T) {
        // write your code here
        int[][] opt = new int[S.length()][T.length()];
        if(S == null) return 0;
        
        opt[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        
        for(int i = 1; i < S.length(); i++){
            if(S.charAt(i) == T.charAt(0)){
                opt[i][0] = opt[i-1][0] + 1;
            }else{
                opt[i][0] = opt[i-1][0];
            }
        }
        
        for(int i = 1; i < S.length(); i++){
            for(int j = 1; j < T.length(); j++){
                if(S.charAt(i) == T.charAt(j)){
                    opt[i][j] = opt[i-1][j] + opt[i-1][j-1];
                }else{
                    opt[i][j] = opt[i-1][j];
                }
            }
        }
        
        return opt[S.length() - 1][T.length() - 1];
    }

}
