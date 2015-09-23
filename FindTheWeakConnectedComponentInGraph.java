import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FindTheWeakConnectedComponentInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    Map<Integer, Integer> map;
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes){
        map = new HashMap<Integer, Integer>();
        List<List<Integer>> res = new ArrayList();
        Collections.sort(nodes, new Comparator<DirectedGraphNode>(){
                public int compare(DirectedGraphNode o1, DirectedGraphNode o2){
                    return o1.label - o2.label;
                }
            });

        init(nodes);

        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode child : node.neighbors){
                union(node.label, child.label);
            }
        }

        Map<Integer, List<Integer>> lists = new HashMap();
        for(DirectedGraphNode node : nodes){
            int parent = findParent(node.label);
            if(lists.containsKey(parent)){
                lists.get(parent).add(node.label);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.label);
                res.add(list);
                lists.put(parent, list);
            }
        }
        
        return res;
        
    }
    private void init(ArrayList<DirectedGraphNode> nodes){
        for(DirectedGraphNode node : nodes){
            map.put(node.label, node.label);
        }

    }
    private int findParent(int label){
        int parent = map.get(label);
        while(parent != map.get(parent)){
            parent = map.get(parent);
        }
        return parent;
    }
    private void union(int label1, int label2){
        int parent1 = findParent(label1);
        int parent2 = findParent(label2);
        if(parent1 != parent2){
            map.put(parent1, parent2);
        }
    }

}
