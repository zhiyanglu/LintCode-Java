/**
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 * Given [1,1,2,3,3,3,2,2,4,1] return 4
 * @author Lu
 *
 */
public class SingleNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        int ones = 0;
        int twos = 0;
        int threes = 0;
        
        //ones as a bitmask to represent the ith bit had appeared once.
        //twos as a bitmask to represent the ith bit had appeared twice.
        //threes as a bitmask to represent the ith bit had appeared three times.
        for(int i = 0; i < A.length; i++){
            //if the bit is already in one, it will be added to twos
            twos |= ones & A[i];
            //if the bit is in ones, it will be romoved from ones
            //if the bit is not in ones, it will be added to ones
            ones ^= A[i];
            
            //if a bit is both in ones and twos, it means that it appears 3 times
            //remove it from ones and twos
            threes = twos & ones;
            ones = ones & ~threes;
            twos = twos & ~threes;
        }
        return ones;
    }

}
