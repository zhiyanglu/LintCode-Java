
public class FlipBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FlipBits().bitSwapRequired(-1, 1));
	}
	
	
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int num = a ^ b;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((num & 1) == 1) count++;
            num = num >> 1;
        }
        
        return count;
    }


}
