/**
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For s1 = "aabcc", s2 = "dbbca"
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * @author Lu
 *
 */
public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.length() == 0 || s2.length() == 0){
            return s1.length() == 0 ? s2.equals(s3) : s1.equals(s3);
        }
                
        //opt[i][j] means if s1(0,i) and s2(0,j) is a interleave of s3(0,i+j)
        boolean[][] opt = new boolean[s1.length() + 1][s2.length() + 1];

        //init opt
        opt[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            opt[i][0] = opt[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s2.length(); i++){
            opt[0][i] = opt[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                
                if(opt[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    opt[i][j] = true;
                }else if(opt[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
                    opt[i][j] = true;
                }else if(opt[i-1][j-1]){
                    if(s1.charAt(i-1) == s3.charAt(i+j-2) && s2.charAt(j-1) == s3.charAt(i+j-1)){
                            opt[i][j] = true;
                    }
                    if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-2)){
                        opt[i][j] = true;
                    }
                }
            }
        }
        
        return opt[opt.length-1][opt[0].length-1];
        
    }


}
