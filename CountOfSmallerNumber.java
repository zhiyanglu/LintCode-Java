import java.util.ArrayList;


public class CountOfSmallerNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class SegmentTreeNode{
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        int start;
        int end;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            count = 0;
        }
    }
	/**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        SegmentTreeNode root = build(0, 10000);
        for(int i = 0; i < A.length; i++){
            set(root, A[i]);
        }
        for(Integer query : queries){
            res.add(query(root, 0, query-1));
        }
        
        return res;
        
    }
    public SegmentTreeNode build(int start, int end){
        if(start == end){
            return new SegmentTreeNode(start, end);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        int mid = (start + end) / 2;
        root.left = build(start, mid);
        root.right = build(mid+1, end);
        
        return root;
    }
    public void set(SegmentTreeNode root, int index){
        if(root.start == index && root.end == index){
            root.count++;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if(index <= mid){
            set(root.left, index);
        }else{
            set(root.right, index);
        }
        root.count = root.left.count + root.right.count;
    }
    public int query(SegmentTreeNode root, int start, int end){
        if(root == null || start > root.end || end < root.start) return 0;
        if(start == root.start && end == root.end){
            return root.count;
        }
        
        int mid = (root.start + root.end) / 2;
        if(start > mid){
            return query(root.right, start, end);
        }else if(end <= mid){
            return query(root.left, start, end);
        }else{
            int left = query(root.left, start, mid);
            int right = query(root.right, mid+1, end);
            return left+right;
        }
    }


}
