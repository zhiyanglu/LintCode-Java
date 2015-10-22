import java.util.HashMap;
import java.util.Map;

public class LRUCache {


	public static void main(String[] args){
		LRUCache c = new LRUCache(3);
		c.set(33, 219);
		System.out.println(c.get(39));
		c.set(96,56);
		System.out.println(c.get(129));
		System.out.println(c.get(115));
		System.out.println(c.get(112));
		c.set(3, 280);
		System.out.println(c.get(40));
		c.set(85,193);
		
	}
	
    class CacheNode{
        int val;
        int key;
        CacheNode next;
        CacheNode prev;
        CacheNode(int val, int key){
            this.val = val;
            this.key = key;
        }
    }
    // @param capacity, an integer
    Map<Integer, CacheNode> map;
    CacheNode least;
    CacheNode most;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        // write your code here
        map = new HashMap();
        least = new CacheNode(0, 0);
        most = new CacheNode(0, 0);
        least.next = most;
        most.prev = least;
        
        this.capacity = capacity;
        size = 0;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)){
            CacheNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            node.next = most;
            node.prev = most.prev;
            most.prev = node;
            node.prev.next = node;
            
            return node.val;
        }else{
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)){
            map.get(key).val = value;
            get(key);
        }else{
            if(size == capacity){
                int remove_key = least.next.key;
                CacheNode remove_node = least.next;
                least.next = remove_node.next;
                remove_node.next.prev = least;
                map.remove(remove_key);
                size--;
            }
            CacheNode node = new CacheNode(value, key);
            map.put(key, node);
            node.next = most;
            node.prev = most.prev;
            most.prev = node;
            node.prev.next = node;
            size++;
        }
    }

}
