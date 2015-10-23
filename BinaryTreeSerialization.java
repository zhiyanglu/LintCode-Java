import java.util.Stack;

/**
 * Refer: http://articles.leetcode.com/2010/09/serializationdeserialization-of-binary.html
 * 
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is 
 * called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 * 
 * There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a 
 * binary tree to a string and deserialize this string to the original structure.
 * 
 * @author Lu
 *
 */
public class BinaryTreeSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	}

	


    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node == null){
                sb.append("# ");
            }else{
                sb.append(node.val + " ");
                s.push(node.right);
                s.push(node.left);
            }
        }
        
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] vals = data.split("\\s+");
        Stack<String> s = new Stack<String>();
        for(int i = vals.length-1; i >= 0; i--){
            s.push(vals[i]);
        }
        return build(s);
    }
    
    private TreeNode build(Stack<String> s){
        if(s.isEmpty()) return null;
        String val = s.pop();
        if(val.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(s);
        root.right = build(s);
        
        return root;
    }

}
