/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * @author Lu
 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public double findMedianSortedArrays(int[] A, int[] B) {
    	int m = A.length;
    	int n = B.length;
    	if((m + n) % 2 == 1){
    		return findKth(A, 0, B, 0, (m+n) / 2 + 1);
    	}else{
    		return (findKth(A, 0, B, 0, (m+n) / 2) + findKth(A, 0, B, 0, (m+n) / 2 + 1)) / 2.0;
    	}
    }
    
    private int findKth(int[] A, int A_start, int[] B, int B_start, int k){
    	
    	//there are no left elements in A/B
    	if(A_start >= A.length){
    		return B[B_start + k - 1];
    	}
    	if(B_start >= B.length){
    		return A[A_start + k - 1];
    	}
    	if(k == 1){
    		return Math.min(A[A_start], B[B_start]);
    	}
    	
    	//find the number after move k / 2 in A and B
    	//if A_key is smaller, could at least move k / 2 in A
    	//if B_key is smaller, could at least move k / 2 in B
    	int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
    	int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
    	
    	if(A_key < B_key){
    		return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
    	}else{
    		return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    	}
    }
}
