
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0) return 0;
        
        //opt[i][j] means the longest common subsequence of A(0,i) and B(0,j)
        int[][] opt = new int[A.length()][B.length()];
        opt[0][0] = A.charAt(0) == B.charAt(0) ? 1 : 0;
        for(int i = 1; i < A.length(); i++){
            opt[i][0] = A.charAt(i) == B.charAt(0) ? 1 : opt[i-1][0];
        }
        for(int i = 1; i < B.length(); i++){
            opt[0][i] = A.charAt(0) == B.charAt(i) ? 1 : opt[0][i-1];
        }
        
        for(int i = 1; i < A.length(); i++){
            for(int j = 1; j < B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    opt[i][j] = Math.max(opt[i-1][j-1] + 1, Math.max(opt[i-1][j],opt[i][j-1]));
                }else{
                    opt[i][j] = Math.max(opt[i-1][j-1], Math.max(opt[i-1][j],opt[i][j-1]));
                }
            }
        }
        
        return opt[A.length()-1][B.length()-1];


    }


}
