
public class UpdateBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpdateBits().updateBits(1024, 21, 2, 6);		
	}

	
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        if(i == 0 && j == 31) return m;
        int mask = (1 << (j - i + 1)) - 1;
        mask = mask << i;
        mask = ~mask;

        n = n & mask;
        n = n | (m << i);
        
        return n;

    }

}
