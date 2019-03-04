import java.util.List;

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head,slow=head;
        if(null == fast) return fast;
        for(int i=0;i<n;i++) {
            fast=fast.next;
        }
        while(fast!=null) {
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        RemoveNthNode n = new RemoveNthNode();
        n.removeNthFromEnd(node,2);
    }
}
