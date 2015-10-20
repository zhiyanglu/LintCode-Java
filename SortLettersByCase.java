/**
 * Given a string which contains only letters. Sort it by lower case first and upper case second.
 * Example
 * For "abAcD", a reasonable answer is "acbAD"
 * Note
 * It's not necessary to keep the original order of lower-case letters and upper case letters.
 * @author Lu
 *
 */
public class SortLettersByCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int lo = 0;
        int hi = chars.length - 1;

        while(lo < hi){
            while(lo < chars.length - 1 && isLowercase(chars[lo])){
                lo++;
            }
            while(hi >= 0 && isUppercase(chars[hi])){
                hi--;
            }
            if(lo < hi){
                swap(chars, lo, hi);
            }
        }
    }
    private void swap(char[] chars, int a, int b){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
    private boolean isUppercase(char c){
        return 'A' <= c && c <= 'Z';
    }
    private boolean isLowercase(char c){
        return 'a' <= c && c <= 'z';
    }

}
