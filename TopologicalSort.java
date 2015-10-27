import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraphNode a = new DirectedGraphNode(0);
		DirectedGraphNode b = new DirectedGraphNode(1);
		DirectedGraphNode c = new DirectedGraphNode(2);
		DirectedGraphNode d = new DirectedGraphNode(3);
		DirectedGraphNode e = new DirectedGraphNode(4);
		e.neighbors.add(b);
		e.neighbors.add(c);
		e.neighbors.add(d);
		e.neighbors.add(e);
		
		TopologicalSort solution = new TopologicalSort();
		ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>();
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);

		ArrayList<DirectedGraphNode> res = solution.topSort(graph);
		for(DirectedGraphNode node : res){
			System.out.println(node.label);
		}
	}
	
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        Map<DirectedGraphNode, Integer> map = new HashMap();
        ArrayList<DirectedGraphNode> res = new ArrayList();

        for(DirectedGraphNode parent : graph){
            for(DirectedGraphNode child : parent.neighbors){
                if(map.containsKey(child)){
                    map.put(child, map.get(child) + 1);
                }else{
                    map.put(child, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                q.add(node);
            }
        }
        
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            res.add(node);
            for(DirectedGraphNode child : node.neighbors){
                map.put(child, map.get(child) - 1);
                if(map.get(child) == 0){
                    map.remove(child);
                    q.add(child);
                }
            }
        }
        
        return res;
    }
}
