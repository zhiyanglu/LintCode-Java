/**
 * hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 
 *                  = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
 *					= 3595978 % HASH_SIZE
 * @author Lu
 *
 */
public class HashFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if (key.length==0) return 0;
        int res = 0;
        int base = 1;
        for (int i = key.length - 1; i >= 0; i--){
            
            res += modMultiply((int)key[i], base, HASH_SIZE);;
            res %= HASH_SIZE;
            
            base = modMultiply(base, 33, HASH_SIZE);
        }
        return res;
    }

    /**
     * (a + b) % p = (a % p + b % p) % p
     * (a - b) % p = (a % p - b % p) % p
     * (a * b) % p = (a % p * b % p) % p
     *  a ^ b % p = ((a % p)^b) % p
     */
    public int modMultiply(long a, long b, int HASH_SIZE){        
        long temp = a*b%HASH_SIZE;
        return (int) temp;
    }
}
