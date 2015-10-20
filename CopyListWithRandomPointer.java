import java.util.HashMap;
import java.util.Map;


public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * O(n) space solution
	 * @param head
	 * @return
	 */
    public RandomListNode copyRandomList2(RandomListNode head) {
        // write your code here
        Map<Integer, RandomListNode> map = new HashMap();
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        RandomListNode copy = head;
        while(copy != null){
            cur.next = new RandomListNode(copy.label);
            cur = cur.next;
            map.put(cur.label, cur);

            copy = copy.next;
        }
        
        cur = dummy.next;
        copy = head;
        while(copy != null){
            if(copy.random != null){
                cur.random = map.get(copy.random.label);
            }
            
            copy = copy.next;
            cur = cur.next;
        }
        
        return dummy.next;
    }

	
	/**
	 * O(n) time and O(1) space solution
	 * @param head
	 * @return
	 */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        
        //generate duplicate node list
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode dup = new RandomListNode(cur.label);
            dup.next = cur.next;
            cur.next = dup;
            cur = cur.next.next;
        }
        
        //point random of dup nodes to correct nodes
        cur = head;
        while(cur != null){
            RandomListNode dup = cur.next;
            if(cur.random != null){
                dup.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        //split the list
        cur = dummy;
        while(cur.next != null){
            cur.next = cur.next.next;
            cur = cur.next;
        }
        
        return dummy.next;
        
    }


}
