import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		new BinaryTreeLevelOrderTraversal().levelOrder(root);

	}

	
    class LevelNode{
        TreeNode node;
        int level;
        public LevelNode(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    //Iterative
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root == null) return res;
        
        Queue<LevelNode> q = new LinkedList<LevelNode>();
        q.add(new LevelNode(root, 0));
        int cur_level = -1;
        while(!q.isEmpty()){
            LevelNode cur = q.poll();
            if(cur.level > cur_level){
                cur_level++;
                ArrayList<Integer> list = new ArrayList();
                res.add(list);
            }
            res.get(cur_level).add(cur.node.val);
            if(cur.node.left != null){
                q.add(new LevelNode(cur.node.left, cur.level+1));
            }
            if(cur.node.right != null){
                q.add(new LevelNode(cur.node.right, cur.level+1));
            }
        }
        
        return res;
    }
}
