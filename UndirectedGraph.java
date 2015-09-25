import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class UndirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		UndirectedGraphNode n4 = new UndirectedGraphNode(4);
		UndirectedGraphNode n5 = new UndirectedGraphNode(5);
		n1.neighbors.add(n2);
		n1.neighbors.add(n4);
		n2.neighbors.add(n1);
		n2.neighbors.add(n4);
		n4.neighbors.add(n1);
		n4.neighbors.add(n2);
		n3.neighbors.add(n5);
		n5.neighbors.add(n3);
		ArrayList<UndirectedGraphNode> nodes = new ArrayList();
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);

		System.out.println(new UndirectedGraph().connectedSet(nodes));
		
	}
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
    	
        Set<Integer> explored  = new HashSet<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(UndirectedGraphNode node : nodes){
            
            if(explored.contains(node.label)) continue;
            
            List<Integer> list = new ArrayList<Integer>();
            Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
            q.add(node);
            while(!q.isEmpty()){
                UndirectedGraphNode n = q.poll();
                explored.add(n.label);
                list.add(n.label);
                for(UndirectedGraphNode child : n.neighbors){
                    if(explored.contains(child.label)) continue;
                    q.add(child);
                }
            }
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }

}
