
public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab";
		String s2 = "ab";
		new ScrambleString().isScramble(s1, s2);
	}

    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if(s1.length() != s2.length()) return false;
        return isScramble(s1, s2, 0, s1.length()-1, 0, s2.length()-1);
    }
    
    private boolean isScramble(String s1, String s2, int s1_lo, int s1_hi, int s2_lo, int s2_hi){
        if(s1_lo == s1_hi){
            return s1.charAt(s1_lo) == s2.charAt(s2_lo);
        }
        
        int[] count = new int[26];
        for(int i = s1_lo; i <= s1_hi; i++){
            count[s1.charAt(i) - 'a']++;
        }
        for(int i = s2_lo; i <= s2_hi; i++){
            count[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0) return false;
        }
        
        for(int i = s1_lo; i < s1_hi; i++){
            if(isScramble(s1, s2, s1_lo, i, s2_lo, s2_lo + (i - s1_lo)) && 
               isScramble(s1, s2, i+1, s1_hi, s2_hi - (s1_hi - i - 1), s2_hi)){
                return true;    
            } 
            
            if(isScramble(s1, s2, s1_lo, i, s2_hi - (i - s1_lo), s2_hi) && 
                isScramble(s1, s2, i+1, s1_hi, s2_lo, s2_lo+(s1_hi - i - 1))
            ){
                return true;
            }
        }
        
        return false;
    }

}
