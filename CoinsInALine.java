
public class CoinsInALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1, 3, 3, 5, 4, 6, 4, 2};
		new CoinsInALine().firstWillWin(values);
	}
	
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length <= 2) {
            return true;
        }
        
        /*
         * first  : maximum number if player picks from the first number
         * second : maximum number if player picks from the second number
         * 
         * if add a new number before the previous values, the second player could pick min(first, second)
         * then the first people could pick sum - min(first, second)
         * second = first
         * first = sum - min(first, second)
         */
        int second = values[values.length - 1];
        int first = second + values[values.length - 2];
        int cur;
        int sum = first;
        for(int i = values.length - 3; i >= 0; i--){
        	sum += values[i];
        	cur = sum - Math.min(first, second);
        	second = first;
        	first = cur;
        }
        return first * 2 > sum;
    }


}
