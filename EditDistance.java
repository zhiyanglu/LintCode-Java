
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "ab";
		String word2 = "a";
		System.out.println(new EditDistance().minDistance(word1, word2));
	}

    public int minDistance(String word1, String word2) {
        // write your code here
        if(word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0){
            return Math.max(word1.length(), word2.length());
        }
        int[][] opt = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < opt.length; i++){
            opt[i][0] = i;
        }
        for(int i = 0; i < opt[0].length; i++){
            opt[0][i] = i;
        }
        
        for(int i = 1; i < opt.length; i++){
            for(int j = 1; j < opt[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    opt[i][j] = Math.min(opt[i-1][j-1], Math.min(opt[i-1][j], opt[i][j-1]) + 1);
                }else{
                    opt[i][j] = Math.min(opt[i-1][j-1] + 1, Math.min(opt[i-1][j], opt[i][j-1]) + 1);                	
                }
            }
        }
        
        return opt[word1.length()][word2.length()];
    }

}
