
public class DigitCounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new DigitCounts().digitCounts(0, 99));
	}
	/**
	 * 当某一位的数字小于k时，那么该位出现i的次数为：更高位数字x当前位数
	 * 当某一位的数字等于i时，那么该位出现i的次数为：更高位数字x当前位数+低位数字+1
	 * 当某一位的数字大于i时，那么该位出现i的次数为：(更高位数字+1)x当前位数
	 * @param k
	 * @param n
	 * @return
	 */
    public int digitCounts(int k, int n) {
        // write your code here
    	int base = 1;
    	int count = 0;
    	int low = 0;
    	while(n > 0){
    		int digit = n % 10;
    		int high = n / 10;
    		if(digit < k){
    			count += high * base;
    		}else if(digit == k){
    			count += high * base + low + 1;
    		}else{
    			//special when k = 0; cannot have 0 on the highest bit
    			if(k == 0 && high == 0){
    				
    			}else{
    				count += (high + 1) * base;
    			}
    		}
    		
    		low += digit * base;
    		base *= 10;
    		n /= 10;
    	}
    	
    	return count;        
    }
}
