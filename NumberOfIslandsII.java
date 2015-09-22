import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NumberOfIslandsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    Map<Integer, Integer> parent;
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(operators == null || operators.length == 0) return res;

    	parent = new HashMap<Integer, Integer>();
        init(n, m);
        
        int[][] area = new int[n][m];
        int cur_island = 0;
        for(Point point : operators){
            int x = point.x;
            int y = point.y;

        	if(area[x][y] == 1) continue;

            area[x][y] = 1;
            int id = getid(x, y, m);
            cur_island++;
            
            cur_island = operate(area, x-1, y, n, m, cur_island, id);
            cur_island = operate(area, x+1, y, n, m, cur_island, id);
            cur_island = operate(area, x, y-1, n, m, cur_island, id);
            cur_island = operate(area, x, y+1, n, m, cur_island, id);
            
            res.add(cur_island);
        }
        
    	return res;
    }
    /**
     * check the edge of the new add island
     * if it is not connected with near island, union two island and cur_island--
     */
    private int operate(int[][] area, int x, int y, int n, int m, int cur_island, int id){
        if(x < 0 || x >= n || y < 0 || y >= m || area[x][y] == 0){
            return cur_island;
        }
        int edge_id = getid(x, y, m);
        if(!isConnected(id, edge_id)){
            union(id, edge_id);
            cur_island--;
        }
        return cur_island;
    }
    /**
     * set up each point its initial parent as itself
     */
    private void init(int n, int m){
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                int id = getid(i, j,m);
                parent.put(id,id);
            }
        }
    }
    /**
     * return the root parent
     */
    private int findParent(int id){
        int par = parent.get(id);
        while(par != parent.get(par)){
            par = parent.get(par);
        }
        return par;
    }
    /**
     * union two point
     */
    private void union(int idx, int idy){
        int parent_x = findParent(idx);
        int parent_y = findParent(idy);
        if(parent_x != parent_y){
            parent.put(parent_x, parent_y);
        }
    }
    /**
     * check if two points have the same root
     */
    private boolean isConnected(int idx, int idy){
        int parent_x = findParent(idx);
        int parent_y = findParent(idy);
        return parent_x == parent_y;
    }
    /**
     * return a unique id of one point
     */
    private int getid(int x, int y, int m){
        return x*m+y;
    }


}
