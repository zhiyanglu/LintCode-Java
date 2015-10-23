/**
 * Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing.
 * You should keep the tree still a binary search tree after removal.
 * @author Lu
 *
 */
public class RemoveNodeInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	

    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        return remove(root, value);
    }
    
    private TreeNode remove(TreeNode root, int val){
        if(root == null) return null;
        
        if(root.val < val){
            root.right = remove(root.right, val);
        }else if(root.val > val){
            root.left = remove(root.left, val);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            
            //both left and right has a sub tree
            //do right rotation, let right child be the sub tree of the most right child of left child
            TreeNode left = root.left;
            TreeNode leftmostright = left;
            TreeNode right = root.right;
            while(leftmostright.right != null){
                leftmostright = leftmostright.right;
            }
            leftmostright.right = right;
            return left;
        }
        
        return root;
    }


}
