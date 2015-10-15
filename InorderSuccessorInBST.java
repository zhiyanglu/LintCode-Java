import java.util.Stack;


public class InorderSuccessorInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        //if p.right != null, find left most node if p.right
        //if p.right == null
        //find the node that node.val > p.val && node.left.val < node.val
        if(root == null || p == null) return null;
        
        if(p.right != null){
            TreeNode node = p.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(root.val != p.val){
            s.push(root);
            if(root.val > p.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.val > p.val){
                return node;
            }
        }
        
        return null;
        
    }


}
