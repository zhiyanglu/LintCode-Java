import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.
 * @author Lu
 *
 */
public class MatrixZigzagTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // write your code here
	}
	
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] res = new int[m * n];
        boolean dir = true;// true to right, false to left;
        int x = 0;
        int y = 0;
        res[0] = matrix[0][0];
        for(int i = 1; i < res.length; i++){
                

            if(dir){
                if(x > 0 && y < n - 1){
                    x--;
                    y++;
                }else if(x == 0 && y < n - 1){
                    y++;
                    dir = false;
                }else{
                    dir = false;
                    x++;
                }
            }else{
                if(x < m - 1 && y > 0){
                    x++;
                    y--;
                }else if(x == m - 1 && y < n - 1){
                    y++;
                    dir = true;
                }else{
                    x++;
                    dir = true;
                }
            }
            
            res[i] = matrix[x][y];
        }
        
        return res;
    }

}
