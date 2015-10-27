
public class ReverseNodeInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode cur = head;
		for(int i = 2; i <= 5; i++){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		
		ReverseNodeInKGroup solution = new ReverseNodeInKGroup();
		solution.reverseKGroup(head, 2);
		
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode prev = start;
        while(prev.next != null){
            ListNode cur = prev.next;
            int count = k;
            while(--count > 0){
                cur = cur.next;
            	if(cur == null){
                    return start.next;
                }
            }

            
            cur = prev.next;
            prev.next = reverse(cur, k);
            prev = cur;
        }
        
        return start.next;
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode last = head;
        while(--k > 0){
            ListNode first = last.next;
            last.next = first.next;
            first.next = start.next;
            start.next = first;
        }
        
        return start.next;
    }


}
