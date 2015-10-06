import java.util.Comparator;
import java.util.PriorityQueue;


public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	class Point{
		int x;
		int y;
		int val;
		Point(int x, int y, int val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	/**
	 * 1) Build a min heap of elements from first row. A heap entry also stores row number and column number.
	 * 2) Do following k times.
	 * 		a) Get minimum element (or root) from min heap.
	 * 		b) Find row number and column number of the minimum element.
	 * 		c) Replace root with the next element from same column and min-heapify the root.
	 * 3) Return the last extracted root.
	 * @param matrix
	 * @param k
	 * @return
	 */
    public int kthSmallest(int[][] matrix, int k) {
    	 if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
             return 0;
         }
    	 if (k > matrix.length * matrix[0].length) {
             return 0;
         }
    	 
    	 int m = matrix.length;
    	 int n = matrix[0].length;
    	 
    	 PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>(){
    		 public int compare(Point o1, Point o2){
    			 return o1.val - o2.val;
    		 }
    	 });
    	 
    	 for(int i = 0; i < n; i++){
    		 pq.add(new Point(0, i, matrix[0][i]));
    	 }
    	 while(--k > 0){
    		 Point p = pq.poll();
    		 if(p.x < m - 1){
    			 pq.add(new Point(p.x+1, p.y, matrix[p.x+1][p.y]));
    		 }
    	 }
    	 return pq.poll().val;
    	 
    	 
    	
    	 
    }
    
    


}
