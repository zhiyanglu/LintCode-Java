import java.util.ArrayList;


public class IntervalSum {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		IntervalSum solution = new IntervalSum();
		int[] A = {1, 2, 7, 8, 5};
		ArrayList<Interval> queries = new ArrayList();
		queries.add(new Interval(1,2));
		System.out.println(new IntervalSum().intervalSum(A, queries));
		
	}
	
    class SegmentTreeNode{
        SegmentTreeNode left;
        SegmentTreeNode right;
        long val;
        int start;
        int end;
        public SegmentTreeNode(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> res = new ArrayList<Long>();
        SegmentTreeNode root = build(0, A.length-1, A);
        for(Interval interval : queries){
            long num = query(root, interval.start, interval.end);
            res.add(num);
        }
        
        return res;
    }
    private SegmentTreeNode build(int start, int end, int[] A){
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        int mid = (start + end) / 2;
        
        root.left = build(start, mid, A);
        root.right = build(mid + 1, end, A);
        
        root.val = root.left.val + root.right.val;
        return root;
    }
    private long query(SegmentTreeNode root, int start, int end){
        if(root == null || start > root.end || end < root.start) return 0;

        if(start == root.start && end == root.end){
            return root.val;
        }
        
        int mid = (root.start + root.end) / 2;
        if(end <= mid){
            return query(root.left, start, end);
        }else if(start > mid){
            return query(root.right, start, end);
        }else{
            long left = query(root.left, start, mid);
            long right = query(root.right, mid+1, end);
            return left + right;
        }
    }


}
